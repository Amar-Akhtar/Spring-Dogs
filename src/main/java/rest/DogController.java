package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Dog;



@RestController
@RequestMapping("/dog")
public class DogController {

	private DogService dogService;
	
	public DogController(DogServive dogService) {
		this.dogService = dogService;
	}
	
	
	//Create
	@PostMapping("/createDog")
	public ResponseEntity<Dog> createDog(@RequestBody Dog a){
		return new ResponseEntity<Dog>(this.dogService.create(a), HttpStatus.CREATED);
	}
	
	//Read
	@GetMapping("/getDog")
	public ResponseEntity<List<Dog>> getDog(){
		return new ResponseEntity<List<Dog>>(this.dogService.getAll(), HttpStatus.OK);
	}
	
	//Read-By-ID
	@GetMapping(".getId/{id}")
	public ResponseEntity<Dog> getID(@PathVariable Long id){
		return new ResponseEntity<Dog>(this.dogService.getById(id), HttpStatus.FOUND);
	}
	
	//Update
	@PutMapping("/updateDog/{id}")
	public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog b){
		return new ResponseEntity<Dog>(this.dogService.update(id, b), HttpStatus.OK);
		
	}
	
	//Delete
	@DeleteMapping("/deleteDog/{id}")
	public ResponseEntity<Dog> deleteDog(@PathVariable Long id){
		return new ResponseEntity<Dog>(this.dogService.delete(id));
		
	}
	
	
}
