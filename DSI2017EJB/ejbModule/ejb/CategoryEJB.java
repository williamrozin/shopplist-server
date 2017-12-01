package ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Category;

@Stateless
public class CategoryEJB implements CategoryEJBLocal {

	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public CategoryEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Category> getCategories(long userId) {
		List<Category> allCategories = em.createNamedQuery("getAllCategories", Category.class).getResultList();
		List<Category> userCategories = new ArrayList<Category>();
		
		for(Category cat : allCategories) {
			if (cat.getUserId() == 0 || cat.getUserId() == userId) {
				userCategories.add(cat);
			}
		}
		
		return userCategories;
	}

	@Override
	public void add(Category category) {
		em.persist(category);
	}

	@Override
	public void update(long id, Category newCategory) {
		Category oldCat = em.find(Category.class, id);

		if (newCategory.getColor() != null)
			oldCat.setColor(newCategory.getColor());

		if (newCategory.getDescription() != null)
			oldCat.setDescription(newCategory.getDescription());

		em.merge(oldCat);
	}

	@Override
	public void remove(long id) {
		Category cat = em.find(Category.class, id);
		em.remove(cat);
	}

	@Override
	public Category getCategory(long id) {
		Category cat = em.find(Category.class, id);
		return cat;
	}

}
