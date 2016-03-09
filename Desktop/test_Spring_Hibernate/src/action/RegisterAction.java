package action;

import model.Person;
import biz.RegisterBiz;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String confirm;
	private String email;
	private int containerid;
	private String teacher;
	
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getContainerid() {
		return containerid;
	}
	public void setContainerid(int containerid) {
		this.containerid = containerid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	RegisterBiz registerbiz;
	public void setRegisterbiz(RegisterBiz registerbiz) {
		this.registerbiz = registerbiz;
	}
	

	@Override
	public String toString() {
		return "RegisterAction [username=" + username + ", password="
				+ password + ", confirm=" + confirm + ", email=" + email
				+ ", containerid=" + containerid + "]";
	}
	public String execute()
	{
		
		System.out.println(this.toString());
		if(password.equalsIgnoreCase(confirm))
		{
		if (this.getTeacher().equals("wangwennai"))
		{
			this.setContainerid(1);
		}
		Person person = new Person();
		person.setUsername(this.getUsername());
		person.setPassword(this.getPassword());
		person.setContainerid(this.getContainerid());
		person.setEmail(this.getEmail());
		this.registerbiz.Register(person);
		return SUCCESS;
		}
		return ERROR;
	}
	
	
	
	
	
	
	
}
