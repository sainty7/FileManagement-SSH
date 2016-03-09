package util_test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class TestSessionFactory {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
	@Test
	public void test() {
		System.out.println("sessionFactory :"+sf);
	}

}
