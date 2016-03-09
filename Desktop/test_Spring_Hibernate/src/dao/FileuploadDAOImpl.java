package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Files;

public class FileuploadDAOImpl implements FileuploadDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrUpdate(Files file) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(file);
	}

}
