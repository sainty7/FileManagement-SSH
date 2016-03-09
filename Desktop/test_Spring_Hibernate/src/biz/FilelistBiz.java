package biz;

import java.util.Set;

import model.Files;

public interface FilelistBiz {

	public abstract Set<Files> showfiles(String username);
	
}
