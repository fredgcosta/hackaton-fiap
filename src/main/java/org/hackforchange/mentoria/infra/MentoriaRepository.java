package org.hackforchange.mentoria.infra;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.hackforchange.mentoria.dominio.Mentoria;

@ApplicationScoped
public class MentoriaRepository implements PanacheRepository<Mentoria> {
}