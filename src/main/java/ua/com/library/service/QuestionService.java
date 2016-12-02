package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Question;



public interface QuestionService {
	void save(Question question );

	List<Question> findAll();

	Question findOne(int id);

	void delete(int id);
}
