package telran.persons.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import telran.persons.mongo.PersonCRUD;

@Repository
public interface PersonsMongoRepository extends MongoRepository<PersonCRUD, Integer> {

}
