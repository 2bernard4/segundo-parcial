package com.example.primerparcial.repositories;

import com.example.primerparcial.models.ComentarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ComentarioDtoRepository extends JpaRepository<ComentarioDto, Integer> {
    @Modifying
    @Transactional
    @Query(value = "select comentario.id, comentario.descripcion, comentario.owner from comentario;", nativeQuery = true)
    List<ComentarioDto> getComentarios();//EXTRA
}
