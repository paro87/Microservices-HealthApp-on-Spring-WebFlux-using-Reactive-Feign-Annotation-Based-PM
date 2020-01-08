package com.paro.hospitalservice.client;

import com.paro.hospitalservice.model.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@ReactiveFeignClient(name = "department-service", fallback = DepartmentClientFallback.class)
public interface DepartmentClient {
    @GetMapping(value = "/service/hospital/{hospitalId}")
    Flux<Department> findByHospital(@PathVariable("hospitalId") Long hospitalId);

    @GetMapping(value = "/service/hospital/{hospitalId}/with-patients")
    Flux<Department> findByHospitalWithPatients(@PathVariable("hospitalId") Long hospitalId);


}