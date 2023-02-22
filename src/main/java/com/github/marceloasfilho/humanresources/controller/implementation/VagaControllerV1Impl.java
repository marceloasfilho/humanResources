package com.github.marceloasfilho.humanresources.controller.implementation;

import com.github.marceloasfilho.humanresources.controller.VagaControllerV1;
import com.github.marceloasfilho.humanresources.dto.VagaDTO;
import com.github.marceloasfilho.humanresources.entity.Vaga;
import com.github.marceloasfilho.humanresources.mapper.VagaMapper;
import com.github.marceloasfilho.humanresources.service.VagaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class VagaControllerV1Impl implements VagaControllerV1 {
    private final VagaService vagaService;
    private final VagaMapper vagaMapper;

    @Override
    public ResponseEntity<VagaDTO> cadastrarVaga(VagaDTO vagaDTO) {
        Vaga vaga = this.vagaMapper.INSTANCE.vagaDTOtoEntity(vagaDTO);
        this.vagaService.cadastrarVaga(vaga);
        log.info("..: Vaga cadastrada com sucesso! :..");
        return new ResponseEntity<>(vagaDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<VagaDTO>> listarVagas() {
        List<Vaga> vagas = this.vagaService.listarVagas();
        log.info("..: Listagem das vagas realizadas com sucesso! {} :..", vagas);
        List<VagaDTO> listagem = vagas.stream().map(this.vagaMapper.INSTANCE::vagaEntityToDTO).toList();
        log.info("..: Listagem das vagas convertidas para DTO com sucesso! {} :..", listagem);
        return new ResponseEntity<>(listagem, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VagaDTO> detalharVaga(Long id) {
        Optional<Vaga> vagaPorId = this.vagaService.detalharVaga(id);

        if (vagaPorId.isEmpty()) {
            log.warn("..: Vaga não encontrada com id: {} :..", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("..: Vaga encontrada com sucesso! :..");

        VagaDTO vagaDTO = this.vagaMapper.INSTANCE.vagaEntityToDTO(vagaPorId.get());
        log.info("..: Vaga convertida para DTO com sucesso! {} :..", vagaDTO);
        return new ResponseEntity<>(vagaDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deletarVaga(Long id) {
        this.vagaService.deletarVaga(id);
        log.info("..: Vaga de id {} deletada com sucesso! :..", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
