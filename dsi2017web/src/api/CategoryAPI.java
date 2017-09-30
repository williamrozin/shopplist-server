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

import ejb.CategoryEJBLocal;
import model.Category;

@Path("/category")
@RequestScoped
public class CategoryAPI {
	
	@EJB
	private CategoryEJBLocal categoryEJB;
	
	@GET
	@Produces("application/json")
	public List<Category> getClientes(){
		return categoryEJB.getCategories();
	}
}