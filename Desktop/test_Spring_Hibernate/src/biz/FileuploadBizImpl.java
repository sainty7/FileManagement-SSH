package biz;

import java.util.Map;

import org.springframework.stereotype.Service;

import dao.FileuploadDAO;
import dao.PersonDAO;
import model.Files;
import model.Person;

@Service
public class FileuploadBizImpl implements FileuploadBiz {

	FileuploadDAO fileuploaddao;
	public void setFileuploaddao(FileuploadDAO fileuploaddao) {
		this.fileuploaddao = fileuploaddao;
	}
	
	PersonDAO persondao;
		public void setPersondao(PersonDAO persondao) {
		this.persondao = persondao;
	}


	@Override
	public void fileupload(Map<String,Object> file_map) {
		
		Person person = (Person)persondao.getUsername((String)file_map.get("username")).get(0);
		Files file = (Files)file_map.get("file");
		file.setPerson(person);
		person.getFiles_set().add(file);
		persondao.save(person);
	}

}
