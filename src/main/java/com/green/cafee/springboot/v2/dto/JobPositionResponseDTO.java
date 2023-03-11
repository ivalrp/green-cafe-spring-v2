package com.green.cafee.springboot.v2.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class JobPositionResponseDTO implements Serializable {

    private static final long serialVersionUID = -1673460742262849129L;

    private String title;

    private Double salary;
}
