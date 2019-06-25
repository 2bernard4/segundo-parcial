package com.example.primerparcial.controllers;

import com.example.primerparcial.models.*;
import com.example.primerparcial.repositories.UsuarioDtoRepository;
import com.example.primerparcial.service.ComentarioService;
import com.example.primerparcial.service.ListadoService;
import com.example.primerparcial.service.PublicacionService;
import com.example.primerparcial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/listado")
@RestController
@EnableScheduling
public class ListadoController {
    @Autowired
    ComentarioService comentarioService;

    @Autowired
    PublicacionService publicacionService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ListadoService listadoService;

    @GetMapping("/allContent")//EXTRA
    public ResponseEntity<?> getAsync() {
        CompletableFuture<List<PublicacionDto>> resultMethodOne = publicacionService.methodOne();
        CompletableFuture<List<ComentarioDto>> resultMethodtwo = comentarioService.methodOne();
        CompletableFuture<List<UsuarioDto>> resultMethodThree = usuarioService.methodOne();
        /*List merged = new ArrayList(resultMethodOne.join());
        merged.addAll(resultMethodtwo.join());*/
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Publicaciones: " + resultMethodOne.join() + " Comentarios: " + resultMethodtwo.join() + " Usuarios:" + resultMethodThree.join());
    }

    @GetMapping("/allContentV2")//La correcta
    public ResponseEntity<?> getAsync2() {
        CompletableFuture<List<Usuario>> resultMethodOne = listadoService.methodOne();
        CompletableFuture<List<Publicacion>> resultMethodtwo = listadoService.methodTwo();
        CompletableFuture<List<Comentario>> resultMethodThree = listadoService.methodThree();

        /*Listado listado = new Listado();
        listado.getUsuarios().addAll(resultMethodOne.join());
        listado.getPublicacions().addAll(resultMethodtwo.join());
        listado.getComentarios().addAll(resultMethodThree.join());*/
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMethodOne.join() + " " + resultMethodtwo.join() + " " + resultMethodThree.join());
    }
}
