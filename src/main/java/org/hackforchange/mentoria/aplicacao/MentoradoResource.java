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
import org.hackforchange.mentoria.aplicacao.mappers.MentoradoMapper;
import org.hackforchange.mentoria.dominio.Mentorado;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/v1/mentorados")
@Tag(name = "mentorados")
public class MentoradoResource {
    private final Logger logger;
    private final MentoradoMapper mapper;

    public MentoradoResource(Logger logger, MentoradoMapper mapper) {
        this.logger = logger;
        this.mapper = mapper;
    }

    @Operation(summary = "Retorna todos os mentorados")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Mentorado.class, type = SchemaType.ARRAY)))
    public Uni<List<Mentorado>> getAllMentorados() {
        return Mentorado.listAll();
    }

    @Operation(summary = "Retorna um mentorado para um determinado id")
    @GET
    @Path("/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Mentorado.class)))
    @APIResponse(responseCode = "204", description = "O mentorado não foi encontrado para um determinado id")
    public Uni<RestResponse<Mentorado>> getMentorado(@RestPath Long id) {
        return Mentorado.<Mentorado>findById(id)
                .map(mentorado -> {
                    if (mentorado != null) {
                        return RestResponse.ok(mentorado);
                    }
                    logger.debugf("Nenhum mentorado encontrado para o id %d", id);
                    return RestResponse.noContent();
                });
    }

    @Operation(summary = "Cria um novo mentorado")
    @POST
    @APIResponse(responseCode = "201", description = " A URI do mentorado criado", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @WithTransaction
    public Uni<RestResponse<URI>> createMentorado(@Valid Mentorado mentorado, @Context UriInfo uriInfo) {
        return mentorado.<Mentorado>persist()
                .map(h -> {
                    UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(h.id));
                    logger.debug("Novo mentorado criado com a URI " + builder.build().toString());
                    return RestResponse.created(builder.build());
                });
    }

    @Operation(summary = "Atualiza um mentorado")
    @PUT
    @APIResponse(responseCode = "200", description = "Mentorado atualizado", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Mentorado.class)))
    @WithTransaction
    @Consumes("application/json")
    @Produces("application/json")
    public Uni<Mentorado> updateMentorado(Mentorado mentorado) {
        return Mentorado.<Mentorado>findById(mentorado.id)
                .map(retrieved -> {
                    retrieved.nome = mentorado.nome;
                    retrieved.email = mentorado.email;
                    retrieved.cpf = mentorado.cpf;
                    retrieved.foto = mentorado.foto;
                    retrieved.curriculo = mentorado.curriculo;
                    return retrieved;
                })
                .map(h -> {
                    logger.debugf("Mentorado atualizado com o novo valor %s", h);
                    return h;
                });
    }

    @Operation(summary = "Exclui um mentorado")
    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204")
    @WithTransaction
    public Uni<RestResponse<Void>> deleteHero(@RestPath Long id) {
        return Mentorado.deleteById(id)
                .invoke(() -> logger.debugf("Excluido o mentorado com o id %d", id))
                .replaceWith(RestResponse.noContent());
    }

}
