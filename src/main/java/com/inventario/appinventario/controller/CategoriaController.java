package com.inventario.appinventario.controller;

import org.springframework.web.bind.annotation.RestController;

import com.inventario.appinventario.entity.Categoria;
import com.inventario.appinventario.repository.CategoriaRepository;
import com.inventario.appinventario.service.CategoriaService;
import com.inventario.appinventario.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CategoriaController {

	private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping("/categorias")
	public Categoria guardarCategoria(@RequestBody Categoria categoria) {
		return categoriaService.guardarCategoria(categoria);
	}

	@GetMapping("/categorias")
	public List<Categoria> getCategorias() {
		return categoriaService.getCategorias();
	}

	@PutMapping("/categorias/{id}")
	public Categoria modifyCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
		return categoriaService.modifyCategoria(id, categoria);
	}

	@DeleteMapping("/categorias/{id}")
	public void eliminarCategoria(@PathVariable Long id) {
		categoriaService.eliminarCategoria(id);
	}

}
