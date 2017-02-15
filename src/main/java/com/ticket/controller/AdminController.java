package com.ticket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.dao.EmployeeDAO;
import com.ticket.exception.PersistenceException;
import com.ticket.exception.ServiceException;
import com.ticket.model.EmployeeModel;
import com.ticket.model.RoleModel;
import com.ticket.model.TicketDetailsModel;
import com.ticket.service.EmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	EmployeeService empSer = new EmployeeService();
	RoleModel role = new RoleModel();
	EmployeeDAO empDAO = new EmployeeDAO();
	
	@GetMapping("/viewTickets")
	public String view(HttpSession session, ModelMap map) throws ServiceException, PersistenceException {
		EmployeeDAO empDAO=new EmployeeDAO();
		EmployeeModel a = (EmployeeModel)session.getAttribute("LOGGED_IN_ADMIN");
		int depId=empDAO.getDepartmentId(a.getEmailId());
		 List<TicketDetailsModel> ticketList =
		 empSer.viewTicketByDepartment(depId);

		 map.addAttribute("TICKET_LIST", ticketList);
		 if (ticketList == null) {
		 map.addAttribute("ERROR", "No tickets found");
		}
		return "../AdminViewTicket.jsp";
	}

	@GetMapping("/assignPage")
	public String assign(@RequestParam("ticId") int ticketId,HttpSession session ) throws ServiceException {
		session.setAttribute("Ticket_id1", ticketId);
		return "../AssignTicket.jsp";
	}

	@GetMapping("/assignEmp")
	public String assignTicket( @RequestParam("empId") int toEmpId, HttpSession session)
			throws ServiceException {
		
		EmployeeModel b = (EmployeeModel) session.getAttribute("LOGGED_IN_ADMIN");
		int ticketId = (int) session.getAttribute("Ticket_id1");
	
		if (empSer.assignTicket(b.getEmailId(), toEmpId, ticketId)) {

			return "redirect:../AdminMainPage.jsp";
		} else
		{
			return "redirect:../AdminMainPage.jsp";
	}
		
	}

	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:../index.jsp";
	}
	@GetMapping("/deleteTicket")
	public String delete(@RequestParam("ticId") int ticketId,ModelMap map) throws ServiceException {
		empSer.deleteTicket(ticketId);
		return "../AdminMainPage.jsp";
	}
}
