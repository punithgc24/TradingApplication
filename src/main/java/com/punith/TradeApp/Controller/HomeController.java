package com.punith.TradeApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.punith.TradeApp.Domain.User;
import com.punith.TradeApp.Repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository repo; 
	
	public HomeController(UserRepository repo) {
		super();
		this.repo = repo;
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
		repo.save(u);
		return "successful";
	}

}
