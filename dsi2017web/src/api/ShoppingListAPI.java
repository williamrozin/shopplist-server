package api;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ejb.ShoppingListEJBLocal;
import model.ShoppingList;

@Path("/list")
@RequestScoped
public class ShoppingListAPI {
	
	@EJB
	private ShoppingListEJBLocal clienteEJB;
	
}