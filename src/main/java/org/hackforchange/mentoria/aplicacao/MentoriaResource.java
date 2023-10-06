package org.hackforchange.mentoria.aplicacao;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.hackforchange.mentoria.aplicacao.mappers.MentoriaMapper;
import org.jboss.logging.Logger;

@Path("/v1/mentorias")
public class MentoriaResource {
    private final Logger logger;
    private final MentoriaMapper mapper;

    public MentoriaResource(Logger logger, MentoriaMapper mapper) {
        this.logger = logger;
        this.mapper = mapper;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}
