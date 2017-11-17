package api;

import java.util.List;

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
import javax.ws.rs.core.Response;

import ejb.ShoppingListEJBLocal;
import model.Category;
import model.ListItem;
import model.ShoppingList;

@Path("/lists")
@RequestScoped
public class ShoppingListAPI {
	
	@EJB
	private ShoppingListEJBLocal shoppingListEJB;
	
	@GET
	@Produces("application/json")
	public List<ShoppingList> getShoppingLists(@HeaderParam("userId") long userId){
		System.out.println("Chamando Dr hans chucrute");
		return shoppingListEJB.getAllShoppingLists(userId);
	}
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	public ShoppingList getShoppingList(@PathParam("id") long id){
		return shoppingListEJB.getShoppingList(id);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public ShoppingList add(ShoppingList list){
		shoppingListEJB.add(list);
		return list;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void update(@PathParam("id") long id, ShoppingList list){
		shoppingListEJB.update(id, list);
	}

	@PUT
	@Path("/{id}/complete")
	public void complete(@PathParam("id") long id){
		shoppingListEJB.setListCompleted(id);
	}

	@PUT
	@Path("/{id}/uncomplete")
	public void uncomplete(@PathParam("id") long id){
		shoppingListEJB.unsetListCompleted(id);
	}
	
	@PUT
	@Path("/{id}/item/add")
	@Consumes("application/json")
	public void addItemOnList(@PathParam("id") long id, ListItem listItem){
		shoppingListEJB.addItemOnList(id, listItem);
	}
	
	@PUT
	@Path("/{id}/item/remove")
	@Consumes("application/json")
	public void removeItemFromList(@PathParam("id") long id, ListItem listItem){
		shoppingListEJB.removeItemFromList(id, listItem);
	}
}