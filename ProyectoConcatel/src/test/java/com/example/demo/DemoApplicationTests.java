package com.example.demo;

import com.example.demo.Application.Controller.RegisterController;
import com.example.demo.Application.Controller.RegisterRequest;
import com.example.demo.Application.Controller.RegisterResponse;
import com.example.demo.domain.entity.Register;
import com.example.demo.domain.service.RegisterService;
import com.example.demo.infestructure.RegisterRepositoryImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.omg.CORBA.Any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {
    @Mock
    RegisterService service;
    @InjectMocks
    RegisterController controller;
    @Test
    void contextLoads() {
    }
    @Test
    void testController() {
        RegisterRequest reg= RegisterRequest.builder()
                .planet("Jupiter")
                .name("Alex")
                .date("14:50:59 24/01/2021")
                .build();

        when(service.save(any())).thenReturn(
                Register.builder()
                .planet("Jupiter")
                .name("Alex")
                .date("14:50:59 24/01/2021")
                .build()
        );

        ResponseEntity<RegisterResponse> response= controller.addRegister(reg);

        Assertions.assertEquals(reg.getName(),response.getBody().getName());
        Assertions.assertEquals(reg.getPlanet(),response.getBody().getPlanet());
        Assertions.assertEquals(reg.getDate(),response.getBody().getDate());



    }

}
