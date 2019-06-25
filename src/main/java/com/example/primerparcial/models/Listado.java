package com.example.primerparcial.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listado {

    private List<Usuario> usuarios;

    private List<Publicacion> publicacions;

    private List<Comentario> comentarios;
}
