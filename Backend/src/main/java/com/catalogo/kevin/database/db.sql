CREATE DATABASE catalogo;

USE catalogo;

CREATE TABLE producto(
    idproducto int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(225),
    cantidad int
);