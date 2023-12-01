package org.example.DAO.Gato;

import org.example.Entidades.Gato;
import org.example.Entidades.Perro;

import java.util.List;

public interface GatoDAO {
    Gato obtenerPorId(int id);
    List<Gato> obtenerTodos();
    void guardar(Gato gato);
    void actualizar(Gato gato);
    void eliminar(int id);
}
