package com.github.marceloasfilho.humanresources.service.implementation;

import com.github.marceloasfilho.humanresources.entity.Vaga;
import com.github.marceloasfilho.humanresources.repository.VagaRepository;
import com.github.marceloasfilho.humanresources.service.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VagaServiceImpl implements VagaService {
    private final VagaRepository vagaRepository;

    @Override
    public Vaga cadastrarVaga(Vaga vaga) {
        return this.vagaRepository.save(vaga);
    }

    @Override
    public List<Vaga> listarVagas() {
        return this.vagaRepository.findAll();
    }

    @Override
    public Optional<Vaga> detalharVaga(Long id) {
        return this.vagaRepository.findById(id);
    }

    @Override
    public void deletarVaga(Long id) {
        this.vagaRepository.deleteById(id);
    }
}
