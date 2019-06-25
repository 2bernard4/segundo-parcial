package com.example.primerparcial.repositories;

import com.example.primerparcial.models.PublicacionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PublicacionDtoRepository extends JpaRepository<PublicacionDto, Integer> {
    @Modifying
    @Transactional
    @Query(value = "select publicacion.titulo, publicacion.descripcion, publicacion.liked from publicacion;", nativeQuery = true)
    List<PublicacionDto> getPublicaciones();//EXTRA
}
