package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import model.Container;
import model.Person;


public class PersonDAOImpl implements PersonDAO {


	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public void save(Person person) 
	{
		Session session = this.getSession();
		session.save(person);
	}



	public void update(Person person) {

		Session session = this.getSession();	
		session.update(person);
	}


	public List getEmail(String email) {
		Session session = this.getSession();
		String hql = "from Person person where person.email=:Email";
		Query query = session.createQuery(hql);
		query.setString("Email",email);
		List list = query.list();
		return list;			
	}

	public List getUsername(String username)
	{
		Session session = this.getSession();
		String hql = "from Person person where person.username=:Username";
		Query query = session.createQuery(hql);
		query.setString("Username", username);
		List list = query.list();
		return list;
	}
	
	
	

	public void delete(Person person) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(person);
	}
	
}
