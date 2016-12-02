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
public class Groups {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(fetch=FetchType.LAZY, mappedBy ="groups",cascade=CascadeType.ALL)
	private List<User> users;
	@ManyToMany
	@JoinTable(name="test_groups", joinColumns=@JoinColumn(name="id_groups"), inverseJoinColumns=@JoinColumn(name="id_test"))
	List<Test> testsList;
	public Groups() {
		// TODO Auto-generated constructor stub
	}
	public Groups(String name) {
		super();
		this.name = name;
	}
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Test> getTestsList() {
		return testsList;
	}
	public void setTestsList(List<Test> testsList) {
		this.testsList = testsList;
	}
	
	
		
	
	
	
}
