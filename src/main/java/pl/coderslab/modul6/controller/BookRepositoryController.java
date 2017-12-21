package pl.coderslab.modul6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.modul6.entity.Author;
import pl.coderslab.modul6.entity.Book;
import pl.coderslab.modul6.entity.Publisher;
import pl.coderslab.modul6.repository.AuthorRepository;
import pl.coderslab.modul6.repository.BookRepository;
import pl.coderslab.modul6.repository.PublisherRepository;

@Controller
@RequestMapping("/bookrepo")
public class BookRepositoryController {
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private PublisherRepository publisherRepo;
	@Autowired
	private AuthorRepository authorRepo;

	@GetMapping("/add")
	@ResponseBody
	public String add() {
		Book b = new Book("W pustyni i w puszczy", 9, "Warto przeczytac");
		this.bookRepo.save(b);
		return "Dodano ksiazke id=" + b.getId();
	}

	@GetMapping("/update")
	@ResponseBody
	public String update() {
		Book b = this.bookRepo.findOne(24l);
		b.setTitle(b.getTitle() + " zmodyfikowano!");
		this.bookRepo.save(b);
		return b.toString();
	}

	@GetMapping("/all")
	@ResponseBody
	public String all(
//	 @ModelAttribute ArrayList<Book> availableBooks
	) {
		List<Book> availableBooks = this.bookRepo.findAll();
		String html = "";
		for (Book b : availableBooks) {
			html += b.toString() + "\r\n";
		}
		return html;
	}

	@GetMapping("/bytitle")
	@ResponseBody
	public String bytitle(@RequestParam String t) {
		List<Book> books = this.bookRepo.findByTitle(t);
		String html = "Ksiazki o tytule: " + t + ":\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/bytitlelike")
	@ResponseBody
	public String bytitlelike() {
		List<Book> books = this.bookRepo.findByTitleLike("%y%");
		String html = "Ksiazki o tytule:\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/bypublisher")
	@ResponseBody
	public String bypublisher() {
		Publisher pub = this.publisherRepo.findOne(2l);
		List<Book> books = this.bookRepo.findByPublisher(pub);
		String html = "Ksiazki publishera:\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/byauthors")
	@ResponseBody
	public String byauthors() {
		Author a = this.authorRepo.findOne(1l);
		List<Book> books = this.bookRepo.findByAuthors(a);
		String html = "Ksiazki autora:\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/bypublisherid")
	@ResponseBody
	public String bypublisherid(@RequestParam long id) {
		List<Book> books = this.bookRepo.findByPublisherId(id);
		String html = "Ksiazki publishera:\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/bypublishername")
	@ResponseBody
	public String bypublisherid(@RequestParam String n) {
		List<Book> books = this.bookRepo.findByPublisherName(n);
		String html = "Ksiazki publishera:\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/bysqlpublisher")
	@ResponseBody
	public String bysqlpublisher() {
		Publisher pub = this.publisherRepo.findOne(2l);
		List<Book> books = this.bookRepo.sqlFindByPublisher(pub);
		String html = "Ksiazki publishera:\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/bysqltitle")
	@ResponseBody
	public String bysqltitle(@RequestParam String t) {
		List<Book> books = this.bookRepo.sqlFindByTitle(t);
		String html = "Ksiazki o tytule: " + t + ":\r\n";
		if (books != null) {
			for (Book b : books) {
				html += b.toString() + "\r\n";
			}
		}
		return html;
	}
	
	@GetMapping("/updatecustom")
	@ResponseBody
	public String updatecustom() {
		Book b = this.bookRepo.findByIdCustom(20l);
		b.setTitle(b.getTitle() + " custom!");
		this.bookRepo.updateCustom(b);
		
		return b.toString();
	}
	
	@GetMapping("/getsql")
	@ResponseBody
	public String getsql() {
		Book b = this.bookRepo.findMyBook(
				this.publisherRepo.findOne(2l)
				);
		Book b2 = this.bookRepo.findMyBook2(
				this.publisherRepo.findOne(2l)
				);
		return b.toString()+"\r\n"+b2.toString();
	}

	@ModelAttribute("availableBooks")
	public List<Book> getBooks() {
		return this.bookRepo.findAll();
	}
}
