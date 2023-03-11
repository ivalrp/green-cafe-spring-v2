package com.green.cafee.springboot.v2.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.cafee.springboot.v2.constant.Gender;
import com.green.cafee.springboot.v2.dto.JobPositionResponseDTO;
import com.green.cafee.springboot.v2.dto.LastEducationResponseDTO;
import com.green.cafee.springboot.v2.exception.BadRequestException;
import com.green.cafee.springboot.v2.model.JobPosition;
import com.green.cafee.springboot.v2.model.LastEducation;
import com.green.cafee.springboot.v2.repository.JobPositionRepository;
import com.green.cafee.springboot.v2.repository.LastEducationRepository;
import com.green.cafee.springboot.v2.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private LastEducationRepository lastEducationRepository;
    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Override
    public List<JobPositionResponseDTO> findJobPosition() {
        List<JobPosition> jobPositionList = jobPositionRepository.findAll();
        return jobPositionList.stream().map( job -> {
            JobPositionResponseDTO dto = new JobPositionResponseDTO();
            dto.setTitle(job.getTitle());
            dto.setSalary(job.getSalary());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<LastEducationResponseDTO> findAllLastEducation() {
        List<LastEducation> lastEducationList = lastEducationRepository.findAll();
        return lastEducationList.stream().map(lastEducation -> {
            LastEducationResponseDTO dto = new LastEducationResponseDTO();
            dto.setSecureId(lastEducation.getSecureId());
            dto.setName(lastEducation.getName());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> findGender() {
        List<Map<String,Object>> result = new ArrayList<>();
        for (Gender gender : Gender.values()){
            Map<String, Object> map = new HashMap<>();
            map.put("name", gender.getName());
            map.put("code", gender.getCode());

            result.add(map);
        }
        return result;
    }

    @Override
    public Map<String, Object> bankResource(String code) throws FileNotFoundException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/bank.json");
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder =new StringBuilder();
        while (scanner.hasNextLine()){
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();
        List<Map<String, Object>> getBank = objectMapper.readValue(stringBuilder.toString(), List.class);
        List<Map<String, Object>> bank_code = getBank.stream().filter(stringObjectMap -> stringObjectMap.get("bank_code").toString().equals(code))
                .collect(Collectors.toList());
        if (getBank.isEmpty())
            throw new BadRequestException("INVALID_CODE");
        return bank_code.get(0);
    }
}
