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

import ejb.ListItemEJBLocal;
import model.ListItem;

@Path("/item")
@RequestScoped
public class ListItemAPI {
	
	@EJB
	private ListItemEJBLocal listItemEJB;

	@GET
	@Produces("application/json")
	public List<ListItem> getAllItems(){
		return listItemEJB.getAllListItems();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ListItem getItem(@PathParam("id") long id){
		return listItemEJB.getListItem(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void add(@FormParam("metaItemId") long metaItemId, @FormParam("price") float price){
		listItemEJB.add(metaItemId, price);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void update(@PathParam("id") long id, @FormParam("price") float price){
		listItemEJB.update(id, price);
	}

	@PUT
	@Path("/{id}/check")
	public void check(@PathParam("id") long id){
		listItemEJB.check(id);
	}

	@PUT
	@Path("/{id}/unckeck")
	public void unckeck(@PathParam("id") long id){
		listItemEJB.unckeck(id);
	}
	
	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") long id){
		listItemEJB.remove(id);
	}	
}