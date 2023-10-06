package org.hackforchange.mentoria.aplicacao;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.hackforchange.mentoria.aplicacao.mappers.MentorMapper;
import org.hackforchange.mentoria.dominio.Mentor;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/v1/mentores")
@Tag(name = "mentores")
@Produces(APPLICATION_JSON)
public class MentorResource {
    private final Logger logger;
    private final MentorMapper mapper;

    public MentorResource(Logger logger, MentorMapper mapper) {
        this.logger = logger;
        this.mapper = mapper;
    }

    @Operation(summary = "Retorna todos os mentores")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Mentor.class, type = SchemaType.ARRAY)))
    public Uni<List<Mentor>> getAllMentores() {
        return Mentor.listAll();
    }

    @Operation(summary = "Retorna um mentor para um determinado id")
    @GET
    @Path("/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Mentor.class)))
    @APIResponse(responseCode = "204", description = "O mentor não foi encontrado para um determinado id")
    public Uni<RestResponse<Mentor>> getMentor(@RestPath Long id) {
        return Mentor.<Mentor>findById(id)
                .map(mentor -> {
                    if (mentor != null) {
                        return RestResponse.ok(mentor);
                    }
                    logger.debugf("Nenhum mentor encontrado para o id %d", id);
                    return RestResponse.noContent();
                });
    }

    @Operation(summary = "Cria um novo mentor")
    @POST
    @APIResponse(responseCode = "201", description = " A URI do mentor criado", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @WithTransaction
    public Uni<RestResponse<URI>> createMentor(@Valid Mentor mentor, @Context UriInfo uriInfo) {
        return mentor.<Mentor>persist()
                .map(h -> {
                    UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(h.id));
                    logger.debug("Novo mentor criado com a URI " + builder.build().toString());
                    return RestResponse.created(builder.build());
                });
    }

    @Operation(summary = "Atualiza um mentor")
    @PUT
    @APIResponse(responseCode = "200", description = "Mentor atualizado", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Mentor.class)))
    @WithTransaction
    @Consumes("application/json")
    @Produces("application/json")
    public Uni<Mentor> updateMentor(Mentor mentor) {
        return Mentor.<Mentor>findById(mentor.id)
                .map(retrieved -> {
                    retrieved.nome = mentor.nome;
                    retrieved.email = mentor.email;
                    retrieved.cpf = mentor.cpf;
                    retrieved.foto = mentor.foto;
                    retrieved.curriculo = mentor.curriculo;
                    return retrieved;
                })
                .map(h -> {
                    logger.debugf("Mentor atualizado com o novo valor %s", h);
                    return h;
                });
    }

    @Operation(summary = "Exclui um mentor")
    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204")
    @WithTransaction
    public Uni<RestResponse<Void>> deleteHero(@RestPath Long id) {
        return Mentor.deleteById(id)
                .invoke(() -> logger.debugf("Excluido o mentor com o id %d", id))
                .replaceWith(RestResponse.noContent());
    }
}