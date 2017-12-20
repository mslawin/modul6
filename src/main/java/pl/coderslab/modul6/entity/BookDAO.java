package pl.coderslab.modul6.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	public List<Book> getAll() {
		Query q = this.em.createQuery("SELECT b FROM Book b");
		return q.getResultList();
	}
	
	public void delete(long id) {
		em.remove(getById(id));
	}

	public List<Book> getAllPropositions() {
		Query q = this.em.createQuery("SELECT b FROM Book b"
				+ " where b.proposition = TRUE");
		return q.getResultList();
	}
	
	
	
	
	
	
	
	
}
