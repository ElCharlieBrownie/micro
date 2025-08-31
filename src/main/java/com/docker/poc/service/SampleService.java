package com.docker.poc.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private static final String SAMPLE_SERVICE = "sampleService";

    /**
     * Simulates a service call that might fail.
     *
     * @return Response from the external service or throws an exception
     */
    @CircuitBreaker(name = SAMPLE_SERVICE, fallbackMethod = "fallbackResponse")
    public String callExternalService() {
        // Simulating a random failure
        if (Math.random() > 0.5) {
            throw new RuntimeException("Service failed");
        }
        return "Service call succeeded";
    }

    /**
     * Fallback method called when the circuit breaker is open.
     *
     * @param ex Exception thrown
     * @return Fallback response
     */
    public String fallbackResponse(Exception ex) {
        return "Fallback response: " + ex.getMessage();
    }
}
