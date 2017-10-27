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
	public List<Category> getCategories(){
		return categoryEJB.getCategories();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Category getCategory(@PathParam("id") long id){
		return categoryEJB.getCategory(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void add(@FormParam("color") String color, @FormParam("description") String description){
		categoryEJB.add(color, description);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void update(@PathParam("id") long id, @FormParam("color") String color, @FormParam("description") String description){
		categoryEJB.update(id, color, description);
	}
	
	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") long id){
		categoryEJB.remove(id);
	}
}