package biz;


import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.ContainerDAO;
import dao.PersonDAO;
import model.Container;
import model.Person;
@Service
public class RegisterBizImpl implements RegisterBiz {
	
	PersonDAO persondao;
	public void setPersondao(PersonDAO persondao) {
		this.persondao = persondao;
	}

	ContainerDAO containerdao;
	public void setContainerdao(ContainerDAO containerdao) {
		this.containerdao = containerdao;
	}


	public void Register(Person person) {
		// TODO Auto-generated method stub
		
		System.out.println(person);
		List list = containerdao.getID(person.getContainerid());
		if(list!=null && list.size()>0)
		{
			Container container = (Container) list.get(0);
			person.setContainer(container);
			container.getPerson_set().add(person);
			containerdao.save(container);
			
		}else
		{
			Container container = new Container();
			container.setId(person.getContainerid());
			container.setContainerid(person.getContainerid());
			person.setContainer(container);
			container.getPerson_set().add(person);
			containerdao.save(container);
		}	
	}

}
