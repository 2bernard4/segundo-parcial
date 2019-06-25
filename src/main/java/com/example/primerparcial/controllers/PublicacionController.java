package com.example.primerparcial.controllers;

import com.example.primerparcial.interfaces.CantidadLista;
import com.example.primerparcial.models.Comentario;
import com.example.primerparcial.models.ComentarioDto;
import com.example.primerparcial.models.Publicacion;
import com.example.primerparcial.models.PublicacionDto;
import com.example.primerparcial.repositories.ComentarioRepository;
import com.example.primerparcial.repositories.PublicacionDtoRepository;
import com.example.primerparcial.repositories.PublicacionRepository;
import com.example.primerparcial.service.ComentarioService;
import com.example.primerparcial.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RequestMapping("/publicacion")
@RestController
@EnableScheduling
public class PublicacionController {
    private static final String PERSON_NOT_FOUND = "Publicacion id not found: %s";

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    ComentarioService comentarioService;

    @Autowired
    PublicacionService publicacionService;


    // ------------------- add a publicacion-----------------------------------------
    @PostMapping("")
    public void addPublicacion(@RequestBody final Publicacion p) {//averiguar q hace esto
        publicacionRepository.save(p);
    }

    // ------------------- add a comentario to publicacion-----------------------------------------
    @PostMapping("/{idComentario}/{idPublicacion}")
    public void addComentario(@PathVariable final Integer idPublicacion, @PathVariable final Integer idComentario){
        Comentario p = comentarioRepository.findById(idPublicacion)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        Publicacion publicacion = getById(idPublicacion);
        p.setPublicacion(publicacion);
        publicacion.getComentarios().add(p);
        comentarioRepository.save(p);
        publicacionRepository.save(publicacion);
    }

    // ------------------- get a publicacion-----------------------------------------

    @GetMapping("")
    public List<Publicacion> getAll() {
        return publicacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publicacion getById(@PathVariable final Integer id){
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id))); //ACA es mejor usar el @responsebody?
    }

    // ------------------- Scheduled publicacion-----------------------------------------


    /*@Scheduled(cron = ("${nValue}")) // no se pudo remplazar por long pa que ande
    private void deleteComentarios(){
        //voteRepository.deleteAll();
        comentarioRepository.deleteComentarios();
    }*/

    @GetMapping("/async")
    public ResponseEntity<?> getAsync() {
        CompletableFuture<List<PublicacionDto>> resultMethodOne = publicacionService.methodOne();
        /*List merged = new ArrayList(resultMethodOne.join());
        merged.addAll(resultMethodtwo.join());*/
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMethodOne.join());
    }



}
