/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.ws;

import br.com.senacrs.nomoreincidents.mb.UsuarioMB;
import br.com.senacrs.nomoreincidents.model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Diego Kremer
 */
@Path("Usuario")
public class UsuarioResource {
    @EJB
    private UsuarioMB usuarioMB;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of br.com.senacrs.nomoreincidents.ws.UsuarioResource
     * @return an instance of br.com.senacrs.nomoreincidents.model.Usuario
     */
    @GET
    @Produces("application/json")
    public List<Usuario> getUsuario() {
        return usuarioMB.getListaUsuarios();
    }

    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String adicionarUsuario(Usuario usuario) {
        usuarioMB.adicionarUsuario(usuario);
        return "OK";
    }
}
