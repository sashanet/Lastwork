package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import editor.QuestionEditor;
import editor.TestEditor;
import ua.com.library.entity.Question;
import ua.com.library.entity.Test;
import ua.com.library.entity.User;
import ua.com.library.service.QuestionService;
import ua.com.library.service.TestService;


@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TestService testService;
	
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
               binder.registerCustomEditor(Test.class, new TestEditor(testService));
    }
	
	@RequestMapping(value = "/questionAdd",method=RequestMethod.GET )
	public String newQuestion(Model model){

		model.addAttribute("question", new  Question());
		model.addAttribute("test", testService.findAll());
		return "questionAdd";
	}
	
	@RequestMapping(value="/saveNewQuestion", method=RequestMethod.POST)
	public String click(@ModelAttribute Question question)
	{
		
				questionService.save(question);

		return "redirect:/questionAdd";
		
	}

	
}
