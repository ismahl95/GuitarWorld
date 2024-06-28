package com.ihl95.GuitarWorld;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ihl95.GuitarWorld.model.Producto;
import com.ihl95.GuitarWorld.model.Usuario;
import com.ihl95.GuitarWorld.repository.ProductoRepository;
import com.ihl95.GuitarWorld.repository.UsuarioRepository;
import com.ihl95.GuitarWorld.services.ProductoService;
import com.ihl95.GuitarWorld.services.UsuarioService;

@SpringBootApplication
public class GuitarWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuitarWorldApplication.class, args);
		System.out.println("Hola mundo");
	}

/**
 * El método `initData` inicializa y guarda un nuevo objeto `Usuario` y múltiples objetos `Producto` en
 * la base de datos.
 * 
 * @param userRepository `userRepository` es un repositorio que se utiliza para acceder y gestionar
 * entidades de tipo `Usuario` en la base de datos. En este caso, se utiliza para guardar un nuevo
 * objeto `Usuario` en la base de datos.
 * @param productoRepository `productoRepository` es una instancia de la interfaz `ProductoRepository`,
 * que normalmente se usa para interactuar con la tabla/entidad de la base de datos que almacena
 * información sobre productos (en este caso, guitarras). El `ProductoRepository` tendría métodos para
 * guardar, actualizar, eliminar y consultar entidades de productos en la base de datos.
 * @return Se devuelve un bean CommandLineRunner.
 */
	@Bean
	public CommandLineRunner initData(UsuarioService userService, ProductoService productoService) {

		return args -> {

			Usuario user1 = new Usuario();
			user1.setNombre("Julio");
			user1.setApellidos("Cesar");
			user1.setEmail("caesar.julius@example.com");
			user1.setPassword("rubicon");

			Usuario user2 = new Usuario();
			user2.setNombre("Gneo");
			user2.setApellidos("Pompeyo");
			user2.setEmail("pompeyo.gneo@example.com");
			user2.setPassword("pompaelo");

			List<Usuario> usuarios = Arrays.asList(user1, user2);
			
			usuarios.forEach(userService::registrar);
			
			List<Producto> productos =	Arrays.asList(
					new Producto("Gibson Les Paul", 1000, 
						"https://images.musicstore.de/images/0960/gibson-les-paul-modern-figured-cobalt-blue_1_GIT0060762-000.jpg", user1),
					new Producto("Ibanez 5th Generation", 500, 
						"https://fast-images.static-thomann.de/pics/bdb/_53/533407/19013198_800.jpg", user1),
					new Producto("Fender Telecaster", 500,
						"https://fast-images.static-thomann.de/pics/bdb/_54/548562/18405137_800.jpg", user2),
					new Producto("ESP LTD EC-1000", 500,
						"https://fast-images.static-thomann.de/pics/bdb/_19/192156/12195607_800.jpg", user2)
				);

				productos.forEach(productoService::insertar);

		};
	}

}
