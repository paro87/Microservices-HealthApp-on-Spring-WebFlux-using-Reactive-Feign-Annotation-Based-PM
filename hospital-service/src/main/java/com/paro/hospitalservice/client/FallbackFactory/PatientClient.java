/*
package com.paro.hospitalservice.client.FallbackFactory;

import com.paro.hospitalservice.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "patient-service")
//@FeignClient(name = "patient-service", fallback = PatientClientFallback.class)
@FeignClient(name = "patient-service", fallbackFactory = PatientClientFallbackFactory.class)
public interface PatientClient {
    @GetMapping("/service/hospital/{hospitalId}")
    List<Patient> findByHospital(@PathVariable("hospitalId") Long hospitalId);

}
*/
