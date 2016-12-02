package ua.com.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String name);
}
