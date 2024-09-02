/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        // Crear algunos libros y usuarios de ejemplo
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "123456789");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "987654321");

        Usuario usuario1 = new Usuario("Juan Pérez", "001");
        Usuario usuario2 = new Usuario("María López", "002");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        // Configurar la interfaz gráfica
        JFrame frame = new JFrame("Sistema de Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Ajustar tamaño para acomodar botones de menú

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Usuario ID:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel isbnLabel = new JLabel("ISBN Libro:");
        isbnLabel.setBounds(10, 50, 80, 25);
        panel.add(isbnLabel);

        JTextField isbnText = new JTextField(20);
        isbnText.setBounds(100, 50, 165, 25);
        panel.add(isbnText);

        JButton prestarButton = new JButton("Prestar Libro");
        prestarButton.setBounds(10, 80, 150, 25);
        panel.add(prestarButton);

        JButton devolverButton = new JButton("Devolver Libro");
        devolverButton.setBounds(170, 80, 150, 25);
        panel.add(devolverButton);

        JButton mostrarCatalogoButton = new JButton("Mostrar Catálogo");
        mostrarCatalogoButton.setBounds(330, 80, 150, 25);
        panel.add(mostrarCatalogoButton);

        JButton mostrarLibrosPrestadosButton = new JButton("Mostrar Libros Prestados");
        mostrarLibrosPrestadosButton.setBounds(10, 110, 200, 25);
        panel.add(mostrarLibrosPrestadosButton);

        JButton salirButton = new JButton("Salir");
        salirButton.setBounds(220, 110, 150, 25);
        panel.add(salirButton);

        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(10, 140, 560, 200);
        displayArea.setEditable(false);
        panel.add(displayArea);

        // Acciones de botones
        prestarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userText.getText();
                String isbn = isbnText.getText();
                Usuario usuario = biblioteca.buscarUsuarioPorIdentificacion(userId);
                Libro libro = biblioteca.buscarLibroPorISBN(isbn);

                if (usuario != null && libro != null) {
                    usuario.prestarLibro(libro);
                    displayArea.setText("Libro prestado: " + libro.getTitulo());
                } else {
                    displayArea.setText("Usuario o libro no encontrado.");
                }
            }
        });

        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userText.getText();
                String isbn = isbnText.getText();
                Usuario usuario = biblioteca.buscarUsuarioPorIdentificacion(userId);
                Libro libro = biblioteca.buscarLibroPorISBN(isbn);

                if (usuario != null && libro != null) {
                    usuario.devolverLibro(libro);
                    displayArea.setText("Libro devuelto: " + libro.getTitulo());
                } else {
                    displayArea.setText("Usuario o libro no encontrado.");
                }
            }
        });

        mostrarCatalogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder catalogo = new StringBuilder("Catálogo de Libros:\n");
                for (Libro libro : biblioteca.getCatalogo()) {
                    catalogo.append(libro.toString()).append("\n");
                }
                displayArea.setText(catalogo.toString());
            }
        });

        mostrarLibrosPrestadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userText.getText();
                Usuario usuario = biblioteca.buscarUsuarioPorIdentificacion(userId);

                if (usuario != null) {
                    StringBuilder librosPrestados = new StringBuilder("Libros Prestados por " + usuario.getNombre() + ":\n");
                    for (Libro libro : usuario.getLibrosPrestados()) {
                        librosPrestados.append(libro.toString()).append("\n");
                    }
                    displayArea.setText(librosPrestados.toString());
                } else {
                    displayArea.setText("Usuario no encontrado.");
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });
    }
}
