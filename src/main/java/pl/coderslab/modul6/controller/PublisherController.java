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
	
	@GetMapping("/list")
	public String list() {
		return "publisher/list";
	}
	
	@GetMapping("/addform")
	public String addform(Model m) {
		m.addAttribute("publisher", new Publisher());
		return "publisher/addPublisher";
	}

	@PostMapping("/addform")
	public String addformPost(@Valid @ModelAttribute Publisher publisher, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "publisher/addPublisher";
		}
		this.pd.save(publisher);
		return "redirect:/publisher/list";
	}
	
	@GetMapping("{id}/edit")
	@Transactional
	public String edit(Model m, @PathVariable Long id) {
		Publisher p = this.pd.getById(id);
		m.addAttribute("publisher", p);
		return "publisher/addPublisher";
	}
	
	@PostMapping(value="{id}/edit")
	public String editPost(@Valid @ModelAttribute Publisher publisher, BindingResult result) {
		if (result.hasErrors()) {
			return "publisher/addPublisher";
		}
		this.pd.update(publisher);
		return "redirect:/publisher/list";
	}
	
	@GetMapping("{id}/del")
	public String del(@PathVariable long id) {
		this.pd.delete(id);
		return "redirect:/publisher/list";
	}
	
	@ModelAttribute("availablePublishers")
	public List<Publisher> getPublishers(){
		return this.pd.getAll();
	}
}
