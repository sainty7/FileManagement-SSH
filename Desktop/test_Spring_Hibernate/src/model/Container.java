package model;

import java.util.HashSet;



import java.util.Set;


public class Container {
	private int id;
	private int containerid;
	private Set<Person> person_set = new HashSet<Person>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getContainerid() {
		return containerid;
	}
	public void setContainerid(int containerid) {
		this.containerid = containerid;
	}
	
	
	public Set<Person> getPerson_set() {
		return person_set;
	}
	public void setPerson_set(Set<Person> person_set) {
		this.person_set = person_set;
	}


	
}
