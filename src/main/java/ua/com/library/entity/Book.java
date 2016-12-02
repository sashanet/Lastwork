package ua.com.library.entity;

import javax.persistence.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "title")
	private String title;
	private int pages;
	private String yearOfPublic;



	public Book() {

	}

	public Book(String title, int pages, String yearOfPublic) {
		super();
		this.title = title;
		this.pages = pages;
		this.yearOfPublic = yearOfPublic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getYearOfPublic() {
		return yearOfPublic;
	}

	public void setYearOfPublic(String yearOfPublic) {
		this.yearOfPublic = yearOfPublic;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", yearOfPublic=" + yearOfPublic
				+  "]";
	}

}