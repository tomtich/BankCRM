package com.bank.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.crm.service.AuthService;

@Controller
public class BankController {
	
	@Autowired
	@Qualifier("AuthServiceImpl")
	private AuthService authService;

	@RequestMapping(value="/test")
	public String test() {
		String test = "Hello world!";
		System.out.println(test);
		return "test";
	}
	
	@RequestMapping(value="auth")
	public String authUser(String username, String password, HttpSession session, Model model) {
		String redirect;
		String role = authService.authUser(username, password);
		if (role.equals("ROLE_BANK_MANAGER")) {
			session.setAttribute("username", username);
			session.setAttribute("role", role);
			redirect = "bankManagerHome";
		} else {
			return "redirect:/login.jsp?message=Incorrect username or password.";
		}
		return redirect;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/login.jsp?message=You have successfully logged out.";
	}
}
