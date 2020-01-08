package com.paro.hospitalservice.client;

import com.paro.hospitalservice.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;


@ReactiveFeignClient(name = "patient-service", fallback = PatientClientFallback.class)
public interface PatientClient {
    @GetMapping("/service/hospital/{hospitalId}")
    Flux<Patient> findByHospital(@PathVariable("hospitalId") Long hospitalId);

}
