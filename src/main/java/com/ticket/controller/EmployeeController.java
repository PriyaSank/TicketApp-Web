package com.ticket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.dao.EmployeeDAO;
import com.ticket.exception.PersistenceException;
import com.ticket.exception.ServiceException;
import com.ticket.model.EmployeeModel;
import com.ticket.model.IssueModel;
import com.ticket.model.RoleModel;
import com.ticket.model.TicketDetailsModel;
import com.ticket.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	int roleId;
	EmployeeService empSer = new EmployeeService();
		RoleModel role = new RoleModel();
	EmployeeDAO empDAO = new EmployeeDAO();
	
	@GetMapping("/login")
	public String logIn(@RequestParam("email") String email, @RequestParam("pwd") String password, HttpSession session,
			ModelMap map) {
		EmployeeModel emp=new EmployeeModel();
		try {
			if (empSer.logIn(email, password)) {
				roleId = empDAO.getRoleId(email);
				role.setId(roleId);
				emp.setRole(role);
				emp.setEmailId(email);
				emp.setPassword(password);
				EmployeeModel admin = new EmployeeModel();
				if (roleId == 1) {
					session.setAttribute("LOGGED_IN_ADMIN", emp);
					
					return "../AdminMainPage.jsp";
				} else {
					session.setAttribute("LOGGED_IN_EMP", emp);
					return "../EmployeeMainPage.jsp";
				}
			}
		} catch (ServiceException e) {

			map.addAttribute("ERROR", e.getMessage());
		} catch (PersistenceException e) {

			e.printStackTrace();
		}

		return "../EmployeeLogin.jsp";

	}

	@GetMapping("/viewTickets")
	public String view(HttpSession session, ModelMap map) throws ServiceException {
		EmployeeModel empV = (EmployeeModel) session.getAttribute("LOGGED_IN_EMP");
		
		List<TicketDetailsModel> ticketList = empSer.viewAssignedTicket(empV.getEmailId());

		map.addAttribute("TICKET_LIST", ticketList);
		if (ticketList == null) {
			map.addAttribute("ERROR", "No tickets found");
			return "../Message.jsp";
		}else
		{
		return "../EmpViewTickets.jsp";
		}
	}

	@GetMapping("/replyTicket")
	public String reply(HttpSession session, ModelMap map, @RequestParam("soln") String solution) throws PersistenceException {
		EmployeeModel emp1 = (EmployeeModel) session.getAttribute("LOGGED_IN_EMP");
		int ticketId = (int) session.getAttribute("Ticket_id1");
		
		try {
			EmployeeModel empl=new EmployeeModel();
			EmployeeDAO eDAO=new EmployeeDAO();
			TicketDetailsModel tic=new TicketDetailsModel();
			int empId=eDAO.getId(emp1.getEmailId());
			IssueModel issue=new IssueModel();
			empl.setId(empId);
			issue.setEmp(empl);
			tic.setId(ticketId);
			issue.setSolution(solution);
			issue.setTic(tic);
			System.out.println(issue);
			
			empSer.replyToTicket(issue);
		} catch (ServiceException e) {
			map.addAttribute("ERROR", "No tickets found");
		}

		return "../EmployeeMainPage.jsp";
	}

	@GetMapping("/replyPage")
	public String replyTic(@RequestParam("ticId") int ticketId, HttpSession session) throws ServiceException {
		session.setAttribute("Ticket_id1", ticketId);
		return "../ReplyPage.jsp";
	}
	
	@GetMapping("/reassignPage")
	public String reassignTic(@RequestParam("ticId") int ticketId, HttpSession session) throws ServiceException {
		session.setAttribute("Ticket_id2", ticketId);
		return "../Reassign.jsp";
	}
	
	@GetMapping("/reassignTicket")
	public String reassign(@RequestParam("emp2Id") int emp2Id, HttpSession session,ModelMap map)  {
		EmployeeModel emp1 = (EmployeeModel) session.getAttribute("LOGGED_IN_EMP");
		int ticketId = (int) session.getAttribute("Ticket_id2");
		System.out.println(emp1.getId()+"one");
		System.out.println(emp2Id+"one");
		System.out.println(ticketId+"one");
		try {
			if (empSer.reassignTicket(emp1.getId(), emp2Id, ticketId)) {

				return "../EmpMainPage.jsp";
			} 
		} catch (ServiceException e) {
			map.addAttribute("ERROR",e.getMessage());
	
		}
		return "redirect:../index.jsp";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:../index.jsp";
	}
}
