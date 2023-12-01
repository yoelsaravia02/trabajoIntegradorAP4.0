package org.example;

import org.example.DAO.Perro.PerroDAO;
import org.example.DAO.Perro.PerroRepository;
import org.example.Entidades.Perro;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro("grande");
        PerroDAO pdao = new PerroRepository();
        pdao.guardar(perro1);
    }
}