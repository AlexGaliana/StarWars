package com.example.demo.Application.Controller;




import com.example.demo.domain.entity.Register;
import com.example.demo.domain.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(value = "/register")
public class RegisterController {

    final
    RegisterService service;
    public Object addRegister;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @GetMapping(value = "",produces = "application/json")
    public ResponseEntity<List<RegisterResponse>> list(){
        //generamos el array de registros
        List<RegisterResponse> registerResponseList= new ArrayList<>();

        List<Register> registers = service.ListAll();
        //en este for introducimos la informacion de todos los registros
        for (Register register : registers) {
            registerResponseList.add(
                    RegisterResponse.builder()
                    .name(register.getName())
                    .planet(register.getPlanet())
                    .date(register.getDate())
                    .build()
            );
        }
        //devolvemos el array lleno con todos los registros

        return new ResponseEntity<>(
                registerResponseList,
                HttpStatus.OK
        );

    }
    @PostMapping(value = "/add",produces = "application/json")
    public ResponseEntity<RegisterResponse>   addRegister ( @RequestBody RegisterRequest  request){

        Register register = Register.builder().name(request.getName()).planet(request.getPlanet()).date(request.getDate()).build();
        Register newRegister;
        newRegister = service.save(register);
        RegisterResponse response=RegisterResponse.builder().name(newRegister.getName()).planet(newRegister.getPlanet()).date(request.getDate()).build();
        //lo devolvemos para que pueda ser introducido

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );

    }


}
