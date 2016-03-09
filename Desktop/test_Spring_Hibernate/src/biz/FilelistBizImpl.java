package biz;

import java.util.Set;

import org.springframework.stereotype.Service;

import model.Files;
import model.Person;
import dao.PersonDAO;
@Service
public class FilelistBizImpl implements FilelistBiz {

	PersonDAO persondao;
	public void setPersondao(PersonDAO persondao) {
		this.persondao = persondao;
	}

	@Override
	public Set<Files> showfiles(String username) {
		Person person = (Person)persondao.getUsername(username).get(0);
		return person.getFiles_set();
	}

}
