package dao;

import java.util.List;

import model.Container;

public interface ContainerDAO {
	public abstract List getID(int x);
	public abstract void update(Container container);
	public abstract void save(Container container);
	public abstract void delete(Container container);
}
