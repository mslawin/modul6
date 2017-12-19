package pl.coderslab.modul6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.modul6.entity.Author;
import pl.coderslab.modul6.entity.AuthorDAO;

@Controller
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	AuthorDAO ad;

	@GetMapping("/add")
	@ResponseBody
	public String add() {
		Author a = new Author("Andrzej", "Bobkowski");
		this.ad.save(a);
		a = new Author("Tony", "Halik");
		this.ad.save(a);
		a = new Author("Elzbieta", "Dzikowska");
		this.ad.save(a);
		return "Dodano autorow";
	}
}
