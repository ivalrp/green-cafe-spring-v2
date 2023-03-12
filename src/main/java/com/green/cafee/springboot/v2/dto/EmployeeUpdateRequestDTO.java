package com.green.cafee.springboot.v2.dto;

import lombok.Data;

@Data
public class EmployeeUpdateRequestDTO {

    private String fullName;

    private String dob;

    private String pob;

    private String gender;

    private String email;

    private String mobilePhoneNumber;

    private String jobPositionId;

    private String lastEducationId;
}
