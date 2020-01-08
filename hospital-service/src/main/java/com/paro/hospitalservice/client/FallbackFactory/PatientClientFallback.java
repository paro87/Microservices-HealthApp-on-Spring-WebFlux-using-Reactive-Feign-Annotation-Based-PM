/*
package com.paro.hospitalservice.client.FallbackFactory;

import com.paro.hospitalservice.model.Patient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PatientClientFallback implements PatientClient {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Throwable cause;

    public PatientClientFallback(Throwable throwable) {
        cause=throwable;
    }

    @Override
    public List<Patient> findByHospital(Long hospitalId) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404)  {
            logger.error("404 page not found" + hospitalId + "error message: " + cause.getLocalizedMessage());
        } else {
            logger.error("Other error took place: " + cause.getLocalizedMessage());
        }
        Patient patientNotFound=new Patient(0L, "UNKNOWN", "UNKNOWN", hospitalId,0L);
        List<Patient> patientListNotFound=new ArrayList<>();
        patientListNotFound.add(patientNotFound);
        return patientListNotFound;
    }
}
*/
