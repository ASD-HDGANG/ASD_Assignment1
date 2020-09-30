package smartcardDemo.model.dao;

import java.util.List;

public interface IGenericDAO<T> {
	public T create(T t);

	public T update(T t);

	public T get(Object id);

	public void delete(Object id);

	public List<T> listAll();

	public Long count();
}
