package pl.coderslab.modul6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.modul6.entity.Book;
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
		Publisher p2 = new Publisher("PWN");
		pd.save(p2);
		Publisher p3 = new Publisher("Helion");
		pd.save(p3);
		return "Dodano publisherow";
	}
	
	@GetMapping("/getbooks")
	@ResponseBody
	public String getbooks() {
		Publisher p = this.pd.getById(1);
		String html = "";
		for(Book b : p.getBooks()) {
			html += b.getTitle() + "\r\n";
		}
		return html;
	}
}
