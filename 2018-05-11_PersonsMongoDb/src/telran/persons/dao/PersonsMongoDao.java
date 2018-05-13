package telran.persons.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.persons.dto.Person;
import telran.persons.mongo.PersonCRUD;
import telran.persons.mongo.repo.PersonsMongoRepository;

@Service

public class PersonsMongoDao implements IPersonsDao {
	@Autowired
	PersonsMongoRepository repository;

	@Override
	public boolean addPerson(Person person) {
		if (repository.existsById(person.getId()))
			return false;
		repository.save(new PersonCRUD(person));
		return true;
	}

	@Override
	public Person getPerson(int id) {
		PersonCRUD res = repository.findById(id).orElse(null);
		return res == null ? null : res.getPerson();
	}

	@Override
	public boolean updateName(int id, String newName) {
		PersonCRUD person = repository.findById(id).orElse(null);
		if (person == null) {
			return false;
		}
		person.setName(newName);
		repository.save(person);
		return true;
	}

	@Override
	public boolean removePerson(int id) {
		if (!repository.existsById(id)) {
			return false;
		}
		repository.deleteById(id);
		return true;

	}

}
