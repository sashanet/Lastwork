package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Book;
import ua.com.library.entity.User;

public interface UserService {

	

	void save(User user);

	List<User> findAll();

	User findOne(int id);

	void delete(int id);
	void addUsertoGroups(User user, int idGroup);
	
	void addUsersTogroups(String groupsId, String [] usersId);
	
}

