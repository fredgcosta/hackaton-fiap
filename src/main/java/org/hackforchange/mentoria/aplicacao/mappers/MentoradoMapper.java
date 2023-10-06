package org.hackforchange.mentoria.aplicacao.mappers;

import org.hackforchange.mentoria.aplicacao.dtos.MentoradoDTO;
import org.hackforchange.mentoria.dominio.Mentorado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface MentoradoMapper {
    MentoradoDTO mentoradoToMentoradoDTO(Mentorado mentorado);

    @InheritInverseConfiguration
    Mentorado mentoradoDTOToMentorado(MentoradoDTO mentoradoDTO);
}
