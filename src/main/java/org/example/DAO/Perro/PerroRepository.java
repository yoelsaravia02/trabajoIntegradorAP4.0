package org.example.DAO.Perro;

import org.example.Entidades.Perro;
import org.example.Persistencia.Exceptions.NonexistentEntityException;
import org.example.Persistencia.PerroJpaController;

import java.util.List;

public class PerroRepository implements PerroDAO{

    public PerroJpaController controllerPerroJpa;

    public PerroRepository() {
        this.controllerPerroJpa = new PerroJpaController();
    }
    @Override
    public Perro obtenerPorId(int id) {
        return controllerPerroJpa.findPerro(id);
    }

    @Override
    public List<Perro> obtenerTodos() {
        return controllerPerroJpa.findPerroEntities();
    }

    @Override
    public void guardar(Perro perro) {
        controllerPerroJpa.create(perro);
    }

    @Override
    public void actualizar(Perro perro) {
        try {
            controllerPerroJpa.edit(perro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {
        try {
            controllerPerroJpa.destroy(id);
        } catch (NonexistentEntityException e) {
            e.printStackTrace();
        }
    }

}
