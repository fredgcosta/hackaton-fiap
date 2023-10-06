package org.hackforchange.mentoria.infra;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.hackforchange.mentoria.dominio.Mentor;

@ApplicationScoped
public class MentorRepository implements PanacheRepository<Mentor> {
    public Uni<Mentor> findByName(String name) {
        return find("nome", name).firstResult();
    }
}
