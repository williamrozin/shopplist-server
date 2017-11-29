package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.ListItem;
import model.ShoppingList;
@Stateless
public class ShoppingListEJB implements ShoppingListEJBLocal {

	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public ShoppingListEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ShoppingList> getAllShoppingLists(long userId) {
		List<ShoppingList> lists = em.createNamedQuery("getAllShoppingLists", ShoppingList.class).getResultList();
		List<ShoppingList> userList = new ArrayList<ShoppingList>();

		for(ShoppingList list : lists) {
			if (list.getUserId() == userId) {
				userList.add(list);
			}
		}
		return userList;
	}

	@Override
	public void add(ShoppingList list) {
		em.persist(list);
	}

	@Override
	public void update(long id, ShoppingList newList) {
		ShoppingList list = em.find(ShoppingList.class, id);
		
		if (list != null)
			em.merge(newList);
	}

	@Override
	public void remove(long id) {
		ShoppingList list = em.find(ShoppingList.class, id);
		em.remove(list);
	}

	@Override
	public ShoppingList getShoppingList(long id) {
		ShoppingList list = em.find(ShoppingList.class, id);
		return list;
	}

	@Override
	public void addItemOnList(long id, ListItem listItem) {
		ShoppingList list = em.find(ShoppingList.class, id);
		list.addItemOnList(listItem);
	}
	
	@Override
	public void removeItemFromList(long id, ListItem listItem) {
		ShoppingList list = em.find(ShoppingList.class, id);
		list.removeItemOnList(listItem);
	}


	@Override
	public void setListCompleted(long id) {
		ShoppingList list = em.find(ShoppingList.class, id);
		list.setCompleted(true);
		em.merge(list);
		
	}

	@Override
	public void unsetListCompleted(long id) {
		ShoppingList list = em.find(ShoppingList.class, id);
		list.setCompleted(false);
		em.merge(list);
	}
}
