package com.example.demo.domain.entity;


import lombok.*;

@Builder
@ToString
@Getter
@Setter
public class Register {

    private String name;
    private String planet;
    private String date;

}
