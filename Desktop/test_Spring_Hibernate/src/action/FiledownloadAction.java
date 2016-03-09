package action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FiledownloadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public InputStream getDownloadFile() throws FileNotFoundException 
	{
		LoginAction la = new LoginAction();
		//windows
		//String root = ServletActionContext.getServletContext().getRealPath("/upload")+"\\"+la.username+"\\";
		//linux
		String root = ServletActionContext.getServletContext().getRealPath("/upload")+"/"+la.username+"/";
		String param = ServletActionContext.getRequest().getParameter("fn");
		this.filename = param;
		System.out.println("file :"+root+param);
		//windows
		//String path = "/upload/"+la.username+"\\"+param;
		//linux,however we donot support chn in filename
		String path = "/upload/"+la.username+"/"+param;
		return ServletActionContext.getServletContext().getResourceAsStream(path);
	}
	public String execute()
	{		
		return SUCCESS;
	}
}
