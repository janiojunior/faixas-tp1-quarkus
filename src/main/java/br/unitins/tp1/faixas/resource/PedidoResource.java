package br.unitins.tp1.faixas.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.tp1.faixas.dto.MunicipioRequestDTO;
import br.unitins.tp1.faixas.dto.PedidoRequestDTO;
import br.unitins.tp1.faixas.dto.PedidoResponseDTO;
import br.unitins.tp1.faixas.service.PedidoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    public PedidoService pedidoService;
    
    @Inject
    public JsonWebToken jwt;

    @GET
    @RolesAllowed("User")
    public Response findByUsername() {

        // buscando o username do hash do jwt
        String username = jwt.getSubject();

        return Response.ok(pedidoService.findByUsername(username).
                    stream().
                    map(o -> PedidoResponseDTO.valueOf(o)).
                    toList()).build();
    }

    @POST
    @RolesAllowed("User")
    public Response create(@Valid PedidoRequestDTO dto) {

        // buscando o username do hash do jwt
        String username = jwt.getSubject();

        return Response.status(Status.CREATED).entity(
            PedidoResponseDTO.valueOf(pedidoService.create(dto, username))
        ).build();
    
    }


}
