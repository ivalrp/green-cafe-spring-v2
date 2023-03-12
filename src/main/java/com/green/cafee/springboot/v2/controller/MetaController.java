package com.green.cafee.springboot.v2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.green.cafee.springboot.v2.dto.JobPositionResponseDTO;
import com.green.cafee.springboot.v2.dto.LastEducationResponseDTO;
import com.green.cafee.springboot.v2.dto.PaymentTypeResponseDTO;
import com.green.cafee.springboot.v2.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping("/v2/jobPosition")
    public ResponseEntity<List<JobPositionResponseDTO>> findJobPosition(){
        return ResponseEntity.ok().body(metaService.findJobPosition());
    }

    @GetMapping("/v2/lastEducation")
    public ResponseEntity<List<LastEducationResponseDTO>> findLastEducation(){
        return ResponseEntity.ok().body(metaService.findAllLastEducation());
    }

    @GetMapping("/v2/gender")
    public ResponseEntity<List<Map<String,Object>>> findGender(){
        return ResponseEntity.ok().body(metaService.findGender());
    }

    @GetMapping("/v2/bank/{code}")
    public ResponseEntity<Map<String, Object>> findBank(@PathVariable String code) throws FileNotFoundException, JsonProcessingException {
        return ResponseEntity.ok().body(metaService.bankResourceDetail(code));
    }
    @GetMapping("/v2/bank")
    public ResponseEntity<List<Map<String, Object>>> findBank() throws FileNotFoundException, JsonProcessingException {
        return ResponseEntity.ok().body(metaService.bankResource());
    }
    @GetMapping("/v2/paymentType")
    public ResponseEntity<List<PaymentTypeResponseDTO>> findPaymentType() {
        return ResponseEntity.ok().body(metaService.findPaymentType());
    }
    @GetMapping("/v2/itemCategory")
    public ResponseEntity<List<Map<String, Object>>> findItemCategory() {
        return ResponseEntity.ok().body(metaService.findItemCategory());
    }


}
