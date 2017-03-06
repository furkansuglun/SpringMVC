package _jpa.service;

import _jpa.model.Person;

import java.util.List;

/**
 * Created by Lenovo on 01.03.2017.
 */
public interface PersonService {

    public void insertPerson(Person person);

    public Person getPersonById(int id);

    public List<Person> getAllPersons();

    public void updatePerson(Person person);

    public void deletePerson(int id);

}
