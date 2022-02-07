package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="dog")
public class Dog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank(message = "Please enter a name")
	private String name;
	
	@Min(0)
	@Max(20)
	@Column
	private int age;

	public Dog() {
		super();
	}

	//Customer-View
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//Over-Loading
	public Dog(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	//Hashcode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	//To String 
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	
	
	
	

}
