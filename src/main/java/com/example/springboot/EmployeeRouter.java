package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> route(EmployeeController employeeController) {

        return RouterFunctions
                .route(POST("/save")
                        .and(accept(MediaType.APPLICATION_JSON)), employeeController::save)
                .andRoute(GET("/findall")
                        .and(accept(MediaType.APPLICATION_JSON)), employeeController::findAll);
    }
}