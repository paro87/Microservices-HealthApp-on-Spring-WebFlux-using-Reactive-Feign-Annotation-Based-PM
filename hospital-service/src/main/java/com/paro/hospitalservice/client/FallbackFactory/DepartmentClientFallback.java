/*
package com.paro.hospitalservice.client.FallbackFactory;

import com.paro.hospitalservice.model.Department;
import com.paro.hospitalservice.model.Patient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DepartmentClientFallback implements DepartmentClient {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Throwable cause;

    public DepartmentClientFallback(Throwable throwable) {
        cause=throwable;
    }

    @Override
    public List<Department> findByHospital(Long hospitalId) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404)  {
            logger.error("404 page not found" + hospitalId + "error message: " + cause.getLocalizedMessage());
        } else {
            logger.error("Other error took place: " + cause.getLocalizedMessage());
        }
        Department departmentNotFound=new Department(0L, "UNKNOWN", hospitalId,null);
        List<Department> departmentListNotFound=new ArrayList<>();
        departmentListNotFound.add(departmentNotFound);
        return departmentListNotFound;
    }

    @Override
    public List<Department> findByHospitalWithPatients(Long hospitalId) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404)  {
            logger.error("404 page not found" + hospitalId + "error message: " + cause.getLocalizedMessage());
        } else {
            logger.error("Other error took place: " + cause.getLocalizedMessage());
        }
        Patient patientNotFound=new Patient(0L, "UNKNOWN", "UNKNOWN", hospitalId,0L);
        List<Patient> patientListNotFound=new ArrayList<>();
        patientListNotFound.add(patientNotFound);
        Department departmentNotFound=new Department(0L, "UNKNOWN", hospitalId,null);
        List<Department> departmentListNotFound=new ArrayList<>();
        departmentNotFound.setPatientList(patientListNotFound);
        departmentListNotFound.add(departmentNotFound);
        return departmentListNotFound;
    }
}
*/
