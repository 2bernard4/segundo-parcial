package com.example.primerparcial.repositories;

import com.example.primerparcial.interfaces.CantidadLista;
import com.example.primerparcial.models.Comentario;
import com.example.primerparcial.models.ComentarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Comentario where (timestampdiff(minute,Fecha , now())) > 5;", nativeQuery = true) //en 5 minutos se borra
    void deleteComentarios();

    @Modifying
    @Transactional
    @Query(value = "select publicacion.titulo, comentario.owner, count(comentario.id) as cantidad from comentario join publicacion on publicacion.id = comentario.publicacion_id group by comentario.owner;", nativeQuery = true)
    List<CantidadLista> getCantidad();
}
