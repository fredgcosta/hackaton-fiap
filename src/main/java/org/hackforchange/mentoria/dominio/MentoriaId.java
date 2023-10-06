package org.hackforchange.mentoria.dominio;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class MentoriaId implements Serializable {
    private Long mentorId;
    private Long mentoradoId;
}
