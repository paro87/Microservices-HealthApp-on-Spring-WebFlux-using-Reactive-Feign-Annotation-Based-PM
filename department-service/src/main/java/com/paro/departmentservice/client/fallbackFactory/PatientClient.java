/*
package com.paro.departmentservice.client.fallbackFactory;

import com.paro.departmentservice.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

//Waiting for Feign to support WebFlux
@ReactiveFeignClient(name = "patient-service", fallbackFactory = PatientClientFallbackFactory.class)
public interface PatientClient {
    @GetMapping("/service/department/{departmentId}")
    Flux<Patient> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
*/
