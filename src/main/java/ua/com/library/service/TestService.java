package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Question;
import ua.com.library.entity.Test;

public interface TestService {
	void save(Test test );

	List<Test> findAll();

	Test findOne(int id);

	void delete(int id);
	
	public void addGroupsToTest(String [] tests, String [] groups);
	
	
	
}
