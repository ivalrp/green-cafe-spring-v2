package com.green.cafee.springboot.v2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.green.cafee.springboot.v2.dto.JobPositionResponseDTO;
import com.green.cafee.springboot.v2.dto.LastEducationResponseDTO;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface MetaService {

    public List<JobPositionResponseDTO> findJobPosition();

    public List<LastEducationResponseDTO> findAllLastEducation();

    public List<Map<String, Object>> findGender();

    public Map<String, Object> bankResource(String code) throws FileNotFoundException, JsonProcessingException;

}
