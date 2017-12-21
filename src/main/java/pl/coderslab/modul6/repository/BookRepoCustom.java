package pl.coderslab.modul6.repository;

import pl.coderslab.modul6.entity.Book;

public interface BookRepoCustom {
	public void updateCustom(Book b);
	public Book findByIdCustom(Long id);
}
