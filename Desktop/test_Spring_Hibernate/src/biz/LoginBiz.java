package biz;

import java.util.Map;

import model.Person;

public interface LoginBiz {
	public abstract Map<String, Object> login(Person person);
}
