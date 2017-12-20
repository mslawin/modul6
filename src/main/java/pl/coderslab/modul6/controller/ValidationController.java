package pl.coderslab.modul6.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.modul6.entity.Author;
import pl.coderslab.modul6.entity.Book;

@Controller
public class ValidationController {

	@Autowired
	private Validator validator;

	@RequestMapping("/validate")
	public String validate(Model model) {
		Book book = new Book();
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		model.addAttribute("errors", violations);
		return "validationResult";
	}
	
	@RequestMapping("/validateAuthor")
	public String validateAuthor(Model model) {
		Author author = new Author();
		Set<ConstraintViolation<Author>> violations = 
				validator.validate(author);
		model.addAttribute("errors", violations);
		return "validationResult";

	}
	
}
