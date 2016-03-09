package action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.Files;
import biz.FilelistBiz;

import com.opensymphony.xwork2.ActionSupport;

public class Return2listAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	

	@Override
	public String execute()
	{
		System.out.println("-------------return to list model start-------------------------");
		LoginAction la = new LoginAction();
		this.setUsername(la.username);
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
