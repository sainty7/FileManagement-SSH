package dao;

import java.util.List;

import model.Person;

public interface PersonDAO {
	public abstract List getEmail(String email);
	public abstract void update(Person person);
	public abstract void save(Person person);
	public abstract void delete(Person person);
	public abstract List getUsername(String username);
}
