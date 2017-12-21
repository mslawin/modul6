package pl.coderslab.modul6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.modul6.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
