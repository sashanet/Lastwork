package ua.com.library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String question;
	 private int points;
	 @OneToMany(fetch=FetchType.LAZY, mappedBy ="question")
	 private List<Answer> answers ;
	 @ManyToOne
	 private Test test;
	 
	 
	 
	 
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	 
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public int getId() {
		return id;
	}
	public Question(String name, String question, int points) {
		super();
		this.name = name;
		this.question = question;
		this.points = points;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Question(String question, int points) {
		super();
		this.question = question;
		this.points = points;
	}
	 public Question() {
		// TODO Auto-generated constructor stub
	}
	 
	 
	
	
}
