package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Category;
import model.ListItem;
import model.MetaItem;
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
	public void add(long metaItemId, float price) {
		MetaItemEJB ejb = new MetaItemEJB();
		MetaItem metaItem =  ejb.getMetaItem(metaItemId);
		ListItem listItem = new ListItem();		
		listItem.setMetaItem(metaItem);
		listItem.setPrice(price);
		em.persist(listItem);
	}

	@Override
	public void update(long id, float price) {
		ListItem oldItem = em.find(ListItem.class, id);

		if (price != oldItem.getPrice())
			oldItem.setPrice(price);		

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

		oldItem.setChecked();	

		em.merge(oldItem);
	}

	@Override
	public void unckeck(long id) {
		ListItem oldItem = em.find(ListItem.class, id);

		oldItem.unsetChecked();

		em.merge(oldItem);		
	}

}
