package com.example.demo.domain.service;

import com.example.demo.domain.entity.Register;
import com.example.demo.domain.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisterService {
    RegisterRepository  repository;

    public Register  save(Register register){
        return repository.save(register);


    }
    public List<Register> ListAll (){


        return repository.ListAll();


    }
}


