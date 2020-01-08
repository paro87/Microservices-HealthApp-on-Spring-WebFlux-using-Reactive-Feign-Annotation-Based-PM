package com.paro.hospitalservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

@Getter
@Setter
@ToString

public class Department {
    private String id;
    private Long departmentId;
    private String name;
    private Long hospitalId;
    private List<Patient> patientList=new ArrayList<>();

    public Department(Long departmentId, String name, Long hospitalId) {
        this.departmentId = departmentId;
        this.name = name;
        this.hospitalId = hospitalId;
    }

    public Department(Long departmentId, String name, Long hospitalId, List<Patient> patientList) {
        this.departmentId = departmentId;
        this.name = name;
        this.hospitalId = hospitalId;
        this.patientList=patientList;
    }
}
