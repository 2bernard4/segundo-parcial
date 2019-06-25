package com.example.primerparcial.service;

import com.example.primerparcial.models.PublicacionDto;
import com.example.primerparcial.models.UsuarioDto;
import com.example.primerparcial.repositories.PublicacionDtoRepository;
import com.example.primerparcial.repositories.UsuarioDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDtoRepository usuarioDtoRepository;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<UsuarioDto>> methodOne() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<UsuarioDto> usuarios = usuarioDtoRepository.getUsuarios();
        return CompletableFuture.completedFuture(usuarios);
    }//EXTRA
}
