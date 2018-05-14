package telran.persons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.persons.api.PersonsApiConstants;
import telran.persons.dao.IPersonsDao;
import telran.persons.dto.NamesBox;
import telran.persons.dto.Person;

//@SpringBootApplication
@ComponentScan(basePackages = "telran.persons.dao")
@EnableMongoRepositories("telran.persons.mongo.repo")
@RestController
public class PersonsRestController {
	@Autowired
	IPersonsDao persons;

	@PostMapping(value = PersonsApiConstants.ADD_PERSON)
	boolean addPerson(@RequestBody Person person) {
		return persons.addPerson(person);
	}

	@PostMapping(value = PersonsApiConstants.REMOVE_PERSON)
	boolean removePerson(@RequestBody Integer id) {
		return persons.removePerson(id);
	}

	@RequestMapping(value = PersonsApiConstants.GET_PERSON)
	Person getPerson(Integer id) {
		return persons.getPerson(id);
	}

	@PostMapping(value = PersonsApiConstants.UPDATE_NAME)
	boolean updateName(@RequestBody NamesBox box) {
		return persons.updateName(box.getId(), box.getNewName());
	}

	// public static void main(String[] args) {
	// SpringApplication.run(PersonsRestController.class, args);
	// }

}
