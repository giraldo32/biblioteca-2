/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Santa Teresa
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String identificacion;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void prestarLibro(Libro libro) {
        if (!libro.isPrestado()) {
            libro.prestar();
            librosPrestados.add(libro);
        } else {
            System.out.println("No se puede prestar el libro, ya está prestado.");
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            libro.devolver();
            librosPrestados.remove(libro);
        } else {
            System.out.println("Este libro no está en la lista de libros prestados.");
        }
    }

    public void mostrarLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No hay libros prestados.");
        } else {
            System.out.println("Libros prestados:");
            for (Libro libro : librosPrestados) {
                System.out.println(libro);
            }
        }
    }
}
