package com.employemanagment.Service;

import java.util.List;

import com.employemanagment.entity.Employe;

public interface EmpService  {
	
	public Employe saveemp(Employe emp);
	public List<Employe> getAllEmp();
	public Employe getEmpById(int id);
	public boolean deleteEmp(int id);

}
