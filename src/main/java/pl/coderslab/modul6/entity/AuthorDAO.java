package pl.coderslab.modul6.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AuthorDAO {
	@PersistenceContext
	EntityManager em;
	
	public void save(Author a) {
		this.em.persist(a);
	}
	
	public Author getById(long id) {
		return this.em.find(Author.class, id);
	}
	
	public List<Author> getAll() {
		Query q = this.em.createQuery("SELECT a FROM Author a");
		return q.getResultList();
	}
}
