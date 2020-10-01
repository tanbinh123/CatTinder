package fi.taponen.cattinder.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Breed {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private long breed_id;
	
	@Size(min=2, max=250)
	private String breed_name;
	private String description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "breed")
	private List<Cat> cats;
	
	public Breed() {}

	public Breed(String breed_name, String description, List<Cat> cats) {
		super();
		this.breed_name = breed_name;
		this.description = description;
		this.cats = cats;
	}
	
	public Breed(String breed_name, String description) {
		super();
		this.breed_name = breed_name;
		this.description = description;
	}

	public long getBreed_id() {
		return breed_id;
	}

	public void setBreed_id(long breed_id) {
		this.breed_id = breed_id;
	}

	public String getBreed_name() {
		return breed_name;
	}

	public void setBreed_name(String breed_name) {
		this.breed_name = breed_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}
	
}
