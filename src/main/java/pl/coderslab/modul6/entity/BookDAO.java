package pl.coderslab.modul6.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BookDAO {
	@PersistenceContext
	EntityManager em;
	
	public void save(Book b) {
		this.em.persist(b);
	}
	
	public Book getById(long id) {
		return this.em.find(Book.class, id);
	}
	
	public void update(Book b) {
		this.em.merge(b);
	}
}
