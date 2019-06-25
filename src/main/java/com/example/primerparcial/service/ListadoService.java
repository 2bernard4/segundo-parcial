package com.example.primerparcial.service;

import com.example.primerparcial.models.Comentario;
import com.example.primerparcial.models.ComentarioDto;
import com.example.primerparcial.models.Publicacion;
import com.example.primerparcial.models.Usuario;
import com.example.primerparcial.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
@Service
public class ListadoService {
    /*@Autowired
    ListadoRepository listadoRepository;*/

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    ComentarioRepository comentarioRepository;



    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> methodOne() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Usuario> usuarios = usuarioRepository.findAll();
        return CompletableFuture.completedFuture(usuarios);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> methodTwo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Publicacion> publicaciones = publicacionRepository.findAll();
        return CompletableFuture.completedFuture(publicaciones);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> methodThree() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Comentario> comentarios = comentarioRepository.findAll();
        return CompletableFuture.completedFuture(comentarios);
    }


    /*@Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> methodOne() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Usuario> usuarios = listadoRepository.getmethodOne();
        return CompletableFuture.completedFuture(usuarios);
    }*/

    /*@Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> methodTwo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Publicacion> publicaciones = listadoRepository.getmethodTwo();
        return CompletableFuture.completedFuture(publicaciones);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> methodThree() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Comentario> comentarios = listadoRepository.getmethodThree();
        return CompletableFuture.completedFuture(comentarios);
    }*/
}
