package com.ticket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.exception.PersistenceException;
import com.ticket.exception.ServiceException;
import com.ticket.model.DepartmentModel;
import com.ticket.model.PriorityModel;
import com.ticket.model.TicketDetailsModel;
import com.ticket.model.UserModel;
import com.ticket.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	UserModel user = new UserModel();
	UserService userSer = new UserService();
	TicketDetailsModel tic = new TicketDetailsModel();
	DepartmentModel dep = new DepartmentModel();
	PriorityModel pri = new PriorityModel();

	@GetMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("pwd") String password,HttpSession session,ModelMap map)
			{

		try {
			if (userSer.logIn(email, password)) {
				user.setEmailId(email);
				user.setPassword(password);
				session.setAttribute("LOGGED_IN_USER", user);
				return "../UserMainPage.jsp";
			}
			else
			{
				map.addAttribute("ERROR","Enter proper id and password");
			}
		} catch (ServiceException e) {
		
			map.addAttribute("ERROR",e.getMessage());
		}
		

		return "../Login.jsp";

	}

	@PostMapping("/reg")
	public String register(@RequestParam("uname") String userName, @RequestParam("email") String emailId,ModelMap map,
			@RequestParam("pwd") String password){
		user.setEmailId(emailId);
		user.setName(userName);
		user.setPassword(password);
		try {
			userSer.register(user);
		} catch (ServiceException e) {
			
			map.addAttribute("ERROR",e.getMessage());	
		}
		return "UserSignUp.jsp";

	}
@GetMapping("/createTicket")
public String ticGen(){
	
	return "../TicketGeneration.jsp";
	
}
@GetMapping("/reopenTicket")
public String ticReopen(@RequestParam("ticId") int ticketId,ModelMap map){
	
	try {
		if(userSer.reopenTicket(ticketId))
		{
			return "redirect:../UserMainPage.jsp";	
		}
	} catch (ServiceException e) {
		map.addAttribute("ERROR",e.getMessage());
	}
	
	return null;
	
	
	
}
@GetMapping("/closeTicket")
public String ticClose(@RequestParam("ticId") int ticketId,ModelMap map) {
 	tic.setId(ticketId);
	try {
		if(userSer.closeTicket(tic))
		{
			return "redirect:../UserMainPage.jsp";	
		}
	} catch (ServiceException e) {
		
		map.addAttribute("ERROR",e.getMessage());
	} catch (PersistenceException e) {
	
		map.addAttribute("ERROR",e.getMessage());
	}
	
	return "redirect:../Index.jsp";
	
	
	
	
}
	@GetMapping("/ticketGen")
	public String ticketGenerate( @RequestParam("sub") String sub,
			@RequestParam("desc") String desc, @RequestParam("dept") String depart, @RequestParam("prior") String prio,HttpSession session)
			{
		user=(UserModel) session.getAttribute("LOGGED_IN_USER");
		try {
			if (userSer.ticketGeneration( user.getEmailId(),sub, desc, depart, prio)) {
				return "redirect:../UserMainPage.jsp";
			}
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		return "redirect:../UserMainPage.jsp";	
	}

	@GetMapping("/viewTickets")
	public String viewByUser(ModelMap modelMap,HttpSession session) throws ServiceException {
		user=(UserModel) session.getAttribute("LOGGED_IN_USER");
		List<TicketDetailsModel> ticketList = userSer.viewTicket(user.getEmailId());
	
		modelMap.addAttribute("TICKET_LIST", ticketList);
		return "../UserViewTickets.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:../index.jsp";
		
		
	}
	
}
