package pl.coderslab.modul6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.modul6.entity.Person;
import pl.coderslab.modul6.entity.PersonDAO;
import pl.coderslab.modul6.entity.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	PersonDAO pd;

	@GetMapping("/addform")
	public String addform() {
		return "person/addform";
	}
	
	@PostMapping("/addform")
	public String addformPost(@RequestParam String login,
							  @RequestParam String password,
							  @RequestParam String email,
							  Model m) {
		Person p = new Person(login, password, email);
		this.pd.save(p);
		m.addAttribute("text", "Dodano osobe, id="+p.getId());
		return "person/addform";
	}
	
	
	
	
	
	@GetMapping("/addformtl")
	public String addformtaglib(Model m) {
		Person p = new Person();
		p.setPersonDetails(new PersonDetails("some details here"));
		m.addAttribute("person", p);
		return "person/addformtl";
	}
	
	@PostMapping("/addformtl")
	public String addformtaglibPost(@ModelAttribute Person p) {
		this.pd.save(p);
		return "person/addformtl";
	}
}
