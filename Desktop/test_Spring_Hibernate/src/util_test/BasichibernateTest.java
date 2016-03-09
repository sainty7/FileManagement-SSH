package util_test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.Container;
import model.Files;
import model.Person;

public class BasichibernateTest extends BasicHibernateDAO{

	public void save (Object obj)
	{
		super.save(obj);
	}
	public Container get(int x)
	{
		return (Container)super.get(Container.class, x);
	}
	
	
	public static void main(String[] args)
	{
			BasichibernateTest ts = new BasichibernateTest();

			Container container = new Container();
			container.setId(1);
			container.setContainerid(111);
			
			Person person1 = new Person();
			person1.setId(1);
			person1.setUsername("xiaoming");
			person1.setEmail("xinchen@intel.com");
			person1.setPassword("1234");

			Files file1 = new Files();
			file1.setId(1);
			file1.setName("Java");
			file1.setNote("Is intersting");
			
			file1.setPerson(person1);
			person1.getFiles_set().add(file1);
			person1.setContainer(container);
			container.getPerson_set().add(person1);
			
			ts.save(container);
			System.out.println("ok");
			
		
	}
}
