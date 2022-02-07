package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import domain.Dog;
import repo.DogRepo;

@Service
public class DogService implements CRUDInterface<Dog> {

	private DogRepo repo;
	
	public DogService(DogRepo repo) {
		this.repo = repo;
		
	}
	
	//Create
	@Override
	public Dog create(Dog t) {
		return this.repo.save(t);
	}
	
	//Read
	@Override
	public List<Dog> getAll(){
		return this.repo.findAll();
	}
	
	//Read-By Id
	public Dog getById(Long id) {
		Optional<Dog> optDog = this.repo.findById(id);
		return optDog.get();	
	}
	
	//Update
	@Override
	public Dog update(Long id, Dog t) {
		Optional<Dog> optDog = this.repo.findById(id);
		if(optDog.isPresent()) {
			Dog existingDog = optDog.get();
			existingDog.setName(t.getName());
			existingDog.setAge(t.getAge());
			return this.repo.save(existingDog);
		}
		return null;
	}
	
	//Delete
	@Override
	public Dog delete(Long id) {
		Optional<Dog> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}
}
