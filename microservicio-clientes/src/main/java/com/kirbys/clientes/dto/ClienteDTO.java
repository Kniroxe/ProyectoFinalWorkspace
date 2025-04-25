package com.kirbys.clientes.dto;

import java.util.List;

import com.kirbys.commons.models.entities.Pedido;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar en blanco")
    private String apellido;

    @NotBlank(message = "El email no puede estar en blanco")
    @Email(message = "El email debe tener un formato válido (ejemplo@dominio.com)")
    private String email;

    @NotNull(message = "El teléfono no puede ser nulo")
    @Min(value = 1000000000L, message = "Debe tener exactamente 10 dígitos")
    @Max(value = 9999999999L, message = "Debe tener exactamente 10 dígitos")
    //@Digits(integer = 10, fraction = 0, message = "El teléfono debe tener exactamente 10 dígitos")
    private Long telefono;
    //cambiar a string??

    @Size(max = 100, message = "La dirección no debe tener más de 100 caracteres")
    private String direccion;

	List<Pedido> pedidos;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}