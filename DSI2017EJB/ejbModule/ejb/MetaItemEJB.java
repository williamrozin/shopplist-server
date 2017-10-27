package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Category;
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
	public void add(String description, long categoryId) {
		CategoryEJB cat = new CategoryEJB();
		Category category =  cat.getCategory(categoryId);
		MetaItem metaItem = new MetaItem();
		metaItem.setCategory(category);
		metaItem.setDescription(description);
		em.persist(metaItem);
	}

	@Override
	public void update(long id, String description, long categoryId) {
		MetaItem oldItem = em.find(MetaItem.class, id);
		CategoryEJB cat = new CategoryEJB();
		Category newCategory =  cat.getCategory(categoryId);

		if (categoryId != newCategory.getId())
			oldItem.setCategory(newCategory);
		
		if (description != null)
			oldItem.setDescription(description);

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
