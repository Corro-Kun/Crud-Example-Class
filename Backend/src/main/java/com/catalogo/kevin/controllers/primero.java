package com.catalogo.kevin.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.kevin.models.message;
import java.util.List;
import java.util.ArrayList;



@RestController
public class primero {

    @GetMapping("/")
    public List<message> hola(){
        List<message> mensaje = new ArrayList<message>();
        mensaje.add(new message("hola"));
        mensaje.add(new message("como estan"));

        return mensaje;
    }

    @PostMapping("/")
    public String hola2(@RequestBody message data){
        return data.getMessage();
    }

    @PutMapping("/")
    public String hola3(){
        return "hola soy el metodo put";
    }

    @DeleteMapping("/")
    public String hola4(){
        return "hola soy el metodo delete";
    }
}
