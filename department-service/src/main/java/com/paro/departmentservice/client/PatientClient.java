package com.paro.departmentservice.client;

import com.paro.departmentservice.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@ReactiveFeignClient(name = "patient-service", fallback = PatientClientFallback.class)
public interface PatientClient {
    @GetMapping("service/department/{departmentId}")
    Flux<Patient> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
