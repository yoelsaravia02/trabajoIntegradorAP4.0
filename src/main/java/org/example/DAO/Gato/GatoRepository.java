package org.example.DAO.Gato;

import org.example.Entidades.Gato;
import org.example.Persistencia.Exceptions.NonexistentEntityException;
import org.example.Persistencia.GatoJpaController;

import java.util.List;

public class GatoRepository implements GatoDAO {

    public GatoJpaController controllerGatoJpa;

    public GatoRepository() {
        this.controllerGatoJpa = new GatoJpaController();
    }
    @Override
    public Gato obtenerPorId(int id) {
        return controllerGatoJpa.findGato(id);
    }

    @Override
    public List<Gato> obtenerTodos() {
        return controllerGatoJpa.findGatoEntities();
    }

    @Override
    public void guardar(Gato gato) {
        controllerGatoJpa.create(gato);
    }

    @Override
    public void actualizar(Gato gato) {
        try {
            controllerGatoJpa.edit(gato);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {
        try {
            controllerGatoJpa.destroy(id);
        } catch (NonexistentEntityException e) {
            e.printStackTrace();
        }
    }

}