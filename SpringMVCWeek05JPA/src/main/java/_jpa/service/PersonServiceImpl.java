package _jpa.service;

import _jpa.dao.PersonDAOImpl;
import _jpa.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lenovo on 01.03.2017.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAOImpl personDAOImpl;

    public void insertPerson(Person person) {
        personDAOImpl.insertPerson(person);
    }

    public Person getPersonById(int id) {
        return personDAOImpl.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personDAOImpl.getAllPerson();
    }

    public void updatePerson(Person person) {
        personDAOImpl.updatePerson(person);
    }

    public void deletePerson(int id) {
        personDAOImpl.deletePerson(id);
    }
}
