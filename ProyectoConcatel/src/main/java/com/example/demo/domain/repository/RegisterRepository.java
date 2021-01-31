package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Register;

import java.util.List;

public interface RegisterRepository {
    Register save(Register register);
    List<Register> ListAll();

    }
