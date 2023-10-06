package org.hackforchange.mentoria.infra;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.hackforchange.mentoria.dominio.Organizacao;

@ApplicationScoped
public class OrganizacaoRepository implements PanacheRepository<Organizacao> {
    public Uni<Organizacao> findByName(String name) {
        return find("nome", name).firstResult();
    }
}
