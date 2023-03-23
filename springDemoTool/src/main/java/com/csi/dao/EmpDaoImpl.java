package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmpDaoImpl {
    @Autowired
    EmpRepo empRepoImpl;

    public Employee saveData(Employee employee) {
        return empRepoImpl.save(employee);
    }

    public List<Employee> getAllData() {
        return empRepoImpl.findAll();
    }

    public Optional<Employee> getDataById(int empId) {
        return empRepoImpl.findById(empId);
    }

    public Employee getDataBySalary(double empSalary) {
        return empRepoImpl.findByEmpSalary(empSalary);
    }

    public List<Employee> getDataByName(String empName) {
        return empRepoImpl.findByEmpName(empName);
    }

    public Employee updateData(Employee employee, int empid) {
        return empRepoImpl.save(employee);
    }

    public void deleteDataById(int empId) {
        empRepoImpl.deleteById(empId);
    }

    public void deleteData() {
        empRepoImpl.deleteAll();
    }

    public boolean getDataByEmailAndPw(String empEmail, String empPw) {
        boolean flag = true;
        if (empRepoImpl.findByEmpEmailAndEmpPw(empEmail, empPw)) {
            flag = false;
        }
        return flag;

    }
}
