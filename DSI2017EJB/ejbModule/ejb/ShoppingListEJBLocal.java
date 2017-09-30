package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.ShoppingList;

@NamedQueries({ @NamedQuery(name = "getAllShoppingLists", query = "SELECT e FROM ShoppingList e") })

@Local
@Table(name = "ShoppingList")
public interface ShoppingListEJBLocal {

	public List<ShoppingList> getAllShoppingLists();

	public void add(ShoppingList list);

	public void update(long id, ShoppingList list);

	public void remove(long id);
}
