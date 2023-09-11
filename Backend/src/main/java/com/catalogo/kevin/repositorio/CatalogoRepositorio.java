package com.catalogo.kevin.repositorio;

import com.catalogo.kevin.models.productos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogoRepositorio {
    private final JdbcTemplate sql;

    @Autowired
    public CatalogoRepositorio(JdbcTemplate sql){
        this.sql = sql;
    }

    public List<productos> GetProductos(){
        String Query = "SELECT * FROM producto";
        return sql.query(Query, BeanPropertyRowMapper.newInstance(productos.class));
    }

    public productos oneProducto(int id){
        String Query = "Select * from producto where idproducto = ?";
        return sql.queryForObject(Query, new Object[]{id}, BeanPropertyRowMapper.newInstance(productos.class));
    }

    public boolean newProductoD(productos p){
        String query = "insert into producto (nombre, cantidad) values (?, ?);";
        sql.update(query, p.getNombre(), p.getCantidad());
        return true;
    }

    public boolean putProductoD(productos p, int id){
        String query = "update producto set nombre = ?, cantidad = ? where idproducto = ?;";
        sql.update(query, p.getNombre(), p.getCantidad(), id);
        return true;
    }

    public boolean deleteProductoD(int id){
        String query = "delete from producto where idproducto = ?;";
        sql.update(query, id);
        return true;
    }
}
