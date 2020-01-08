package com.paro.departmentservice.client;

import com.paro.departmentservice.model.Patient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientClientFallback implements PatientClient {
    @Override
    public Flux<Patient> findByDepartment(Long departmentId) {
        Patient patientNotFound=new Patient(0L, "UNKNOWN", "UNKNOWN", 0L,departmentId);
        List<Patient> patientListNotFound=new ArrayList<>();
        patientListNotFound.add(patientNotFound);
        return Flux.fromIterable(patientListNotFound);
    }
}
