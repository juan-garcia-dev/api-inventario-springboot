package com.inventario.appinventario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.appinventario.entity.Categoria;
import com.inventario.appinventario.entity.Producto;
import com.inventario.appinventario.exception.ProductoNoEncontradoException;
import com.inventario.appinventario.repository.ProductoRepository;

@Service
public class ProductoService {

	private ProductoRepository productoRepository;

	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public Producto guardar(Producto producto) {
		return productoRepository.save(producto);
	}

	public List<Producto> getProductos() {
		return productoRepository.findAll();
	}

	public Producto getById(Long id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con id " + id));
	}

	public void removeProducto(Long id) {
		productoRepository.deleteById(id);
	}

	public Producto modificarProducto(Long id, Producto producto) {
		producto.setId(id);
		return productoRepository.save(producto);
	}

	public List<Producto> buscarPorRangoPrecio(Double min, Double max) {
		return productoRepository.findByPrecioBetween(min, max);
	}

	public List<Producto> buscarPorCategoria(Long id) {
		return productoRepository.findByCategoria(id);

	}

	public Producto asignarCategoria(Long idProducto, Long idCategoria) {

		Producto producto = productoRepository.findById(idProducto)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));
		Categoria categoria = new Categoria();
		categoria.setId(idCategoria);
		producto.setCategoria(categoria);
		return productoRepository.save(producto);
	}

}
