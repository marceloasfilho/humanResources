package com.github.marceloasfilho.humanresources.mapper;

import com.github.marceloasfilho.humanresources.dto.VagaDTO;
import com.github.marceloasfilho.humanresources.entity.Vaga;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VagaMapper {
    VagaMapper INSTANCE = Mappers.getMapper(VagaMapper.class);

    Vaga vagaDTOtoEntity(VagaDTO vagaDTO);

    VagaDTO vagaEntityToDTO(Vaga vaga);
}
