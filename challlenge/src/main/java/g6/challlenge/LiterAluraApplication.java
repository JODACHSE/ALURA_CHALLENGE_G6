package g6.challlenge;

import java.util.Scanner;

import g6.challlenge.service.GutendexService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LiterAluraApplication {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LiterAluraApplication.class, args);
		GutendexService gutendexService = context.getBean(GutendexService.class);

		boolean running = true;
		while (running) {
			clearConsole(2);
			int option = showPrincipalMenu();
			switch (option) {
				case 1 -> searchBookBy(gutendexService);
				// case 2 -> top10Books();
				// case 3 -> showHistory();
				case 0 -> {
					thanksAndBye();
					running = false;
				}
				default -> System.out.println("Opción no valida");
			}
		}
	}

	// Methods
	public static int showPrincipalMenu() {
		int option;

		String menu =
						"------------------------ LiterAlura ------------------------\n" +
						"= 1. Buscar un libro.                                      =\n" +
						"= 2. Top 10 libros mas leidos actualmente.                 =\n" +
						"= 3. Historial de libros buscados.                         =\n" +
						"= 0. Salir.                                                =\n\n" +
						"\tDigite una de las opciones: ";
		System.out.println(menu);

		option = scanner.nextInt();
		return option;
	}

	public static void searchBookBy(GutendexService gutendexService) {
		int option;

		String menu =
						"----------------------- Buscar Libro -----------------------\n" +
						"= 1. Por autor.                                            =\n" +
						"= 2. Por nombre.                                           =\n" +
						"= 0. Regresar.                                             =\n\n" +
						"Digite una de las opciones: ";
		System.out.println(menu);

		option = scanner.nextInt();
		switch (option) {
			case 1 -> byAuthor(gutendexService);
			case 2 -> byTitle(gutendexService);
			default -> System.out.println("Opción no valida");
		}
	}

	public static void byAuthor(GutendexService gutendexService) {
		scanner.nextLine(); // Consume newline left-over
		System.out.println("Ingrese el nombre del autor: ");
		String author = scanner.nextLine();
		String response = gutendexService.searchBooksByAuthor(author);
		System.out.println("Resultados de la búsqueda por autor: \n" + response);
	}

	public static void byTitle(GutendexService gutendexService) {
		scanner.nextLine(); // Consume newline left-over
		System.out.println("Ingrese el título del libro: ");
		String title = scanner.nextLine();
		String response = gutendexService.searchBooksByTitle(title);
		System.out.println("Resultados de la búsqueda por título: \n" + response);
	}

	public static void clearConsole(int seconds) {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				// Sistema operativo Windows
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				// Sistemas operativos Linux o Mac
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void regresiveCount(int seconds) {
		System.out.println("Tiempo restante para visualizar información: ");
		for (int i = seconds; i >= 1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void thanksAndBye() {
		String greetings = "Gracias por haber usado este programa. ¡Hasta pronto!\n" +
				"Elaborado por JODACHSE con ayuda de OpenAI y BlackBox.";
		System.out.println(greetings);
		regresiveCount(3);
		clearConsole(1);
	}
}
