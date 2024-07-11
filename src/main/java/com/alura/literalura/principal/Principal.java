package com.alura.literalura.principal;

import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private Scanner in = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private final String URL_BASE = "gutendex.com/books?";

    public void mostrarMenu() {

        int opcion = 0;

        menu();
        opcion = in.nextInt();
        in.nextLine();

        while (opcion != 6) {

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del libro que desea busca:");
                    String nombreLibro = in.nextLine();

                    String json = consumoApi.obtenerDatos(URL_BASE + "search=" + nombreLibro.replace(" ", "%20"));
                    DatosLibro datosLibro = conversor.obtenerDatos(json, DatosLibro.class);
                    System.out.println(datosLibro);

                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Opción no válida. Ingrese una opción válida");
            }


            menu();
            opcion = in.nextInt();
            in.nextLine();
        }

    }

    public static void menu() {
        System.out.println("********************************************************************");
        System.out.println("Sea bienvenido/a a LiterAlura =]\n");

        System.out.println("Elija una opción válida:\n");
        System.out.println("""
                1) Buscar libro por título
                2) Listar libros registrados
                3) Listar autores registrados
                4) Listar autores vivos en un determinado año
                5) Listar libros por idioma
                6) Salir""");
        System.out.println("********************************************************************");
    }
}
