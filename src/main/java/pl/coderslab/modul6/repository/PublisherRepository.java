package pl.coderslab.modul6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.modul6.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
