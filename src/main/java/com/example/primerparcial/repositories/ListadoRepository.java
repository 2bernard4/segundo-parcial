/*package com.example.primerparcial.repositories;

import com.example.primerparcial.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ListadoRepository extends JpaRepository<Listado,Integer> {
    @Modifying
    @Transactional
    @Query(value = "* from usuario;", nativeQuery = true)
    List<Usuario> getmethodOne();

    @Modifying
    @Transactional
    @Query(value = "* from publicacion;", nativeQuery = true)
    List<Publicacion> getmethodTwo();

    @Modifying
    @Transactional
    @Query(value = "* from comentario;", nativeQuery = true)
    List<Comentario> getmethodThree();

}*///no uso esto al finale
