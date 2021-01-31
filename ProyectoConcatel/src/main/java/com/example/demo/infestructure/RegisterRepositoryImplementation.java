package com.example.demo.infestructure;

import com.example.demo.domain.entity.Register;
import com.example.demo.domain.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class RegisterRepositoryImplementation implements RegisterRepository {


    @Override
    public Register save(Register register) {



        try {
            //Crea o abre el archivo .txt
            File archivo = new File("registro.txt");

            //Crea el objeto que sera el que nos ayudara a escribir el archivo
            FileWriter escribir = new FileWriter(archivo, true);

            //Este String es de la manera en la que se escribira en el fichero

            String str= ParseCadena(register);


            escribir.write(str);

            //Cerramos la conexion
            escribir.close();
        } //Si hay algun error esta sera su salida
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
        log.info("Aqui vamos a salvar un registro");
        return register;
    }


    public String ParseCadena(Register register) {

            String str= "Rebel "+register.getName()+" on "+register.getPlanet()+" at "+register.getDate()+"\n";

        return str;
    }

    public List<Register> ListAll() {

        String nombreFichero = "registro.txt";
        List<Register> registers = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            //leemos el fichero linia a linia y lo repetimos hasta el final
            String texto = br.readLine();
            while(texto != null)
            {
                Register reg = ParseRegister(texto);

                registers.add(reg);

                texto = br.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(br != null)
                    br.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }

        return registers;
    }

    public Register ParseRegister(String texto) {


                //con un split i una expresion regular cogemos las partes que nos interesan y generamos un array
                String[] parts = texto.substring(6).split("( on | at )");
                //generamos un registro y le asignamos la informacion del array corespondiente

                Register reg = Register.builder()
                        .name(parts[0])
                        .planet(parts[1])
                        .date(parts[2])
                        .build();



        return reg;
    }







}
