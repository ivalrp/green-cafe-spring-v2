package com.green.cafee.springboot.v2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.green.cafee.springboot.v2.dto.JobPositionResponseDTO;
import com.green.cafee.springboot.v2.dto.LastEducationResponseDTO;
import com.green.cafee.springboot.v2.dto.PaymentTypeResponseDTO;
import com.green.cafee.springboot.v2.model.JobPosition;
import com.green.cafee.springboot.v2.model.LastEducation;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface MetaService {

    //JOB POSITION
    public List<JobPositionResponseDTO> findJobPosition();

    public JobPosition findJobPositionById(String secureId);

    //LAST EDUCATION
    public List<LastEducationResponseDTO> findAllLastEducation();

    public LastEducation findLastEducationById(String secureId);

    //GENDER
    public List<Map<String, Object>> findGender();

    //BANK
    public Map<String, Object> bankResourceDetail(String code) throws FileNotFoundException, JsonProcessingException;

    public List<Map<String, Object>> bankResource() throws JsonProcessingException, FileNotFoundException;

    //PAYMENT TYPE
    public List<PaymentTypeResponseDTO> findPaymentType();

    //ITEM CATEGORY
    public List<Map<String, Object>> findItemCategory();
}
