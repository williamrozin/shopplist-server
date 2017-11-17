package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.MetaItem;
@Stateless
public class MetaItemEJB implements MetaItemEJBLocal {

	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public MetaItemEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MetaItem> getAllMetaItems() {
		return em.createNamedQuery("getAllMetaItems", MetaItem.class).getResultList();
	}

	@Override
	public void add(MetaItem metaItem) {
		em.persist(metaItem);
	}

	@Override
	public void addMany(List<MetaItem> metaItems) {
		for(MetaItem metaItem : metaItems) {
			em.persist(metaItem);	
		}
	}
	
	@Override
	public void update(long id, MetaItem newItem) {
		MetaItem oldItem = em.find(MetaItem.class, id);

		if (newItem.getCategory() != null && newItem.getCategory().getId() != oldItem.getCategory().getId())
			oldItem.setCategory(newItem.getCategory());
		
		if (newItem.getDescription() != null)
			oldItem.setDescription(newItem.getDescription());

		em.merge(oldItem);
	}

	@Override
	public void remove(long id) {
		MetaItem item = em.find(MetaItem.class, id);
		em.remove(item);
	}

	@Override
	public MetaItem getMetaItem(long id) {
		MetaItem item = em.find(MetaItem.class, id);
		return item;
	}

}
