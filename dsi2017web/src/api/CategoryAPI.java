package api;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejb.CategoryEJBLocal;
import model.Category;

@Path("/category")
@RequestScoped
public class CategoryAPI {
	
	@EJB
	private CategoryEJBLocal categoryEJB;
	
	@GET
	@Produces("application/json")
	public List<Category> getCategories(@HeaderParam("userId") long userId){
		return categoryEJB.getCategories(userId);
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Category getCategory(@PathParam("id") long id){
		return categoryEJB.getCategory(id);
	}

	@POST
	@Consumes("application/json")
	public void add(Category category){
		categoryEJB.add(category);
	}
	
	@POST
	@Path("/many")
	@Consumes("application/json")
	public void addMany(List<Category> categories){
		for(Category category : categories) {
			categoryEJB.add(category);	
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void update(@PathParam("id") long id, Category category){
		categoryEJB.update(id, category);
	}
	
	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") long id){
		categoryEJB.remove(id);
	}
}