package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin/")
	public String adminIndex(Model model){
		model.addAttribute("dashboard", "dashboard");
		return "admin/index";
	}
	
	@RequestMapping("/admin/user")
	public String adminUser(Model model){
		model.addAttribute("user", "user");
		return "admin/user";
	}
}
