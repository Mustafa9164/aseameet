package com.lti.appl.aseameet.uicontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.aseameet.beans.User;
import com.lti.appl.aseameet.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path ="/user")
public class UserController { 
	
	@Autowired
	private UserService userservice;
	
	@PostMapping(path = "/userlogin", produces = "application/json")
	public boolean loginUser(@RequestBody User login) {
		System.out.println("User login successfull");
		return userservice.loginUser(login);
	}
	
	@GetMapping(path="/getUser/{userId}", produces="application/json")
	public void getUserById(@PathVariable("userId") int userId) {
		System.out.println(userservice.getuserById(userId));
		userservice.getuserById(userId);
		
	}
	
	@PostMapping("/addNewUser")
	public void addNewUser (@RequestBody User newUser)
	{
		System.out.println(newUser);
		userservice.addUser(newUser);
	}
}

