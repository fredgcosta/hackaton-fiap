package org.hackforchange.mentoria.aplicacao.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@Data
public class MentorDTO {
    private String nome;
    private String cpf;
    private String email;
    private Set<MentoriaDTO> mentorias;
}
