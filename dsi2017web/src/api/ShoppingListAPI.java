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
	public List<ShoppingList> getShoppingLists(){
		return shoppingListEJB.getAllShoppingLists();
	}
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	public ShoppingList getShoppingList(@PathParam("id") long id){
		return shoppingListEJB.getShoppingList(id);
	}
	
	@POST
	@Consumes("application/json")
	public void add(ShoppingList list){
		shoppingListEJB.add(list);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void update(@PathParam("id") long id, ShoppingList list){
		shoppingListEJB.update(id, list);
	}
	
	@PUT
	@Path("/{id}/item")
	@Consumes("application/json")
	public void addItemOnList(@PathParam("id") long id, ListItem listItem){
		shoppingListEJB.addItemOnList(id, listItem);
	}
	
	@PUT
	@Path("/{id}/item")
	@Consumes("application/json")
	public void removeItemFromList(@PathParam("id") long id, ListItem listItem){
		shoppingListEJB.removeItemFromList(id, listItem);
	}
}