package com.github.marceloasfilho.humanresources.controller;

import com.github.marceloasfilho.humanresources.dto.VagaDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/vagas")
public interface VagaControllerV1 {
    @PostMapping("/cadastrar")
    ResponseEntity<VagaDTO> cadastrarVaga(@Valid @RequestBody VagaDTO vagaDTO);

    @GetMapping("/listar")
    ResponseEntity<List<VagaDTO>> listarVagas();

    @GetMapping("/detalhar/{id}")
    ResponseEntity<VagaDTO> detalharVaga(@PathVariable("id") Long id);

    @DeleteMapping("/deletar/{id}")
    ResponseEntity<?> deletarVaga(@PathVariable("id") Long id);
}
