package com.csi.repository;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
    public List<Employee> findByEmpName(String empName);
    public boolean findByEmpEmailAndEmpPw(String empEmail, String empPw);
    public Employee findByEmpSalary(double empSalary);

}
