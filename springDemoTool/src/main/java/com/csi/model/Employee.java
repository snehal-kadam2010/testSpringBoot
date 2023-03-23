package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int empId;
    @Size(min = 4)
    private String empName;
    @Email
    @Column(unique = true)
    private String empEmail;
    private String empPw;
    @NotNull
    private  double empSalary;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date empDob;

}
