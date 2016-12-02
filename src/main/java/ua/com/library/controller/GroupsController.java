package ua.com.library.controller;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Groups;
import ua.com.library.entity.User;
import ua.com.library.service.GroupsService;
import ua.com.library.service.UserService;

@Controller
public class GroupsController {
	@Autowired
	private GroupsService groupsService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/groupsAdd",method=RequestMethod.GET )
	public String newGroups(Model model){
		
		
		model.addAttribute("groupsaa", DtoUtilMapper.groupsToGroupDdto(groupsService.getAll()));
		
		
		model.addAttribute("groups1", groupsService.getAll());
		
		model.addAttribute("users", userService.findAll());
		model.addAttribute("group", new Groups());
		
		
		return "groupsAdd";
	}
	
	@RequestMapping(value="/addNewGroup", method=RequestMethod.POST)
public String click(@ModelAttribute Groups group){
		

		groupsService.save(group);
		return "redirect:/groupsAdd";

	}	
	
	@RequestMapping(value="/addGroup", method=RequestMethod.POST)
	public String click(@RequestParam String groupname){
		
		Groups group = new Groups(groupname);
		groupsService.save(group);
		return "redirect:/groupsAdd";

	}	
	
	@RequestMapping(value = "/deleteGroups/{id}", method = RequestMethod.GET)
	public String newBook(@PathVariable int id) {

		groupsService.delete(id);
		
		return "redirect:/groupsAdd";
	}
	@RequestMapping(value = "/saveUsersInGroups", method = RequestMethod.POST)
	public String newUser(@RequestParam String groupsId,
			@RequestParam String [] usersId)  {

		userService.addUsersTogroups(groupsId, usersId);
		
		
		
		return "redirect:/groupsAdd";
	}
	
}
