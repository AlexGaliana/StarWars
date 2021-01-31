package com.example.demo.Application.Controller;


import lombok.*;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String planet;
    private String date;

}
