package com.fr.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.entity.User;
import com.fr.repos.UserRepository;
import com.fr.service.SecurityService;

@Controller
@RequestMapping
public class UserController {

	private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private SecurityService service;

	@GetMapping("/home")
	public String shoHomePage() {
		LOGGER.info("shoHomePage()");
		return "home";
	}

	@GetMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("showLoginPage()");
		return "login/login";
	}

	@GetMapping("/showReg")
	public String showRegisterPage() {
		LOGGER.info("showRegisterPage()");
		return "login/registerUser";
	}

	@PostMapping("/reg")
	public String registerUser(@ModelAttribute("user") User user) {
		LOGGER.info("registerUser()");
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "login/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {

		boolean loginResponse = service.login(email, password);

		LOGGER.info("login()");

		if (loginResponse) {
			return "findFlight";
		} else {
			model.addAttribute("msg", "Invalid Credentials, Try again later");
		}
		return "login/login";
	}

}
