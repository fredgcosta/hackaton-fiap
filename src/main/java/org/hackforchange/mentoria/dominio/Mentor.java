package org.hackforchange.mentoria.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Mentor extends PanacheEntity {
    public String nome;
    public String email;
    public String cpf;
    @Column(length = 5000)
    public String curriculo;

    public String foto;
    @JsonIgnore
    @OneToMany(mappedBy = "mentor")
    public Set<Mentoria> mentorias;

    @ManyToOne
    public Organizacao org;
}
