package util_test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
@Repository
public class BasicHibernateDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(Object object) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Transaction tc = null; 
		try {
			tc = session.beginTransaction();
			session.save(object);
			tc.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (tc != null)
			{
				tc.rollback();
			}
			e.printStackTrace();
		}finally
		{
			session.close();
		}
	}

	public void update(Object object) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(object);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public Object get(Class cla,int x) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Object object = session.get(cla,x);
		tx.commit();
		return object;			
	}

	public void delete(Object object) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(object);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
