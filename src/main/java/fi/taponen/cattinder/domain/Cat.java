package fi.taponen.cattinder.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name, description, imageUrl, location;
	private boolean female;
	int birthYear;
	
	@ManyToOne
	@JoinColumn(name = "breed_id")
	private Breed breed;
	
	public Cat() {}
	
	public Cat(String name, String description, String imageUrl, String location, boolean female, int birthYear,
			Breed breed) {
		super();
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.location = location;
		this.female = female;
		this.birthYear = birthYear;
		this.breed = breed;
	}

	public Cat(String name, String description, String imageUrl, String location, boolean female, int birthYear) {
		super();
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.location = location;
		this.female = female;
		this.birthYear = birthYear;
	}

	public Cat(String name, String description, String location, boolean female, int birthYear, Breed breed) {
		super();
		this.name = name;
		this.description = description;
		this.location = location;
		this.female = female;
		this.birthYear = birthYear;
		this.breed = breed;
	}
	
	public Cat(String name, String description, String location, boolean female, int birthYear) {
		super();
		this.name = name;
		this.description = description;
		this.location = location;
		this.female = female;
		this.birthYear = birthYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isFemale() {
		return female;
	}

	public void setFemale(boolean female) {
		this.female = female;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public int calcAge() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year-this.birthYear;
	}

}
