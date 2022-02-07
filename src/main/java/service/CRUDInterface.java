package service;

import java.util.List;

import domain.Dog;

public interface CRUDInterface<T> {
	
	//Create
	T create(T t);
	
	//Read All
	List<T> getAll();
	
	//Read-By Id
	T getById(Long id);
	
	//Update
	T update(Long id, T t);
	
	//Delete
	Dog delete (Long id);
	
}
