package dao;

import java.util.List;

import model.Files;

public interface FileDAO {
	public abstract void save(Files file);
	public abstract List get(int x);
	public abstract void update(Files file);
	public abstract void delete(Files file);
	public abstract void deleteById(int index);
}
