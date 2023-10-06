package org.hackforchange.mentoria.aplicacao.mappers;

import org.hackforchange.mentoria.aplicacao.dtos.MentorDTO;
import org.hackforchange.mentoria.dominio.Mentor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface MentorMapper {
    MentorDTO mentorToMentorDTO(Mentor mentor);

    @InheritInverseConfiguration
    Mentor mentorDTOToMentor(MentorDTO mentorDTO);
}
