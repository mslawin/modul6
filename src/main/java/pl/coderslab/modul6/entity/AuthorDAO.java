package pl.coderslab.modul6.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
