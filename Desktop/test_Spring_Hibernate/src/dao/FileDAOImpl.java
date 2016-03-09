package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Files;

public class FileDAOImpl implements FileDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}	
	@Override
	public void save(Files file) {
		// TODO Auto-generated method stub
		System.out.println("session :"+this.getSession());
		Session session = this.getSession();
		session.save(file);

	}

	@Override
	public List get(int x) {
		Session session = this.getSession();
		String hql = "from Files files where files.id=:fileID";
		Query query = session.createQuery(hql);
		query.setInteger("fileID", x);
		List list = query.list();
		return list;
	}

	@Override
	public void update(Files file) {
		Session session = this.getSession();
		session.update(file);
	}

	@Override
	public void delete(Files file) {
		Session session = this.getSession();
		session.delete(file);
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM Files files WHERE files.id=:fileID";
		getSession().createQuery(hql).setInteger("fileID", id).executeUpdate();
	}


}
