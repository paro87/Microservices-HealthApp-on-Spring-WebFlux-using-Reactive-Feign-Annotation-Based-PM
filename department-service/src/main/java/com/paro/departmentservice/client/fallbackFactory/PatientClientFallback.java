/*
package com.paro.departmentservice.client.fallbackFactory;
import com.paro.departmentservice.client.fallbackFactory.PatientClient;
import com.paro.departmentservice.model.Patient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class PatientClientFallback implements PatientClient {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Throwable cause;

    public PatientClientFallback(Throwable throwable) {
        cause=throwable;
    }

    @Override
    public Flux<Patient> findByDepartment(Long departmentId) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404)  {
            logger.error("404 page not found" + departmentId + "error message: " + cause.getLocalizedMessage());
        } else {
            logger.error("Other error took place: " + cause.getLocalizedMessage());
        }
        Patient patientNotFound=new Patient(0L, "UNKNOWN", "UNKNOWN", 0L,departmentId);
        List<Patient> patientListNotFound=new ArrayList<>();
        patientListNotFound.add(patientNotFound);
        return Flux.fromIterable(patientListNotFound);
    }
}
*/
