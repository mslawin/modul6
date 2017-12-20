package pl.coderslab.modul6.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.modul6.entity.Book;
import pl.coderslab.modul6.entity.BookDAO;
import pl.coderslab.modul6.validator.PropositionValidationGroup;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

	@Autowired
	private BookDAO bd;
	
	@GetMapping("/list")
	public String list() {
		return "proposition/list";
	}
	
	@GetMapping("/addform")
	public String addform(Model m) {
		m.addAttribute("book", new Book());
		return "proposition/addProposition";
	}

	@PostMapping("/addform")
	public String addformPost(@Validated(PropositionValidationGroup.class) 
			@ModelAttribute Book book, 
			BindingResult bindingResult) {
		book.setProposition(true);
		if (bindingResult.hasErrors()) {
			return "proposition/addProposition";
		}
		this.bd.save(book);
		return "redirect:/proposition/list";
	}
	
	@GetMapping("{id}/edit")
	@Transactional
	public String edit(Model m, @PathVariable Long id) {
		Book b = this.bd.getById(id);
		m.addAttribute("book", b);
		return "proposition/addProposition";
	}
	
	@PostMapping(value="{id}/edit")
	public String editPost(@Validated(PropositionValidationGroup.class) 
				@ModelAttribute Book book,
			BindingResult result) {
		book.setProposition(true);
		if (result.hasErrors()) {
			return "proposition/addProposition";
		}
		this.bd.update(book);
		return "redirect:/proposition/list";
	}
	
	@GetMapping("{id}/del")
	public String del(@PathVariable long id) {
		this.bd.delete(id);
		return "redirect:/proposition/list";
	}
	
	@ModelAttribute("availablePropositions")
	public List<Book> getBooks(){
		return this.bd.getAllPropositions();
	}
	
	
	
	
	
}
