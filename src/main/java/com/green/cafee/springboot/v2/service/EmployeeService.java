package com.green.cafee.springboot.v2.service;

import com.green.cafee.springboot.v2.dto.EmployeeCreateRequestDTO;
import com.green.cafee.springboot.v2.dto.EmployeeUpdateRequestDTO;
import com.green.cafee.springboot.v2.model.Employee;

import java.text.ParseException;

public interface EmployeeService {

    public void createNewEmployee(EmployeeCreateRequestDTO dto) throws ParseException;

    public void updateEmployee(String secureId, EmployeeUpdateRequestDTO dto) throws ParseException;

    public void deleteEmployee(String secureId);

    public void findEmployeeDetail(String secureId);
}
