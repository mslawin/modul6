package pl.coderslab.modul6.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PublisherDAO {
	@PersistenceContext
	EntityManager em;
	
	public void save(Publisher p) {
		this.em.persist(p);
	}
	
	public Publisher getById(long id) {
		return this.em.find(Publisher.class, id);
	}
	
	public List<Publisher> getAll() {
		Query q = this.em.createQuery("SELECT p FROM Publisher p");
		return q.getResultList();
	}
}
