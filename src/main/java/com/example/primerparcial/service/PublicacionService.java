package com.example.primerparcial.service;

import com.example.primerparcial.models.Publicacion;
import com.example.primerparcial.models.PublicacionDto;
import com.example.primerparcial.repositories.PublicacionDtoRepository;
import com.example.primerparcial.repositories.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PublicacionService {
    @Autowired
    PublicacionDtoRepository publicacionDtoRepository;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<PublicacionDto>> methodOne() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<PublicacionDto> publicaciones = publicacionDtoRepository.getPublicaciones();
        return CompletableFuture.completedFuture(publicaciones);
    }//EXTRA
}
