package telran.persons.mongo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import telran.persons.dto.Person;

@Document(collection = "persons")
public class PersonCRUD {
	@Id
	private int id;
	private String name;
	private LocalDate birthDate;

	public PersonCRUD(Person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.birthDate = person.getBirthDate();
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonCRUD() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Person getPerson() {
		Person res = new Person(id, name, birthDate);
		return res;
	}
}
