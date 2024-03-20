package com.employemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employemanagment.entity.Employe;

public interface EmpRepository extends JpaRepository<Employe , Integer> {

}
