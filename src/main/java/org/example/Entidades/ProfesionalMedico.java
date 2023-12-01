package org.example.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profesional_medico")
public class ProfesionalMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesional")
    private long id;
    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @OneToMany(mappedBy = "profesionalMedico")
    private List<TurnoMedico> turnoMedico;
}
