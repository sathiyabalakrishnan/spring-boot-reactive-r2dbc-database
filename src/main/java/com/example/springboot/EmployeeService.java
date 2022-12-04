package com.example.springboot;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<Employee> save(Employee employee);

    Flux<Employee> findAll();

}