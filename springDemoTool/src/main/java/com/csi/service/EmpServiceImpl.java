package com.csi.service;

import com.csi.dao.EmpDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl {
    @Autowired
    EmpDaoImpl empDao;
    public Employee saveData(Employee employee) {
        return empDao.saveData(employee);
    }

    public List<Employee> getAllData() {
        return empDao.getAllData();
    }

    public Optional<Employee> getDataById(int empId) {
        return empDao.getDataById(empId);
    }

    public Employee getDataBySalary(double empSalary) {
        return empDao.getDataBySalary(empSalary);
    }

    public List<Employee> getDataByName(String empName) {
        return empDao.getDataByName(empName);
    }

    public Employee updateData(Employee employee, int empid) {
        return empDao.updateData(employee,empid);
    }

    public void deleteDataById(int empId) {
        empDao.deleteDataById(empId);
    }

    public void deleteData() {
        empDao.deleteData();
    }

    public boolean getDataByEmailAndPw(String empEmail, String empPw) {
        boolean flag = true;
        if (empDao.getDataByEmailAndPw(empEmail,empPw)) {
            flag = false;
        }
        return flag;

    }
}
