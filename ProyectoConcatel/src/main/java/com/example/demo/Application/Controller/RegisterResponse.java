package com.example.demo.Application.Controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class RegisterResponse {

    private String name;
    private String planet;
    private String date;


}
