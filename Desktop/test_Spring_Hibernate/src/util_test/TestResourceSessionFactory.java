package util_test;

import static org.junit.Assert.*;


import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class TestResourceSessionFactory {


	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Test
	public void test() {
		
		System.out.println("sessionFactory :"+this.sessionFactory);
	}

}
