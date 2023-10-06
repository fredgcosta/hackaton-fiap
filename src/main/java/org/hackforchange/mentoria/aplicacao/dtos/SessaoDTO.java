package org.hackforchange.mentoria.aplicacao.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode
@NoArgsConstructor
@Data
public class SessaoDTO {
    private MentoriaDTO mentoria;
    private LocalDateTime datahora;
}
