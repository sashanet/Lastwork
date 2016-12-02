package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.Dao.AnswerDao;
import ua.com.library.Dao.QuestionDao;
import ua.com.library.entity.Question;
import ua.com.library.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	@Autowired
	private QuestionDao questionDao;
	public void save(Question question) {
		questionDao.save(question);
		
	}

	public List<Question> findAll() {
		
		return questionDao.findAll();
	}

	public Question findOne(int id) {
		
		return questionDao.findOne(id);
	}

	public void delete(int id) {
		questionDao.delete(id);
		
	}

	
	
}
