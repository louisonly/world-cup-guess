package com.louis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.louis.entity.User;
import com.louis.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String Index(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@GetMapping("/getUsersList")
	public String getUsersList(Model model) {
		List<User> usersList = userService.getUsersList();
		System.err.println(usersList.get(0).getEmail());
		model.addAttribute("usersList", usersList);
		model.addAttribute("test", "I am testing");
		return "user";
	};
	
	@PostMapping("/userLogin")
	public String userLogin(@ModelAttribute(value="user") User user) {
		//User user = model.
		String name = user.getName();
		String password = user.getPassWord();
		System.out.println("name: "+name + "password: "+password);
		return "user";
	}
}
