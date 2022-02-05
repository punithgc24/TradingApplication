package com.punith.TradeApp.Controller;

import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.punith.TradeApp.Domain.User;
import com.punith.TradeApp.Repository.UserRepository;

@Controller
public class HomeController {
		
	@Autowired
	private UserRepository repo; 
	
	PasswordEncoder passwordEncoder;
	
	public HomeController(UserRepository repo, PasswordEncoder passwordEncoder) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}

	@RequestMapping("/")
	public String home() {
		
		return "homePage";
	}
	
	@GetMapping("login")
	public String login() {
		
		return "loginPage";
	}
	
	@GetMapping("register")
	public String register() {
		
		return "registerPage";
	}
	
	@GetMapping("passwordReset")
	public String resetPassword() {
		
		return "passwordResetPage";
	}
	
	@PostMapping("saveData")
	public String userInfo(@ModelAttribute("user") User u)
	{
		System.out.println("Hiiiiii");
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		repo.save(u);
		return "successful";
	}
	
	@PostMapping("login")
	public String loginUser(@RequestParam String username, @RequestParam String password) {
		
//		User user=new User();
//		System.out.println(username);
//		user.setUsername(username);
		//user.setPassword(password);
		String encodedPassword=passwordEncoder.encode(password);
//		user.setPassword(passwordEncoder.encode(password));
		System.out.println(encodedPassword);
		User res=repo.findByUsernameAndPassword(username, passwordEncoder.encode(password));
		System.out.println(res);
		if(res!=null) {
			return "successful";
		}
		else {
			return "loginPage";
		}
	}	
}
