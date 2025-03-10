package kr.co.soldesk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/join")
	public String join(@ModelAttribute UserBean userBean) {
		
		return "user/join";
	}
	@PostMapping("/joinPro")
	public String joinPro(@Valid UserBean bean, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}
		userService.insertUser(bean);
		return "redirect:/";
	}
	
	@GetMapping("/myPage")
	public String myPage(@RequestParam String id, Model model) {
		
		UserBean user = userService.getUser(id);
		model.addAttribute("user", user);
		
		return "user/myPage";
	}
	@GetMapping("/login")
	public String login(@ModelAttribute UserBean userBean) {
		
		return "user/login";
	}
	@PostMapping("/loginPro")
	public String loginPro(@ModelAttribute UserBean userBean) {
		
		userService.getLoginUser(userBean);
		
		return"redirect:/";		
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		userService.logout();
		
		return"redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteUser() {
		
		return"user/delete";
	}
	@PostMapping("/deletePro")
	public String deletePro(@RequestParam String user_pass) {

		userService.deleteUser(user_pass);
		
		return"redirect:/";
	}
}
