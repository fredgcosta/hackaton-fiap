package org.hackforchange.mentoria.dominio;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Questao extends PanacheEntity {
    public String texto;
}
