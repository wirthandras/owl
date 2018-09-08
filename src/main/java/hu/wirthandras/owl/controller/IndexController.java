package hu.wirthandras.owl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.wirthandras.owl.service.OwlService;

@Controller
public class IndexController {
	
	@Autowired
	private OwlService service;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("texts", service.getTexts());
		return "index";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("texts", service.getTexts());
		return "index";
	}
}