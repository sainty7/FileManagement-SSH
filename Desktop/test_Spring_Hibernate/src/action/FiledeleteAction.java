package action;


import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import biz.FiledeleteBiz;

import com.opensymphony.xwork2.ActionSupport;

import dao.FileDAO;

public class FiledeleteAction extends ActionSupport {

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

	FiledeleteBiz filedeletebiz;
	public void setFiledeletebiz(FiledeleteBiz filedeletebiz) {
		this.filedeletebiz = filedeletebiz;
	}
	public String execute() throws Exception
	{
		LoginAction la = new LoginAction();
		this.setUsername(la.username);
		int index = Integer.parseInt(ServletActionContext.getRequest().getParameter("num"));
		Map<String ,Object> temp = new HashMap<String,Object>();
		temp.put("username", this.getUsername());
		temp.put("index", index);
		filedeletebiz.deleteById(temp);
		return SUCCESS;
	}
}
