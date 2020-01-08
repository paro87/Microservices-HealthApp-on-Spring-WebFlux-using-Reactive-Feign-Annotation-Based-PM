/*
package com.paro.departmentservice.client.fallbackFactory;



import com.paro.departmentservice.client.fallbackFactory.PatientClient;
import com.paro.departmentservice.client.fallbackFactory.PatientClientFallback;
import org.springframework.stereotype.Component;
import reactivefeign.FallbackFactory;

//Waiting till ReactiveFeign supports Hystrix.
//In Feign FallbackFactory interface is located in feign.hystrix.FallbackFactory;
//Whereas in ReactiveFactory FallbackFactory interface is located in reactivefeign.FallbackFactory
//There is a problem in injecting the PatientClient in Service layer, may be because of Hystrix or the mentioned library

@Component
public class PatientClientFallbackFactory implements FallbackFactory<PatientClient> {

    @Override
    public PatientClient apply(Throwable throwable) {
        return new PatientClientFallback(throwable);
    }
}
*/
