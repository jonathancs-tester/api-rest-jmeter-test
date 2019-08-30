package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.restful.controller.ClienteController;
import br.com.restful.model.Cliente;

/**
 * Classe responsavel por conter os metodos REST de acesso ao webservice
 */
@Path("/")
public class ClienteResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> listarTodos() {
		System.out.println("Clientes encontrados no banco");
		return new ClienteController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		Cliente cliente = new ClienteController().buscarPorId(id);
		if (cliente != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON).entity(cliente).build();
		} else {
			return Response.status(404).entity("Cliente nao encontrado").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarClienteJson(Cliente cliente) {
		boolean isClienteGravado = new ClienteController().gravarCliente(cliente);
		if (isClienteGravado == true) {
			return Response.ok().entity(cliente).build();
		} else {
			return Response.status(500).entity("Erro no servidor  ao gravar cliente").build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response altualizarCliente(@PathParam("id") Long id, Cliente cliente) {
		boolean isClienteAtualizado = new ClienteController().atualizarCliente(id, cliente);

		if (isClienteAtualizado == true) {
			return Response.ok().entity(cliente).build();
		} else {
			return Response.status(500).entity("Erro no servidor  ao atualizar cliente").build();
		}

	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deletarCliente(@PathParam("id") Long id) {

		boolean isClienteDeletado = new ClienteController().deletarCliente(id);
		if (isClienteDeletado == true) {
			System.out.println("Cliente " + id + " deletado");
			return Response.ok().build();
		} else {
			System.out.println("Erro no servidor  ao deletar cliente: " + id);
			return Response.status(500).entity("Erro no servidor  ao deletar cliente: " + id).build();
		}

	}

}
