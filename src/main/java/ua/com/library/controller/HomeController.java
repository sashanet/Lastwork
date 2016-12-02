package ua.com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		
		return "home";
	}
	
	@RequestMapping("/loginpage")
	public String login() {
		return "loginpage";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing(){
		return "redirect:/home";
	}
	
	
	
}