package pl.coderslab.modul6.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonDAO {
	@PersistenceContext
	EntityManager em;
	
	public void save(Person e) {
		this.em.persist(e);
	}
	
	public Person getById(long id) {
		return this.em.find(Person.class, id);
	}
}
