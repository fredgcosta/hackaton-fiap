package org.hackforchange.mentoria.dominio;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Mentoria extends PanacheEntityBase {
    @EmbeddedId
    public MentoriaId id;

    @ManyToOne
    @MapsId("mentorId")
    public Mentor mentor;

    @ManyToOne
    @MapsId("mentoradoId")
    public Mentorado mentorado;

    @OneToMany
    public List<Sessao> sessao;
    @OneToMany
    public List<Avaliacao> avaliacoes;

}
