package com.catalogo.kevin.controllers;

import com.catalogo.kevin.models.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.kevin.models.productos;
import com.catalogo.kevin.repositorio.CatalogoRepositorio;

import java.util.List;


@RestController
public class CatalogoControl {
    private final CatalogoRepositorio repositorio;

    @Autowired
    public CatalogoControl(CatalogoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/catalogo")
    public List<productos> ListDatas(){
        return repositorio.GetProductos();
    } 

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/catalogo/{id}")
    public productos findCatalogo(@PathVariable(value="id") int id){
        return repositorio.oneProducto(id) ;
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/catalogo")
    public message newCatalogo(@RequestBody productos producto){
        boolean a =  repositorio.newProductoD(producto);
        return new message("Producto agregado con exito");
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/catalogo/{id}")
    public message modifCatalogo(@PathVariable(value="id") int id, @RequestBody productos producto){
        boolean a = repositorio.putProductoD(producto, id);
        return new message("Modificar catalogo");
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/catalogo/{id}")
    public message deleteCatalogo(@PathVariable(value="id") int id){
        boolean a = repositorio.deleteProductoD(id);
        return new message("Eliminado del catalogo");
    }
}
