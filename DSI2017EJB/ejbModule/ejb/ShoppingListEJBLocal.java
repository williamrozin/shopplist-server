package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.ListItem;
import model.ShoppingList;

@NamedQueries({ @NamedQuery(name = "getAllShoppingLists", query = "SELECT e FROM ShoppingList e") })

@Local
@Table(name = "ShoppingList")
public interface ShoppingListEJBLocal {

	public List<ShoppingList> getAllShoppingLists(long userId);

	public ShoppingList getShoppingList(long id);
	
	public void add(ShoppingList list);

	public void update(long id, ShoppingList list);

	public void remove(long id);
	
	public void addItemOnList(long id, ListItem listItem);
	
	public void removeItemFromList(long id, ListItem listItem);
	
	public void setListCompleted(long id);
	
	public void unsetListCompleted(long id);
}
