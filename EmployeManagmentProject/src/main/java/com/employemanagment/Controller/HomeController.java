package com.employemanagment.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employemanagment.Service.EmpService;
import com.employemanagment.entity.Employe;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String index(Model m) {
	List<Employe> list = empService.getAllEmp();
	m.addAttribute("empList" ,list);
		return "index";
		
	}
	@GetMapping("/loadempSave")
	public String loadempSave() {
		return "emp_save";
		
	}
	@GetMapping("/EditEmp/{id}")
	public String EditEmp(@PathVariable int id , Model m) {
//		System.out.println(id);
		Employe emp = empService.getEmpById(id);
		m.addAttribute("emp" , emp);
		return "edit_emp";
		
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employe emp , HttpSession session) {
	System.out.println(emp);
	Employe newEmp =	empService.saveemp(emp);
	if(newEmp!=null) 
	{
	session.setAttribute("msg", "Register Sucessfully");
	}
	else 
	{
	session.setAttribute("msg", "Something Wrong in Server");
	}
		return "redirect:/loadempSave";
		
	}
	
	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute Employe emp , HttpSession session) {
	System.out.println(emp);
	Employe updateEmp =	empService.saveemp(emp);
	if(updateEmp!=null) 
	{
	session.setAttribute("msg", "Update Sucessfully");
	}
	else 
	{
	session.setAttribute("msg", "Something Wrong in Server");
	}
		return "redirect:/";
		
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String loadempSave(@PathVariable int id , HttpSession session) 
	{
		boolean f = empService.deleteEmp(id);
		if(f) 
		{
			session.setAttribute("msg", "Delete Sucessfully");
		}
		else 
		{
			session.setAttribute("msg", "Something Wrong in Server");	
		}
		
		return  "redirect:/";
		
	}

}
