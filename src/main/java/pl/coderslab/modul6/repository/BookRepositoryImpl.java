package pl.coderslab.modul6.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.modul6.entity.Book;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepoCustom {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void updateCustom(Book b) {
		this.em.merge(b);
	}

	@Override
	public Book findByIdCustom(Long id) {
		return this.em.find(Book.class, id);
	}
}
