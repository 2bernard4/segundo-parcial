package com.example.primerparcial.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CantidadCxP {
    @Id
    private int id;
    private String titulo;
    private String owner;
    private Integer cantidad;
}
