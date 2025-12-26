package com.inventario.appinventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.appinventario.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	
	List<Producto> findByPrecioBetween(Double min,Double max);
	
	List<Producto> findByCategoriaId(Long idCategoria);
	
}
