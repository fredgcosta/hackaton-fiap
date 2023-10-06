package org.hackforchange.mentoria.dominio;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Organizacao extends PanacheEntity {
    public String nome;
    public String cnpj;

    @OneToMany
    Set<Mentor> mentores;

    @OneToMany
    Set<Mentorado> mentorados;

}
