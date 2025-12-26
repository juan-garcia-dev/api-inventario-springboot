package com.inventario.appinventario;

import com.inventario.appinventario.entity.Categoria;
import com.inventario.appinventario.entity.Producto;
import com.inventario.appinventario.repository.CategoriaRepository;
import com.inventario.appinventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private final CategoriaRepository categoriaRepository;


    Application(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


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
