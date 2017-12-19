package pl.coderslab.modul6.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.modul6.entity.Author;
import pl.coderslab.modul6.entity.AuthorDAO;

public class AuthorConverter
  implements Converter<String, Author> {
	@Autowired
	private AuthorDAO ad;

	@Override
	public Author convert(String source) {
		long id = Long.parseLong(source);
		Author author = this.ad.getById(id);
		return author;
	}

}
