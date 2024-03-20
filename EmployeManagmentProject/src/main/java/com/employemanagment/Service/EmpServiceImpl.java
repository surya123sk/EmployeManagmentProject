package com.employemanagment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.employemanagment.entity.Employe;
import com.employemanagment.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceImpl  implements EmpService{
	
	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employe saveemp(Employe emp) {
		Employe newEmp = empRepository.save(emp);
		return newEmp;
	}

	@Override
	public List<Employe> getAllEmp() {
		
		return empRepository.findAll();
	}

	@Override
	public Employe getEmpById(int id) {
		
		return empRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employe emp = empRepository.findById(id).get();
		if(emp!= null) 
		{
			empRepository.delete(emp);
			return true ;
		}
		return false;
	}
	
	public void removeSessionMessage() {
	HttpSession session =	((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	session.removeAttribute("msg");
	}

}
