package pl.coderslab.modul6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.modul6.entity.Book;
import pl.coderslab.modul6.entity.BookDAO;
import pl.coderslab.modul6.entity.Publisher;
import pl.coderslab.modul6.entity.PublisherDAO;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	@Autowired
	PublisherDAO pd;

	@GetMapping("/add")
	@ResponseBody
	public String add() {
		Publisher p = new Publisher("Biblioteka Narodowa");
		pd.save(p);
		return "Dodano publishera id="+p.getId();
	}
}
