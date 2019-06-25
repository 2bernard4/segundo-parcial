package com.example.primerparcial.repositories;

import com.example.primerparcial.models.CantidadCxP;
import com.example.primerparcial.models.ComentarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CantidadCxPRepository extends JpaRepository<CantidadCxP, Integer> {
    @Modifying
    @Transactional
    @Query(value = "select c.id, p.titulo, c.owner, count(c.id) as cantidad from comentario c join publicacion p on p.id = c.publicacion_id group by c.owner;", nativeQuery = true)
    List<CantidadCxP> getCantidad();
}
