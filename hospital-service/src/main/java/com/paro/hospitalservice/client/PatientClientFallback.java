package com.paro.hospitalservice.client;

import com.paro.hospitalservice.model.Patient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientClientFallback implements PatientClient {

    @Override
    public Flux<Patient> findByHospital(Long hospitalId) {
        Patient patientNotFound=new Patient(0L, "UNKNOWN", "UNKNOWN", hospitalId,0L);
        List<Patient> patientListNotFound=new ArrayList<>();
        patientListNotFound.add(patientNotFound);
        return Flux.fromIterable(patientListNotFound);
    }
}

