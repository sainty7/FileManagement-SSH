package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Container;


public class ContainerDAOImpl implements ContainerDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public List getID(int x) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from Container container where container.id=:containerID";
		Query query = session.createQuery(hql);
		query.setInteger("containerID", x);
		List list = query.list();
		return list;
	}

	@Override
	public void update(Container container) {
		Session session = this.getSession();
		session.update(container);


	}

	@Override
	public void save(Container container) {
		System.out.println("session :"+this.getSession());
		Session session = this.getSession();
		session.save(container);
        
	}

	@Override
	public void delete(Container container) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(container);

	}

}
