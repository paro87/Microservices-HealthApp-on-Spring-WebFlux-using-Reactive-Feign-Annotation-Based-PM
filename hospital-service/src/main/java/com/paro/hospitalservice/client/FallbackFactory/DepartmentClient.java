/*
package com.paro.hospitalservice.client.FallbackFactory;

import com.paro.hospitalservice.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "department-service")
//@FeignClient(name = "department-service", fallback = DepartmentClientFallback.class)
@FeignClient(name = "department-service", fallbackFactory = DepartmentClientFallbackFactory.class)
public interface DepartmentClient {
    @GetMapping(value = "/service/hospital/{hospitalId}")
    List<Department> findByHospital(@PathVariable("hospitalId") Long hospitalId);

    @GetMapping(value = "/service/hospital/{hospitalId}/with-patients")
    List<Department> findByHospitalWithPatients(@PathVariable("hospitalId") Long hospitalId);


}
*/
