package org.hackforchange.mentoria.aplicacao.mappers;

import org.hackforchange.mentoria.aplicacao.dtos.SessaoDTO;
import org.hackforchange.mentoria.dominio.Sessao;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface SessaoMapper {
    SessaoDTO sessaoToSessaoDTO(Sessao sessao);

    @InheritInverseConfiguration
    Sessao sessaoDTOToSessao(SessaoDTO sessaoDTO);
}

