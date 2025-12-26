package com.inventario.appinventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner demo(ProductoRepository repositorio,CategoriaRepository repositorioCategoria) {
//		return args -> {
//
//			Producto p1 = new Producto("Teclado Mecánico", 75.00, 10);
//			Producto p2 = new Producto("Monitor 24 pulgadas", 150.50, 5);
//			
//			Categoria c1=new Categoria("Gaming");
//			repositorio.save(p1);
//			repositorio.save(p2);
//			repositorioCategoria.save(c1);
//
//		};
//
//	}

}
