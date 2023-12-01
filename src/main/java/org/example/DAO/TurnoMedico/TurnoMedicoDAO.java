package org.example.DAO.TurnoMedico;


import org.example.Entidades.TurnoMedico;

import java.util.List;

public interface TurnoMedicoDAO {
    TurnoMedico obtenerPorId(int id);
    List<TurnoMedico> obtenerTodos();
    void guardar(TurnoMedico turnoMedico);
    void actualizar(TurnoMedico turnoMedico);
    void eliminar(int id);
}
