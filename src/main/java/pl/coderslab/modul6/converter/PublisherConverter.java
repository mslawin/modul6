package pl.coderslab.modul6.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.modul6.entity.Publisher;
import pl.coderslab.modul6.entity.PublisherDAO;

public class PublisherConverter
  implements Converter<String, Publisher> {
	@Autowired
	private PublisherDAO pd;

	@Override
	public Publisher convert(String source) {
		long id = Long.parseLong(source);
		Publisher p = this.pd.getById(id);
		return p;
	}

}
