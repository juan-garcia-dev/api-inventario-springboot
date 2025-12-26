package com.inventario.appinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.appinventario.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
