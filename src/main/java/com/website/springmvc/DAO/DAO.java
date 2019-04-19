package com.website.springmvc.DAO;

import java.util.List;

public abstract class DAO<E> {

	public abstract List<E> getAll(Integer offset);

	public abstract E getById(Long id);

	public abstract E getByName(String name);

	public abstract E add(E e);

	public abstract Boolean update(E e);

	public abstract Boolean delete(E e);

	public abstract Boolean deleteById(Long id);

}
