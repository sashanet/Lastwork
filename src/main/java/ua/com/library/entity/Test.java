package ua.com.library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Test{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="test_groups", joinColumns=@JoinColumn(name="id_test"), inverseJoinColumns=@JoinColumn(name="id_groups"))
	List<Groups> groupsList;
	@OneToMany(fetch=FetchType.LAZY, mappedBy ="test")
	List<Question> questionsList;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Test(String name, List<Groups> groupsList) {
		super();
		this.name = name;
		this.groupsList = groupsList;
	}
	public List<Groups> getGroupsList() {
		
		return groupsList;
	}
	public void setGroupsList(List<Groups> groupsList) {
		this.groupsList = groupsList;
	}
	public List<Question> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<Question> questionsList) {
		this.questionsList = questionsList;
	}
	
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public Test(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", groupsList=" + groupsList + ", questionsList=" + questionsList
				+ "]";
	}
	
	
	

}


