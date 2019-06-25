package com.example.primerparcial.repositories;

import com.example.primerparcial.models.Publicacion;
import com.example.primerparcial.models.PublicacionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion,Integer> {
}
