package editor;
import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.library.service.QuestionService;

public class QuestionEditor  extends PropertyEditorSupport{





		@Autowired
		private  QuestionService questionService;

		
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(questionService.findOne(Integer.parseInt(text)));
		}
		
	}

