package action;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.Files;

import org.apache.struts2.ServletActionContext;











import biz.FilelistBiz;
import biz.FileuploadBiz;
import biz.LoginBiz;

import com.opensymphony.xwork2.ActionSupport;

public class FileuploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String note;
	private File attachement;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public File getAttachement() {
		return attachement;
	}
	public void setAttachement(File attachement) {
		this.attachement = attachement;
	}
	
	
	
	private String attachementFileName;
	private String attachementContentName;
			
	public String getAttachementFileName() {
		return attachementFileName;
	}
	public void setAttachementFileName(String attachementFileName) {
		this.attachementFileName = attachementFileName;
	}
	public String getAttachementContentName() {
		return attachementContentName;
	}
	public void setAttachementContentName(String attachementContentName) {
		this.attachementContentName = attachementContentName;
	}

	public Map<String,String> filemap;
	public Map<String, String> getFilemap() {
		return filemap;
	}
	public void setFilemap(Map<String, String> filemap) {
		this.filemap = filemap;
	}
	
	FilelistBiz filelistbiz;
	public void setFilelistbiz(FilelistBiz filelistbiz) {
		this.filelistbiz = filelistbiz;
	}


	FileuploadBiz fileuploadbiz;	
	public void setFileuploadbiz(FileuploadBiz fileuploadbiz) {
		this.fileuploadbiz = fileuploadbiz;
	}
	
	public void fileuploadsave()
	{
		LoginAction la = new LoginAction();
		this.setUsername(la.username);
		Files file = new Files();
		file.setName(this.getAttachementFileName());
		file.setNote(this.getNote());
		Map<String,Object> file_map = new HashMap<String,Object>();
		file_map.put("file", file);
		file_map.put("username",this.getUsername());
		this.fileuploadbiz.fileupload(file_map);
	}
	
	
	public String execute()
	{
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			LoginAction la = new LoginAction();
			this.setUsername(la.username);
			String root = ServletActionContext.getServletContext().getRealPath("/upload")+"/"+la.username;
        /*	windows
         *  String root = ServletActionContext.getServletContext().getRealPath("/upload")+"\\"+la.username;
			String path = "cmd /c mkdir "+root;
			Runtime.getRuntime().exec(path);	
			System.out.println("file_persistent_path :"+path);
		*/
	        //linux
			File file = new File(root);
			file.mkdirs();
			//
			System.out.println("file_persistent_path :"+root);
			System.out.println("filename :"+this.getAttachementFileName());
			System.out.println("file_temp_name :"+this.getAttachement().getName());
			System.out.println("file_temp_path :"+attachement.getPath());

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			os = new FileOutputStream(new File(root,this.getAttachementFileName()));
			is = new FileInputStream(attachement);		
			byte[] buffer = new byte[500];
			while(-1 != is.read(buffer,0,buffer.length))
			{
				os.write(buffer);
			}			
			os.close();
			is.close();
			this.fileuploadsave();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//transfer filemap to list.jsp
		Set<Files> files = filelistbiz.showfiles(this.getUsername());
		Map<String,String> files_map = new HashMap<String,String>();
		Iterator<Files> it = files.iterator();
		while(it.hasNext())
		{
			Files tmp = it.next();
			String filename = tmp.getName().toString();
			String filenote = tmp.getNote().toString();
			System.out.println("filename :"+filename);
			System.out.println("filenote :"+filenote);
			files_map.put(filename, filenote);
		}
		this.setFilemap(files_map);
		return SUCCESS;
	}
	


}
