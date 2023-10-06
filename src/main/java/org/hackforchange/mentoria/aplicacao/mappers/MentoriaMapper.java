package org.hackforchange.mentoria.aplicacao.mappers;

import org.hackforchange.mentoria.aplicacao.dtos.MentoriaDTO;
import org.hackforchange.mentoria.dominio.Mentoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface MentoriaMapper {
    MentoriaDTO mentoriaToMentoriaDTO(Mentoria mentoria);

    @InheritInverseConfiguration
    Mentoria mentoriaDTOToMentoria(MentoriaDTO mentoriaDTO);
}

