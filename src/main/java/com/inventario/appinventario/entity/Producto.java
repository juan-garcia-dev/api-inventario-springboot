package com.inventario.appinventario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;

	@NotNull(message = "Debes especificar 'precio'")
	@Min(value = 0, message ="El precio no puede ser negativo")
	private Double precio;

	@NotNull(message = "Debes especificar 'cantidad'")
	@Min(value = 0, message = "La cantidad no puede ser negativa")
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Producto() {

	}

	public Producto(String nombre, Double precio, Integer cantidad,Categoria categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoria=categoria;
	}
	
	public Producto(String nombre, Double precio, Integer cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
