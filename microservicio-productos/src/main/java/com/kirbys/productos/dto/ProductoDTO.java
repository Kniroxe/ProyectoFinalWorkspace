package com.kirbys.productos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductoDTO {


    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar en blanco")
    private String descripcion;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private Long precio;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private Long stock;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Long getPrecio() {
        return precio;
    }


    public void setPrecio(Long precio) {
        this.precio = precio;
    }


    public Long getStock() {
        return stock;
    }


    public void setStock(Long stock) {
        this.stock = stock;
    }




}