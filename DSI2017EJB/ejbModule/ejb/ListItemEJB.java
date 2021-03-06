package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.ListItem;
@Stateless
public class ListItemEJB implements ListItemEJBLocal {

	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public ListItemEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ListItem> getAllListItems() {
		return em.createNamedQuery("getAllListItems", ListItem.class).getResultList();
	}

	@Override
	public void add(ListItem listItem) {
		em.persist(listItem);
	}

	@Override
	public void update(long id, ListItem newItem) {
		ListItem oldItem = em.find(ListItem.class, id);

		if (newItem.getChecked() != oldItem.getChecked())
				oldItem.setChecked(newItem.getChecked());
		
		if (newItem.getPrice() != oldItem.getPrice())
			oldItem.setPrice(newItem.getPrice());		

		em.merge(oldItem);
	}

	@Override
	public void remove(long id) {
		ListItem item = em.find(ListItem.class, id);
		em.remove(item);
	}

	@Override
	public ListItem getListItem(long id) {
		ListItem item = em.find(ListItem.class, id);
		return item;
	}


	@Override
	public void check(long id) {
		ListItem oldItem = em.find(ListItem.class, id);

		oldItem.setChecked(true);	

		em.merge(oldItem);
	}

	@Override
	public void uncheck(long id) {
		ListItem oldItem = em.find(ListItem.class, id);

		oldItem.setChecked(false);

		em.merge(oldItem);		
	}

}
