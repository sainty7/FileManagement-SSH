package model;

import java.util.HashSet;
import java.util.Set;





public class Person {
	private int id;
	private String username;
	private String email;
	private String password;
	private int containerid;
	private Container container;
	private Set<Files> files_set = new HashSet<Files>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	
	public Set<Files> getFiles_set() {
		return files_set;
	}
	public void setFiles_set(Set<Files> files_set) {
		this.files_set = files_set;
	}
	
	public int getContainerid() {
		return containerid;
	}
	public void setContainerid(int containerid) {
		this.containerid = containerid;
	}
	
	
}
