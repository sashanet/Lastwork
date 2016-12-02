package ua.com.library.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private boolean correct;
	@ManyToOne(fetch=FetchType.LAZY)
	private Question question;
	public Answer() {
		// TODO Auto-generated constructor stub
	}
	public Answer(String text, boolean correct) {
		super();
		this.text = text;
		this.correct = correct;
	}
	
	
	
}
