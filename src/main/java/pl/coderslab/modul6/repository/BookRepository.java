package pl.coderslab.modul6.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.modul6.entity.Author;
import pl.coderslab.modul6.entity.Book;
import pl.coderslab.modul6.entity.Publisher;

public interface BookRepository extends JpaRepository<Book, Long>,
                                        BookRepoCustom {
	List<Book> findByTitle(String title);
	List<Book> findByTitleLike(String wildcard);
	List<Book> findByPublisher(Publisher pub);
	List<Book> findByPublisherId(Long id);
	List<Book> findByPublisherName(String name);
	List<Book> findByAuthors(Author a);
	@Query("SELECT b FROM Book b WHERE b.title = :title")
	List<Book> sqlFindByTitle(@Param("title") String title);
	@Query("SELECT b FROM Book b WHERE b.publisher = :pub")
	List<Book> sqlFindByPublisher(@Param("pub") Publisher pub);
	@Query(value="SELECT * FROM books WHERE publisher_id = ?1 ORDER BY title LIMIT 1",
			nativeQuery = true)
	Book findMyBook(Publisher pub);
	@Query(value="SELECT * FROM books WHERE publisher_id = ?1 ORDER BY title DESC LIMIT 1",
			nativeQuery = true)
	Book findMyBook2(Publisher pub);
}
