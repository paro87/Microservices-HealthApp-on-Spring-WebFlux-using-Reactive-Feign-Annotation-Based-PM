package com.paro.hospitalservice.client;

import com.paro.hospitalservice.model.Department;
import com.paro.hospitalservice.model.Patient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentClientFallback implements DepartmentClient {
    @Override
    public Flux<Department> findByHospital(Long hospitalId) {
        Department departmentNotFound=new Department(0L, "UNKNOWN", hospitalId,null);
        List<Department> departmentListNotFound=new ArrayList<>();
        departmentListNotFound.add(departmentNotFound);
        return Flux.fromIterable(departmentListNotFound);
    }

    @Override
    public Flux<Department> findByHospitalWithPatients(Long hospitalId) {
        Patient patientNotFound=new Patient(0L, "UNKNOWN", "UNKNOWN", hospitalId,0L);
        List<Patient> patientListNotFound=new ArrayList<>();
        patientListNotFound.add(patientNotFound);
        Department departmentNotFound=new Department(0L, "UNKNOWN", hospitalId,null);
        List<Department> departmentListNotFound=new ArrayList<>();
        departmentNotFound.setPatientList(patientListNotFound);
        departmentListNotFound.add(departmentNotFound);
        return Flux.fromIterable(departmentListNotFound);
    }
}
