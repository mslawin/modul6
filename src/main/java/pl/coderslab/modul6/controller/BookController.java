package pl.coderslab.modul6.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.modul6.entity.Author;
import pl.coderslab.modul6.entity.AuthorDAO;
import pl.coderslab.modul6.entity.Book;
import pl.coderslab.modul6.entity.BookDAO;
import pl.coderslab.modul6.entity.Publisher;
import pl.coderslab.modul6.entity.PublisherDAO;
import pl.coderslab.modul6.validator.BookValidationGroup;

@Controller
@RequestMapping("/book")
public class BookController {
	final static Logger logger =
			Logger.getLogger(BookController.class);

	@Autowired
	BookDAO bd;
	
	@Autowired
	PublisherDAO pd;
	
	@Autowired
	AuthorDAO ad;

	@GetMapping("/add")
	@ResponseBody
	public String add() {
		Book b = new Book("Szkice piórkiem", 9, "Warto przeczytac");
		bd.save(b);
		return "Dodano ksiazke id="+b.getId();
	}
	
	@GetMapping("/addpublisher")
	@ResponseBody
	public String addpublisher() {
		Book b = this.bd.getById(1);
		Publisher p = this.pd.getById(1);
		b.setPublisher(p);
		this.bd.update(b);
		
		return "Zaktualizowano ksiazke id="+b.getId();
	}
	
	@GetMapping("/getpublisher")
	@ResponseBody
	public String getpublisher() {
		Book b = this.bd.getById(1);
		
		return "Publisher ksiazki o id=" + b.getId()
		     + " to " + b.getPublisher().getName();
	}
	
	@GetMapping("/addpa")
	@ResponseBody
	public String addbpa() {
		Book b = new Book("Pieprz i Wanilia", 8, "Podroznicza");
		
		this.bd.save(b);
		
		Publisher p = this.pd.getById(1);
		b.setPublisher(p);
		
		this.bd.update(b);
		
		Author a1 = this.ad.getById(2);
		Author a2 = this.ad.getById(3);
		
		b.getAuthors().add(a1);
		b.getAuthors().add(a2);
		
		this.bd.update(b);
	
		
		return "Dodano ksiazke id="+b.getId();
	}
	
	@GetMapping("/addpa2")
	@ResponseBody
	public String addbpa2() {
		Book b = new Book("Pieprz i Wanilia2", 8, "Podroznicza");
		
		Author a1 = this.ad.getById(2);
		Author a2 = this.ad.getById(3);
		
		b.getAuthors().add(a1);
		b.getAuthors().add(a2);
		
		this.bd.save(b);
	
		return "Dodano ksiazke id="+b.getId();
	}
	
	@GetMapping("/addpanew")
	@ResponseBody
	public String addbpanew() {
		Book b = new Book("Pieprz i Wanilia3", 8, "Podroznicza");
		
		Author a1 = new Author("imie1", "nazwisko1");
		Author a2 = new Author("imie2", "nazwisko2");
		
		b.getAuthors().add(a1);
		b.getAuthors().add(a2);
		
		this.bd.save(b);
	
		return "Dodano ksiazke id="+b.getId();
	}
	
	@GetMapping("/getauthors")
	@ResponseBody
	public String getauthors() {
		Book b = this.bd.getById(1);
		String html = "";
		for(Author a : b.getAuthors()) {
			html += a.getFirstName() + " " + a.getLastName() + "\r\n";
		}
		return html;
	}
	
	@GetMapping("/list")
	public String list() {
		logger.warn("wywolano BookController.list()");
		logger.error("to jest error");
		return "book/list";
	}
	
	@GetMapping("/addform")
	public String addform(Model m) {
		m.addAttribute("book", new Book());
		return "book/addBook";
	}

	@PostMapping("/addform")
	public String addformPost(@Validated(BookValidationGroup.class) @ModelAttribute Book book, 
			BindingResult bindingResult) {
		book.setProposition(false);
		if (bindingResult.hasErrors()) {
			return "book/addBook";
		}
		this.bd.save(book);
		return "redirect:/book/list";
	}
	
	@GetMapping("{id}/edit")
	@Transactional
	public String edit(Model m, @PathVariable Long id) {
		Book b = this.bd.getById(id);
		m.addAttribute("book", b);
		return "book/addBook";
	}
	
	@PostMapping(value="{id}/edit")
	public String editPost(@Validated(BookValidationGroup.class) @ModelAttribute Book book,
			BindingResult result) {
		if (result.hasErrors()) {
			return "book/addBook";
		}
		this.bd.update(book);
		return "redirect:/book/list";
	}
	
	@GetMapping("{id}/del")
	public String del(@PathVariable long id) {
		this.bd.delete(id);
		return "redirect:/book/list";
	}
	
	@ModelAttribute("availableAuthors")
	public List<Author> getAuthors(){
		return this.ad.getAll();
	}
	
	@ModelAttribute("availablePublishers")
	public List<Publisher> getPublishers(){
		return this.pd.getAll();
	}
	
	@ModelAttribute("availableBooks")
	public List<Book> getBooks(){
		return this.bd.getAll();
	}
}
