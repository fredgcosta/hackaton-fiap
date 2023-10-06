package org.hackforchange.mentoria.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class Mentorado extends PanacheEntity {
    @Size(min = 3, max = 255)
    public String nome;
    public String email;
    public String cpf;
    @ManyToOne
    public Organizacao org;
    @Column(length = 5000)
    public String curriculo;

    public String foto;

    @JsonIgnore
    @OneToMany(mappedBy = "mentorado")
    public Set<Mentoria> mentorias;
}
