package _jpa.dao;

import _jpa.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Lenovo on 01.03.2017.
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    private EntityManager entityManager;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void insertPerson(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

    public Person getPersonById(int id) {
        return entityManager.find(Person.class , id);
    }

    public List<Person> getAllPerson() {
        TypedQuery<Person> query = entityManager.createQuery("Select e from Person e" , Person.class);
        return query.getResultList();
    }

    public void updatePerson(Person person) {
        Person foundEmployee = getPersonById(person.getId());
        if (foundEmployee != null) {

            entityManager.getTransaction().begin();
            foundEmployee.setName(person.getName());
            foundEmployee.setSurname(person.getSurname());
            foundEmployee.setSalary(person.getSalary());
            entityManager.getTransaction().commit();

        }

    }

    public void deletePerson(int id) {
        Person person = getPersonById(id);
        if (person != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(person);
            entityManager.getTransaction().commit();
        }
    }
}
