package org.example.DAO.TurnoMedico;

import org.example.Entidades.TurnoMedico;
import org.example.Persistencia.Exceptions.NonexistentEntityException;
import org.example.Persistencia.TurnoMedicoJpaController;

import java.util.List;

public class TurnoMedicoRepository implements TurnoMedicoDAO {

    public TurnoMedicoJpaController turnoMedicoJpaController;

    public TurnoMedicoRepository() {
        this.turnoMedicoJpaController = new TurnoMedicoJpaController();
    }
    @Override
    public TurnoMedico obtenerPorId(int id) {
        return turnoMedicoJpaController.findTurnoMedico(id);
    }

    @Override
    public List<TurnoMedico> obtenerTodos() {
        return turnoMedicoJpaController.findTurnoMedicoEntities();
    }

    @Override
    public void guardar(TurnoMedico turnoMedico) {
        turnoMedicoJpaController.create(turnoMedico);
    }

    @Override
    public void actualizar(TurnoMedico turnoMedico) {
        try {
            turnoMedicoJpaController.edit(turnoMedico);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {
        try {
            turnoMedicoJpaController.destroy(id);
        } catch (NonexistentEntityException e) {
            e.printStackTrace();
        }
    }

}