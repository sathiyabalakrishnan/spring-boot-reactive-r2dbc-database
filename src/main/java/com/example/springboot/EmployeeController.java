package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Mono<ServerResponse> save(ServerRequest request) {
        return Mono.just(request)
                .flatMap(v -> v.bodyToMono(Employee.class))
                .flatMap(employee -> service.save(employee))
                .flatMap(value -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(value)));
    }

    @GetMapping
    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return service.findAll().collectList()
                .flatMap(value -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(value)));
    }

}