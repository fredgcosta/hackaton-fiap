package org.hackforchange.mentoria.dominio;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sessao extends PanacheEntity {
    @ManyToOne
    public Mentoria mentoria;
    public LocalDateTime datahora;
    public String memoria;

    @OneToMany
    public List<Comentario> comentarios;
}
