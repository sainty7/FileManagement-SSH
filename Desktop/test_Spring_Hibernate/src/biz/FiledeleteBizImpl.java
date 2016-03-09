package biz;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import model.Files;
import model.Person;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import dao.FileDAO;
import dao.PersonDAO;

@Service
public class FiledeleteBizImpl implements FiledeleteBiz {

	FileDAO filedao;
	public void setFiledao(FileDAO filedao) {
		this.filedao = filedao;
	}
	PersonDAO persondao;
	public void setPersondao(PersonDAO persondao) {
		this.persondao = persondao;
	}
	public Set<Files> numSum(String username)
	{
		Person person = (Person) persondao.getUsername(username).get(0);
		return person.getFiles_set();
	}
	
	public int numcount(int sum,int index)
	{
		int result;
		result = sum-index;
		return result;
	}
	
	@Override
	public void deleteById(Map<String,Object> temp) throws Exception {
		// TODO Auto-generated method stub
		String username = (String) temp.get("username");
		int index = (Integer) temp.get("index");
		Set<Files> files_set = numSum(username);
		int sum =files_set.size();
		int result = numcount(sum,index);
		Files target_file= (Files)filedao.get(result).get(0);
		String filename = target_file.getName();
		filedao.deleteById(result);
		//we going to del the film on disk
		String root = ServletActionContext.getServletContext().getRealPath("/upload")+"\\"+username;
		String path = "cmd /c del "+root+"\\"+filename;
		System.out.println(path);
		Runtime.getRuntime().exec(path);
	
	
	}

}
