package com.green.cafee.springboot.v2.service.impl;

import com.green.cafee.springboot.v2.dto.EmployeeCreateRequestDTO;
import com.green.cafee.springboot.v2.dto.EmployeeResponsetDTO;
import com.green.cafee.springboot.v2.dto.EmployeeUpdateRequestDTO;
import com.green.cafee.springboot.v2.exception.BadRequestException;
import com.green.cafee.springboot.v2.model.Employee;
import com.green.cafee.springboot.v2.model.JobPosition;
import com.green.cafee.springboot.v2.model.LastEducation;
import com.green.cafee.springboot.v2.repository.EmployeeRepository;
import com.green.cafee.springboot.v2.service.EmployeeService;
import com.green.cafee.springboot.v2.service.MetaService;
import com.green.cafee.springboot.v2.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private MetaService metaService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createNewEmployee(EmployeeCreateRequestDTO dto) throws ParseException {
        JobPosition jobPosition = metaService.findJobPositionById(dto.getJobPositionId());
        LastEducation lastEducation = metaService.findLastEducationById(dto.getLastEducationId());

        Employee employee = new Employee();
        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());
        employee.setPob(dto.getPob());
        employee.setDob(DateUtil.stringToDate(dto.getDob()));
        employee.setGender(dto.getGender());
        employee.setMobilePhoneNumber(dto.getMobilePhoneNumber());
        employee.setJobPositionId(jobPosition);
        employee.setLastEducationId(lastEducation);

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(String secureId, EmployeeUpdateRequestDTO dto) throws ParseException {
        Employee employee = employeeRepository.findBySecureId(secureId)
                .orElseThrow(() -> new BadRequestException("INVALID_EMPLOYEE_ID"));
        JobPosition jobPosition = metaService.findJobPositionById(dto.getJobPositionId());
        LastEducation lastEducation = metaService.findLastEducationById(dto.getLastEducationId());

        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());
        employee.setPob(dto.getPob());
        employee.setDob(DateUtil.stringToDate(dto.getDob()));
        employee.setGender(dto.getGender());
        employee.setMobilePhoneNumber(dto.getMobilePhoneNumber());
        employee.setJobPositionId(jobPosition);
        employee.setLastEducationId(lastEducation);

        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String secureId) {
        Employee employee = employeeRepository.findBySecureId(secureId)
                .orElseThrow(() -> new BadRequestException("INVALID_EMPLOYEE_ID"));
        employeeRepository.delete(employee);
    }

    @Override
    public void findEmployeeDetail(String secureId) {
        Employee employee = employeeRepository.findBySecureId(secureId)
                .orElseThrow(() -> new BadRequestException("INVALID_EMPLOYEE_ID"));
        EmployeeResponsetDTO dto = new EmployeeResponsetDTO();
        dto.setFullName(employee.getFullName());
        dto.setGender(employee.getGender());
        dto.setDob(String.valueOf(employee.getDob()));
        dto.setPob(employee.getPob());
        dto.setEmail(employee.getEmail());

    }

}
