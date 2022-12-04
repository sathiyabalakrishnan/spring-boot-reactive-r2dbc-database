package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Mono<Employee> save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Flux<Employee> findAll() {
        return repository.findAll();
    }
}