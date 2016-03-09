package util_test;


import model.Person;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.RegisterBizImpl;

public class TestContainerDAOImpl {
	private ApplicationContext ctx = null;
	private RegisterBizImpl registerbizimpl = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		registerbizimpl = ctx.getBean(biz.RegisterBizImpl.class);		
	}
	
	
	
	@Test
	public void test() {
		System.out.println("ctx :"+ctx);
		System.out.println("registerbizimpl :"+registerbizimpl);
		Person person = new Person();
		person.setEmail("820096567@qq.com");
		person.setPassword("1234");
		person.setContainerid(1);
		person.setUsername("tangxinchen");
		person.setId(1);
		registerbizimpl.Register(person);
		
		
	}

}
