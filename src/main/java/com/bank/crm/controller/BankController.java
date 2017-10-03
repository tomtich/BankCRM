package com.bank.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {

	@RequestMapping(value="/test")
	public String test() {
		String test = "Hello world!";
		System.out.println(test);
		return "test";
	}
}
