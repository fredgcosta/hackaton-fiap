package org.hackforchange.mentoria.aplicacao.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Data
public class MentoriaDTO {
    private MentorDTO mentor;
    private MentoradoDTO mentorado;
    private List<SessaoDTO> sessao;
}
