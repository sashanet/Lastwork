package ua.com.library.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.com.library.Dao.BookDao;
import ua.com.library.Dao.GroupsDao;
import ua.com.library.Dao.UserDao;
import ua.com.library.entity.Groups;
import ua.com.library.entity.Role;
import ua.com.library.entity.User;
import ua.com.library.service.UserService;

@Service("userDetailsService")
public class UserServiceImp implements UserService,UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private GroupsDao groupsDao;
	@Autowired
    private BCryptPasswordEncoder encoder;
	
	
	public void save(User user) {
		
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));

		LocalDate dateof;
		dateof = LocalDate.now();
		user.setDateofRegister(dateof);
		userDao.save(user);
		
	}
	

	public List<User> findAll() {
	return userDao.findAll();
	}

	public User findOne(int id) {
	
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
		
	}
	@Transactional
	public void addUsertoGroups(User user, int idGroup) {
		userDao.saveAndFlush(user);
		Groups groups= groupsDao.findOne(idGroup);
		
		
		
//			List<User> users= groups.getUsers();
//			
//			users.add(user);
		
		
		 user.setGroups(groups);
		 userDao.save(user);
	}

	@Transactional
	public void addUsersTogroups(String groupsId, String[] usersId) {
		Groups groups= groupsDao.findOne(Integer.parseInt(groupsId));
		
		for (int i = 0; i < usersId.length; i++) {
			User user = userDao.findOne(Integer.parseInt(usersId[i]));
			user.setGroups(groups);
			userDao.save(user);
		}
		
		
	}


	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByEmail(name);
	}
	public User findByName(String name) {
		return userDao.findByEmail(name);
	}


	
	
}
