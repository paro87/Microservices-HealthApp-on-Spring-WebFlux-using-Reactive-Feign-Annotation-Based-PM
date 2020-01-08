package com.paro.departmentservice.service;

import com.paro.departmentservice.client.PatientClient;
import com.paro.departmentservice.model.Department;
import com.paro.departmentservice.model.Patient;
import com.paro.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    private final PatientClient patientClient;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService (DepartmentRepository departmentRepository, PatientClient patientClient) {
        this.departmentRepository=departmentRepository;
        this.patientClient=patientClient;
    }
/*
    //Encountered a problem during fetching a host name from Eureka
    @Autowired
    WebClient webClient;

    @LoadBalanced
    @Bean
    public WebClient webClient(){
        return WebClient.create();
    }*/


    //For testing
//    private WebClient webClient;
//    DepartmentService(WebClient webClient){
//        this.webClient=webClient;
//    }

    public Flux<Department> getAll() {
        Flux<Department> departmentsFound=departmentRepository.findAll();
        LOGGER.info("Departments found");
        return departmentsFound;
    }


    public Mono<Department> getByDepartmentId(Long departmentId){
        Mono<Department> departmentFound=departmentRepository.findByDepartmentId(departmentId);
        LOGGER.info("Department found with id={}: ", departmentId);
        return departmentFound;
    }

    public Mono<Department> add(Mono<Department> department){
        Mono<Department> departmentSaved=departmentRepository.saveAll(department).next();
        LOGGER.info("Department added with id={}", departmentSaved.subscribe(d-> System.out.println(d.getDepartmentId())));
        return departmentSaved;
    }

    public Mono<Department> put(Long departmentId, Mono<Department> departmentToPut) {
        return departmentRepository.findByDepartmentId(departmentId)
                .flatMap(department ->departmentRepository.delete(department))
                .then(departmentRepository.saveAll(departmentToPut).next());

        // Possible 2nd solution
        /*
        Mono<Department> departmentFound=departmentRepository.findByDepartmentId(departmentId);
        Mono<Department> departmentPut=departmentFound.map(departmentFromRepo -> {
            departmentToPut.map(departmentBeingPut -> {
                if (departmentBeingPut.getName()!=null) {
                    departmentFromRepo.setName(departmentBeingPut.getName());
                }
                if (departmentBeingPut.getHospitalId()!=null) {
                    departmentFromRepo.setHospitalId(departmentBeingPut.getHospitalId());
                }
                if (departmentBeingPut.getPatientList()!=null) {
                    departmentFromRepo.setPatientList(departmentBeingPut.getPatientList());
                }
                return departmentFromRepo;
            }).subscribe();
            return departmentFromRepo;
        });
        return departmentRepository.saveAll(departmentPut).next();*/
    }

    //1-Patch: Department object
    /*
    public Mono<Department> patch(Long departmentId, Department departmentToPatch) {
        Mono<Department> departmentFound=departmentRepository.findByDepartmentId(departmentId);
        Mono<Department> departmentPatched=departmentFound.map(department -> {
            if (departmentToPatch.getDepartmentId()!=null) {
                department.setDepartmentId(departmentToPatch.getDepartmentId());
            }
            if (departmentToPatch.getName()!=null) {
                department.setName(departmentToPatch.getName());
            }
            if (departmentToPatch.getHospitalId()!=null) {
                department.setHospitalId(departmentToPatch.getHospitalId());
            }
            if (departmentToPatch.getPatientList()!=null) {
                department.setPatientList(departmentToPatch.getPatientList());
            }
            return department;
        });
        return departmentRepository.saveAll(departmentPatched).next();
    }
    */


    //2-Patch: Mono<Department> object
    public Mono<Department> patch(Long departmentId, Mono<Department> departmentToPatch) {
        Mono<Department> departmentFound=departmentRepository.findByDepartmentId(departmentId);
        Mono<Department> departmentPatched=departmentFound.map(departmentFromRepo -> {

            departmentToPatch.map(departmentBeingPatched -> {

                if (departmentBeingPatched.getDepartmentId()!=null) {
                    departmentFromRepo.setDepartmentId(departmentBeingPatched.getDepartmentId());
                }
                if (departmentBeingPatched.getName()!=null) {
                    departmentFromRepo.setName(departmentBeingPatched.getName());
                }
                if (departmentBeingPatched.getHospitalId()!=null) {
                    departmentFromRepo.setHospitalId(departmentBeingPatched.getHospitalId());
                }
                if (departmentBeingPatched.getPatientList()!=null) {
                    departmentFromRepo.setPatientList(departmentBeingPatched.getPatientList());
                }
                return departmentFromRepo;
            }).subscribe();
            return departmentFromRepo;
        });
        return departmentRepository.saveAll(departmentPatched).next();
    }

    public void deleteById(Long departmentId) {
        Mono<Department> departmentToBeDeleted=departmentRepository.findByDepartmentId(departmentId);
        departmentToBeDeleted.flatMap(department ->departmentRepository.delete(department)).subscribe();
    }



    public Flux<Department> getByHospitalId(Long hospitalId){
        Flux<Department> departmentsFound=departmentRepository.findByHospitalId(hospitalId);
        LOGGER.info("Departments found for the hospital with an id={}", hospitalId);
        return departmentsFound;
    }


    public Flux<Department> getByHospitalWithPatients(Long hospitalId) {
        Flux<Department> departmentList = departmentRepository.findByHospitalId(hospitalId);

        return departmentList.flatMap(department -> {

            Flux<Patient> patientFlux = patientClient.findByDepartment(department.getDepartmentId());
            return patientFlux.collectList().map(list -> {
                department.setPatientList(list);
                return department;
            });
        });



    }
}
