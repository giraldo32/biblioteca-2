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

public class Biblioteca {
    private List<Libro> catalogo;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Libro buscarLibroPorISBN(String ISBN) {
        for (Libro libro : catalogo) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorIdentificacion(String identificacion) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificacion().equals(identificacion)) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("Catálogo de libros:");
            for (Libro libro : catalogo) {
                System.out.println(libro);
            }
        }
    }
}

