package com.green.cafee.springboot.v2.controller;

import com.green.cafee.springboot.v2.dto.EmployeeCreateRequestDTO;
import com.green.cafee.springboot.v2.dto.EmployeeUpdateRequestDTO;
import com.green.cafee.springboot.v2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.ParseException;

@RestController
@RequestMapping("api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/v2/employee")
    public ResponseEntity<Void> createNewEmployee(@RequestBody EmployeeCreateRequestDTO dto) throws ParseException {
        employeeService.createNewEmployee(dto);
        return ResponseEntity.created(URI.create("/employee")).build();
    }

    @PutMapping("/v2/employee/{secureId}")
    public ResponseEntity<Void> updateEmployee(
            @PathVariable("secureId") String secureId,
            @RequestBody EmployeeUpdateRequestDTO dto) throws ParseException {
        employeeService.updateEmployee(secureId, dto);
        return ResponseEntity.ok().build();
    }
}
