package com.github.marceloasfilho.humanresources.service;

import com.github.marceloasfilho.humanresources.entity.Vaga;

import java.util.List;
import java.util.Optional;

public interface VagaService {
    Vaga cadastrarVaga(Vaga vaga);

    List<Vaga> listarVagas();

    Optional<Vaga> detalharVaga(Long id);

    void deletarVaga(Long id);
}
