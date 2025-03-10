package kr.co.soldesk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.service.UserService;

@Controller
public class HomeController {
	
	@Resource(name = "loginUser")
	private UserBean userBean;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home(Model model) {
		
		List<UserBean> list = userService.getUSers();
		model.addAttribute("list", list);
		model.addAttribute("userBean",userBean);
		
		return "index"; 
	}
}
