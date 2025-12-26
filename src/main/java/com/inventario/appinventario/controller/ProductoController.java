package com.inventario.appinventario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.inventario.appinventario.entity.Producto;
import com.inventario.appinventario.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductoController {

	private final ProductoService servicio;

	public ProductoController(ProductoService servicio) {
		this.servicio = servicio;
	}

	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> obtenerTodos() {
		List<Producto> lista = servicio.getProductos();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerById(@PathVariable Long id) {
		Producto producto = servicio.getById(id);
		return ResponseEntity.ok(producto);
	}

	@PostMapping("/productos")
	public ResponseEntity<Producto> addProducto(@Valid @RequestBody Producto producto) {
		Producto nuevoProducto = servicio.guardar(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
	}

	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> putMethodName(@PathVariable Long id, @Valid @RequestBody Producto producto) {
		Producto productoActualizado = servicio.modificarProducto(id, producto);
		return ResponseEntity.ok(productoActualizado);
	}

	@DeleteMapping("/productos/{id}")
	public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
		servicio.removeProducto(id);
		return ResponseEntity.ok("El producto con ID " + id + " ha sido eliminado.");
	}

	@GetMapping("/productos/precio")
	public ResponseEntity<List<Producto>> buscarPorRangoPrecio(@RequestParam Double min, @RequestParam Double max) {
		List<Producto> lista = servicio.buscarPorRangoPrecio(min, max);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/productos/categoria")
	public ResponseEntity<List<Producto>> buscarPorCategoria(@RequestParam Long id) {
		List<Producto> lista = servicio.buscarPorCategoria(id);
		return ResponseEntity.ok(lista);
	}

	@PutMapping("/productos/{idProducto}/asignar-categoria/{idCategoria}")
	public ResponseEntity<Producto> asignarCategoria(@PathVariable Long idProducto, @PathVariable Long idCategoria) {

		Producto productoActualizado = servicio.asignarCategoria(idProducto, idCategoria);
		return ResponseEntity.ok(productoActualizado);
	}

}
