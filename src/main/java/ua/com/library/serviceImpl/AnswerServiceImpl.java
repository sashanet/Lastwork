package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.library.Dao.AnswerDao;
import ua.com.library.Dao.GroupsDao;
import ua.com.library.entity.Answer;
import ua.com.library.entity.Groups;
import ua.com.library.service.AnswerService;

@Service("AnswerService")
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerDao answerDao;
	
	
	public void save(Answer answer) {
		answerDao.save(answer);
		
	}

	public List<Answer> findAll() {
		
		return answerDao.findAll();
	}

	public Answer findOne(int id) {
		
		return answerDao.findOne(id);
	}

	public void delete(int id) {
		answerDao.delete(id);
		
	}

}
