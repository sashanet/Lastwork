package ua.com.library.Dao;



import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Answer;



public interface AnswerDao extends JpaRepository<Answer, Integer>{

	
	
}
