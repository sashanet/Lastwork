package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Answer;
import ua.com.library.entity.Groups;

public interface AnswerService {
	void save(Answer answer);

	List<Answer> findAll();

	Answer findOne(int id);

	void delete(int id);
}

