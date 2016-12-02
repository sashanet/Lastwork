package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.Dao.GroupsDao;
import ua.com.library.Dao.UserDao;
import ua.com.library.entity.Groups;
import ua.com.library.service.GroupsService;




@Service("GroupsService")
public class GroupsServiceImpl implements GroupsService {
	@Autowired
	private GroupsDao groupsDao;
	public void save(Groups groups) {
		groupsDao.save(groups);
		
	}

	public List<Groups> getAll() {
		return groupsDao.findAll();
	}

	public Groups findOne(int id) {
		
		return groupsDao.findOne(id);
	}

	public void delete(int id) {
		groupsDao.delete(id);
		
	}


}
