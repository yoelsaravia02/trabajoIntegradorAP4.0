package org.example.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "gato")
public class Gato extends Mascota {
    @Column(name = "pelaje")
    private String pelaje;

    public String maullar(){
        return "Miau Miau";
    }

}
