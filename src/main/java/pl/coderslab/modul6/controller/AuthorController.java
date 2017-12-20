package pl.coderslab.modul6.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.modul6.entity.Author;
import pl.coderslab.modul6.entity.AuthorDAO;
import pl.coderslab.modul6.entity.Book;

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
	
	@GetMapping("/list")
	public String list() {
		return "author/list";
	}
	
	@GetMapping("/addform")
	public String addform(Model m) {
		m.addAttribute("author", new Author());
		return "author/addAuthor";
	}

	@PostMapping("/addform")
	public String addformPost(@Valid @ModelAttribute Author author, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "author/addAuthor";
		}
		this.ad.save(author);
		return "redirect:/author/list";
	}
	
	@GetMapping("{id}/edit")
	@Transactional
	public String edit(Model m, @PathVariable Long id) {
		Author a = this.ad.getById(id);
		m.addAttribute("author", a);
		return "author/addAuthor";
	}
	
	@PostMapping(value="{id}/edit")
	public String editPost(@Valid @ModelAttribute Author author, BindingResult result) {
		if (result.hasErrors()) {
			return "author/addAuthor";
		}
		this.ad.update(author);
		return "redirect:/author/list";
	}
	
	@GetMapping("{id}/del")
	public String del(@PathVariable long id) {
		this.ad.delete(id);
		return "redirect:/author/list";
	}
	
	@ModelAttribute("availableAuthors")
	public List<Author> getAuthors(){
		return this.ad.getAll();
	}
}
