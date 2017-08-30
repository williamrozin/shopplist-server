package api;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ejb.ClienteEJBLocal;
import model.Cliente;

@Path("/cliente")
@RequestScoped
public class ClienteAPI {
	
	@EJB
	private ClienteEJBLocal clienteEJB;
	
	@GET
	@Produces("application/json")
	public List<Cliente> getClientes(){
		return clienteEJB.todosClientes();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response postCliente(Cliente cliente) {
		try{
			clienteEJB.insereCliente(cliente);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
	}
	
}



