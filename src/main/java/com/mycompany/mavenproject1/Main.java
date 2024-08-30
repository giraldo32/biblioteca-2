/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import java.util.Scanner;
/**
 *
 * @author Santa Teresa
 */



public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Crear algunos libros y usuarios de ejemplo
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "123456789");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "987654321");

        Usuario usuario1 = new Usuario("Juan Pérez", "001");
        Usuario usuario2 = new Usuario("María López", "002");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        // Menú interactivo
        int opcion;
        do {
            System.out.println("\nSistema de Biblioteca");
            System.out.println("1. Mostrar catálogo de libros");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Mostrar libros prestados de un usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    biblioteca.mostrarCatalogo();
                    break;
                case 2:
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbnPrestar = scanner.nextLine();
                    Libro libroPrestar = biblioteca.buscarLibroPorISBN(isbnPrestar);
                    if (libroPrestar != null) {
                        System.out.print("Ingrese la identificación del usuario: ");
                        String idUsuarioPrestar = scanner.nextLine();
                        Usuario usuarioPrestar = biblioteca.buscarUsuarioPorIdentificacion(idUsuarioPrestar);
                        if (usuarioPrestar != null) {
                            usuarioPrestar.prestarLibro(libroPrestar);
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbnDevolver = scanner.nextLine();
                    Libro libroDevolver = biblioteca.buscarLibroPorISBN(isbnDevolver);
                    if (libroDevolver != null) {
                        System.out.print("Ingrese la identificación del usuario: ");
                        String idUsuarioDevolver = scanner.nextLine();
                        Usuario usuarioDevolver = biblioteca.buscarUsuarioPorIdentificacion(idUsuarioDevolver);
                        if (usuarioDevolver != null) {
                            usuarioDevolver.devolverLibro(libroDevolver);
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la identificación del usuario: ");
                    String idUsuarioLibros = scanner.nextLine();
                    Usuario usuarioLibros = biblioteca.buscarUsuarioPorIdentificacion(idUsuarioLibros);
                    if (usuarioLibros != null) {
                        usuarioLibros.mostrarLibrosPrestados();
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
