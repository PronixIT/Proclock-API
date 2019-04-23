package com.pronix.spring.proclock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pro")
public class FrontController {
	
	@RequestMapping("/indexPage")
	public String indexPage(Model model){
		return "static/indexPage";
	}

}
