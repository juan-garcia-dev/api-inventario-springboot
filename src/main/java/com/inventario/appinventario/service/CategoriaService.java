package com.inventario.appinventario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.appinventario.entity.Categoria;
import com.inventario.appinventario.repository.CategoriaRepository;

@Service
public class CategoriaService {

	CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository repositorio) {
		this.categoriaRepository = repositorio;
	}

	public Categoria guardarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Categoria modifyCategoria(Long id, Categoria categoria) {
		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}
	
	public void eliminarCategoria(Long id) {

		categoriaRepository.deleteById(id);
	}
	
	

}
