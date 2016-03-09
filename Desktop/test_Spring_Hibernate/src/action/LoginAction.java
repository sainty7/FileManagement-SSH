package action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.Files;
import model.Person;
import biz.FilelistBiz;
import biz.LoginBiz;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	static String username;
	private Map<String,String> filemap;
		
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		LoginAction.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "LoginAction [email=" + email + ", password=" + password + "]";
	}
	
	LoginBiz loginbiz;	
	public void setLoginbiz(LoginBiz loginbiz) {
		this.loginbiz = loginbiz;
	}
	
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
		
	public String execute()
	{
		System.out.println(this.toString());
		Person person = new Person();
		person.setEmail(this.getEmail());
		person.setPassword(this.getPassword());
		Map result = loginbiz.login(person);
		Person person_db = (Person) result.get("person");
		this.setUsername(person_db.getUsername());
		
		//transfer filemap to list.jsp
		Set<Files> files = filelistbiz.showfiles(person_db.getUsername());
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
		System.out.println("------------------------------------"+this.getFilemap());

		if(result.get("key").equals("true"))
		{
			return SUCCESS;
		}
		return ERROR;		
	}
	
	

}
