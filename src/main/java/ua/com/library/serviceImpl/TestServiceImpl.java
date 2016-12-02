package ua.com.library.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.Dao.AnswerDao;
import ua.com.library.Dao.GroupsDao;
import ua.com.library.Dao.TestDao;
import ua.com.library.entity.Groups;
import ua.com.library.entity.Test;
import ua.com.library.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private GroupsDao groupsDao;
	public void save(Test test) {
		testDao.save(test);
		
	}

	public List<Test> findAll() {
		return testDao.findAll();
	}

	public Test findOne(int id) {
		
		return testDao.findOne(id);
	}

	public void delete(int id) {
		testDao.delete(id);
		
	}
	
	public void addGroupsToTest(String [] tests, String [] groups){
		
		for (int i = 0; i < tests.length; i++) {
				Test test = testDao.findOne(Integer.parseInt(tests[i]));
				List<Groups> groupList = new ArrayList<Groups>();
				for (int j = 0; j < groups.length; j++) {
					groupList.add(groupsDao.findOne(Integer.parseInt(groups[j])));
				}		
				test.setGroupsList(groupList);
				testDao.save(test);
		}				
						
	}

}
