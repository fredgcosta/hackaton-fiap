package org.hackforchange.mentoria.infra;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.hackforchange.mentoria.dominio.Mentorado;

@ApplicationScoped
public class MentoradoRepository implements PanacheRepository<Mentorado> {
    public Uni<Mentorado> findByName(String name) {
        return find("nome", name).firstResult();
    }

}
