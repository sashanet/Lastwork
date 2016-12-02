package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import editor.GroupsEditor;
import editor.TestEditor;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Groups;
import ua.com.library.entity.Test;
import ua.com.library.entity.User;
import ua.com.library.service.GroupsService;
import ua.com.library.service.UserService;
import ua.com.library.serviceImpl.UserServiceImp;

@Controller
public class UserController {
@Autowired
private UserService userService;

@Autowired
private GroupsService groupsService;


@InitBinder
public void InitBinder(WebDataBinder binder){
           binder.registerCustomEditor(Groups.class, new GroupsEditor(groupsService));
}


@RequestMapping(value = "/signUp",method=RequestMethod.GET )
public String newUser(Model model){
	
	model.addAttribute("users", DtoUtilMapper.usersToUserDtop(userService.findAll()));
	model.addAttribute("groups", groupsService.getAll());
	model.addAttribute("user", new  User());
	
	
	return "signUp";
}



@RequestMapping(value="/saveUser", method=RequestMethod.POST)
public String click(@RequestParam String username, @RequestParam String phone,  @RequestParam String email, @RequestParam String password, @RequestParam String groupsId)
{
	
	User user= new User(username, phone, email, password);
	userService.addUsertoGroups(user, Integer.parseInt(groupsId));

	return "redirect:/signUp";
	
}	



@RequestMapping(value="/saveNewUser", method=RequestMethod.POST)
public String click(@ModelAttribute User user)
{
	

	userService.save(user);

	return "redirect:/signUp";
	
}

@RequestMapping(value = "/deleteUsers/{id}", method = RequestMethod.GET)
public String newBook(@PathVariable int id) {

	userService.delete(id);
	
	return "redirect:/signUp";
}
	
	
}
