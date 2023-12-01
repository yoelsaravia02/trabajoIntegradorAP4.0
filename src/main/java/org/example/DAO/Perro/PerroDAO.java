package org.example.DAO.Perro;

import org.example.Entidades.Perro;

import java.util.List;

public interface PerroDAO {
    Perro obtenerPorId(int id);
    List<Perro> obtenerTodos();
    void guardar(Perro perro);
    void actualizar(Perro perro);
    void eliminar(int id);
}
