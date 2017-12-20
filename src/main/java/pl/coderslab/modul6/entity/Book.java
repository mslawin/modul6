package pl.coderslab.modul6.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pl.coderslab.modul6.validator.BookValidationGroup;
import pl.coderslab.modul6.validator.PropositionValidationGroup;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 5, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@NotEmpty(groups = BookValidationGroup.class)
	private List<Author> authors = new ArrayList<>();
	
	@Min(value = 1, message = "rating must be gt 1", groups = BookValidationGroup.class)
	@Max(value = 10, groups = BookValidationGroup.class)
	private long rating;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE})
	@NotNull(groups = BookValidationGroup.class)
	private Publisher publisher;
	
	@Size(max = 600, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
	private String description;
	
	@Min(value = 1, message = "{book.pages}", groups = BookValidationGroup.class)
	private int pages;
	
	private boolean proposition;

	public Book() {
		super();
	}

	public Book(String title, long rating, String description) {
		super();
		this.title = title;
		this.rating = rating;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public boolean isProposition() {
		return proposition;
	}

	public void setProposition(boolean proposition) {
		this.proposition = proposition;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", rating=" + rating + ", publisher="
				+ publisher + ", description=" + description + ", pages=" + pages + ", proposition=" + proposition
				+ "]";
	}	
}
