package br.unitins.tp1.faixas.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.tp1.faixas.dto.EstadoRequestDTO;
import br.unitins.tp1.faixas.model.Estado;
import br.unitins.tp1.faixas.service.EstadoService;
import br.unitins.tp1.faixas.validation.ValidationException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    private static final Logger LOG = Logger.getLogger(EstadoResource.class);

    @Inject
    public EstadoService estadoService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"Adm", "User"})
    public Estado findById(@PathParam("id") Long id) {
        LOG.info("Execucao do metodo findById. Id: "+ id);
        LOG.debug("DEBUG EXEMPLO");
        return estadoService.findById(id);
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed("Adm")
    public List<Estado> findByNome(@PathParam("nome") String nome) {
        return estadoService.findByNome(nome);
    }

    @GET
    public List<Estado> findAll() {
        return estadoService.findAll();
    }

    @POST
    public Estado create(EstadoRequestDTO estado) {
        
        return estadoService.create(estado);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, EstadoRequestDTO estado) {
        estadoService.update(id, estado);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        estadoService.delete(id);
    }
    
}
