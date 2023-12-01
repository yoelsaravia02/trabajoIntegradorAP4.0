package org.example.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perro")
public class Perro extends Mascota {

    @Column(name = "tamanio")
    private String tamanio;

    public String ladrar(){
        return "Guau Guau";
    }

}
