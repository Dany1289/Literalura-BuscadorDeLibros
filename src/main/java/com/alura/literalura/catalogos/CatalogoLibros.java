package com.alura.literalura.catalogos;

import com.alura.literalura.services.GutendexService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CatalogoLibros {

    private final GutendexService gutendexService; // Inyección de dependencia
    private final Scanner scanner = new Scanner(System.in);

    public CatalogoLibros(GutendexService gutendexService) {
        this.gutendexService = gutendexService;
    }

    public void iniciar() {
        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());

                switch (opcion) {
                    case 1 -> buscarLibros();
                    case 2 -> filtrarPorIdioma();
                    case 3 -> listarPrimerosLibros();
                    case 4 -> mostrarDetallesLibro();
                    case 5 -> System.out.println(
                            "Gracias por usar nuestro Catálogo de Libros. "
                                    + "***"
                                    + "Challenge LiterAlura - Por: Victor Ortega"
                                    + "***");
                    default -> System.out.println("Opción no válida, selecciona un digito del 1 al 5. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("""
                
                ********************************
                ****** Catálogo de Libros ******
                ********************************
                
                1. Buscar libros por palabra clave
                2. Filtrar libros por idioma
                3. Listar los primeros N libros
                4. Mostrar detalles de un libro
                5. Salir
                """);

        System.out.print("Seleccione una opción: ");
    }

    private void buscarLibros() {
        System.out.print("Ingrese la palabra clave: ");
        String keyword = scanner.nextLine().trim();
        System.out.println(gutendexService.getBooks(keyword, null));
    }

    private void filtrarPorIdioma() {
        System.out.print("Ingrese el idioma (ej. 'en' para inglés): ");
        String idioma = scanner.nextLine().trim();
        System.out.println(gutendexService.getBooks(null, idioma));
    }

    private void listarPrimerosLibros() {
        System.out.print("¿Cuántos libros desea listar?: ");
        try {
            int cantidad = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(gutendexService.listFirstBooks(cantidad));
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        }
    }

    private void mostrarDetallesLibro() {
        System.out.print("Ingrese el ID del libro: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            String detalles = gutendexService.getBookDetails(id);

            if (detalles != null && !detalles.isBlank()) {
                System.out.println("Detalles del libro:");
                System.out.println(detalles);
            } else {
                System.out.println("No se encontraron detalles para el libro con ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un ID válido.");
        }
    }

}
