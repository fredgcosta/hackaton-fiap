package org.hackforchange.mentoria.dominio;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Comentario extends PanacheEntity {
    public LocalDateTime dataHora;
    public String texto;
}
