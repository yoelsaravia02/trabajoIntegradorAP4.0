package org.example.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "turno_medico")
public class TurnoMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private long id;
    @Column(name = "fecha_turno")
    private LocalDate fechaTurno;
    @Column(name = "estado")
    private String estado;
    @Column(name = "precio")
    private int precio;

    @OneToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    private ProfesionalMedico profesionalMedico;
}
