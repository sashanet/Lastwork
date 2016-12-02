package ua.com.library.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private LocalDate dateofRegister;
	private Role role;

	





	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}




	@ManyToOne(fetch=FetchType.LAZY)
	private Groups groups;
	
	
	
	
		public User(LocalDate dateofRegister) {
		super();
		this.dateofRegister = dateofRegister;
	}
	
	public LocalDate getDateofRegister() {
			return dateofRegister;
		}

		public void setDateofRegister(LocalDate dateofRegister) {
			this.dateofRegister = dateofRegister;
		}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Groups getGroups() {
		return groups;
	}


	public void setGroups(Groups groups) {
		this.groups = groups;
	}


	public User(String name, String phone, String email, String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}




	
	
	public User() {

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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public User(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		return authorities;
	}

	public String getUsername() {
		return String.valueOf(id);
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
	
}
