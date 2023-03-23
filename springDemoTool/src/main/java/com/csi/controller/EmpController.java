package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class EmpController {
    @Autowired
    EmpServiceImpl empService;
    @PostMapping("/saveData")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(empService.saveData(employee));
    }
    @GetMapping("/getAllData")
    public  ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(empService.getAllData());
    }
    @GetMapping("/getDataById/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(empService.getDataById(empId));

    }
    @PutMapping("/updateData/{empId}")
    public ResponseEntity<Employee> updateData(@RequestBody Employee employee, @PathVariable int empId){
        Employee employee1 = empService.getDataById(empId).orElseThrow(()->new RuntimeException("Record Not Found"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        return new ResponseEntity<>(empService.updateData(employee,empId), HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/deleteDataById/{empId}")
    public  ResponseEntity<String> deleteDataById(@PathVariable int empId){
        empService.deleteDataById(empId);
        return ResponseEntity.ok("delete Data By Id");
    }
    @DeleteMapping("/deleteData")
    public ResponseEntity<String> deleteData(){
        empService.deleteData();
        return ResponseEntity.ok("delete Data");
    }
    @GetMapping("/getDataByPwAndemail/{empEmail}/{empPw}")
    public ResponseEntity<Boolean> getData(@PathVariable String empEmail,@PathVariable String empPw){
       return ResponseEntity.ok(empService.getDataByEmailAndPw(empEmail,empPw)) ;
    }
    @GetMapping("/getDataByName/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
        return ResponseEntity.ok(empService.getDataByName(empName));
    }
}
