package com.github.marceloasfilho.humanresources.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CandidatoDTO {
    @NotEmpty
    private String nome;
    private String rg;
    @NotEmpty
    private String email;
    private VagaDTO vaga;
}
