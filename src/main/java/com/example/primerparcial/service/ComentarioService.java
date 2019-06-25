package com.example.primerparcial.service;

import com.example.primerparcial.models.ComentarioDto;
import com.example.primerparcial.models.PublicacionDto;
import com.example.primerparcial.repositories.ComentarioDtoRepository;
import com.example.primerparcial.repositories.ComentarioRepository;
import com.example.primerparcial.repositories.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ComentarioService {

    @Autowired
    ComentarioDtoRepository comentarioDtoRepository;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<ComentarioDto>> methodOne() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<ComentarioDto> comentarios = comentarioDtoRepository.getComentarios();
        return CompletableFuture.completedFuture(comentarios);
    }//EXTRA
}
