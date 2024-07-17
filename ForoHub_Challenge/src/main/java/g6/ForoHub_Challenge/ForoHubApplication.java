package g6.ForoHub_Challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForoHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoHubApplication.class, args);


	}

	public void menu() {
		int option;
		String menu =
		"1. Crear Cuenta\n" +
		"2. Iniciar Sesion\n" +
		"3. Salir\n" +
		"Elija una Opcion: ";

		System.out.println(menu);
	}

}
