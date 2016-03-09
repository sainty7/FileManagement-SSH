package biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dao.PersonDAO;
import model.Person;
@Service
public class LoginBizImpl implements LoginBiz {
	
	PersonDAO persondao;
	
	public void setPersondao(PersonDAO persondao) {
		this.persondao = persondao;
	}

	@Override
	public Map<String, Object> login(Person person) 
	{
		List list = persondao.getEmail(person.getEmail());
		Person person_db = (Person) list.get(0);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("person", person_db);
		
		if(person_db.getPassword().equals(person.getPassword()))
		{
			result.put("key", "true");
		}
		else{
			result.put("key", "false");			
		}
		return result;
	}

}
