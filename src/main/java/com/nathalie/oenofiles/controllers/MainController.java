package com.nathalie.oenofiles.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nathalie.oenofiles.models.User;
import com.nathalie.oenofiles.models.Wine;
import com.nathalie.oenofiles.services.UserService;
import com.nathalie.oenofiles.services.WineService;
import com.nathalie.oenofiles.validators.UserValidator;


@Controller
public class MainController  {	
	@Autowired
    private UserService userService;	
	@Autowired 
	private WineService wineServ;	
	@Autowired 
	private UserValidator userValidator;    
    
    @RequestMapping("/")
    public String login(@ModelAttribute("user") User user) {
        return "login.jsp";
    }

    @RequestMapping("/register")
    public String registerForm(@ModelAttribute("user") User user) {
        return "register.jsp";
    }

    
    @PostMapping(value="/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "register.jsp";
			
		}else if(!user.getPasswordConfirmation().equals(user.getPassword())) {
		    		return"redirect:/register";
		 }else {
			User u = userService.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		}
	}
    
    @PostMapping(value="/login")
    public String loginUser(@RequestParam("email") String email, 
    						@RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes flashMessage) {
    	if(userService.authenticateUser(email, password) == false) {
    		flashMessage.addFlashAttribute("error", "Login Failed, try again!");
    		return "redirect:/";
    	}else{
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}
    	
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @RequestMapping("/account/{id}")
    public String accountForm(@PathVariable("id")Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "account.jsp";
	}
    
	@RequestMapping(value="/account/{id}", method = RequestMethod.POST)
    public String updateAccount(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "account.jsp";			
		}else if(!user.getPasswordConfirmation().equals(user.getPassword())) {
		    		return"redirect:/account";
		 }else {
			User u = userService.updateUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		}
	}
    
    
    @RequestMapping("/home")
    public String home(@ModelAttribute("wines")Wine wine,HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("userId");
    	if(id != null) {
    		User loggedInUser = userService.findById(id);
    		model.addAttribute("wines", wineServ.allWines());
    		model.addAttribute("user", loggedInUser);
    		return "home.jsp";
    	}
    	    	return "redirect:/";
    }
    
    @GetMapping("/wines/new")
    public String wineForm(@ModelAttribute("wine")Wine wine, HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("userId");
    	if(id != null) {
    		User loggedInUser = userService.findById(id);
    		model.addAttribute("user", loggedInUser);
    		model.addAttribute("wines", wineServ.allWines());
    		model.addAttribute("users", userService.allUsers());
    		return "newWine.jsp";
    	}
    	return "redirect:/home";
    }
    
    @PostMapping("/wines/new")
	public String createWine(@Valid @ModelAttribute("wine") Wine wine, Model model, BindingResult result,HttpSession session) {
    	Long id = (Long) session.getAttribute("userId");
    	User loggedInUser = userService.findById(id);
    	
		if(result.hasErrors()) {
    		model.addAttribute("user", loggedInUser);
    		model.addAttribute("wines", wineServ.allWines());
    		model.addAttribute("users", userService.allUsers());
			return "newWine.jsp";
		}else {
			wine.setUser(loggedInUser);
			wineServ.newWine(wine);
			return "redirect:/home";
		}
	}
    
	@RequestMapping(value="/wines/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id")Long id) {
		wineServ.deleteWine(id);
		return "redirect:/home";
	}
    
	@GetMapping("/wines/{id}")
	public String oneWine(@PathVariable("id")Long id, Model model, HttpSession session) {
    	Long usId = (Long) session.getAttribute("userId");
    	if(usId != null) {
    		User loggedInUser = userService.findById(usId);
    		model.addAttribute("wine", wineServ.findone(id));
    		model.addAttribute("user", loggedInUser);
    		return "wine.jsp";
    	}
    	    	return "redirect:/";
    }
	
    @PutMapping("/uploadPhoto")
	public String uploadPhoto(@Valid @ModelAttribute("wine") Wine wine, Model model, BindingResult result,HttpSession session) {
    	Long id = (Long) session.getAttribute("userId");
    	User loggedInUser = userService.findById(id);
    	
		if(result.hasErrors()) {
    		model.addAttribute("user", loggedInUser);
    		model.addAttribute("wines", wineServ.allWines());
    		model.addAttribute("users", userService.allUsers());
			return "newWine.jsp";
		}else {
			wine.setUser(loggedInUser);
			wineServ.updateWine(wine);
			return "redirect:/home";
		}
	}
}
