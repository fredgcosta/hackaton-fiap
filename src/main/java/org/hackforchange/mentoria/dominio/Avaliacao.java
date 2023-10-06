package org.hackforchange.mentoria.dominio;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Avaliacao extends PanacheEntity {
    @OneToMany
    public List<Questao> questoes;
}
