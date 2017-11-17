package ejb;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.Category;

@NamedQueries({ @NamedQuery(name = "getAllCategories", query = "SELECT e FROM Category e") })

@Local
@Table(name = "Category")
public interface CategoryEJBLocal {

	public List<Category> getCategories();
	
	public Category getCategory(long id);

	public void add(Category category);
	
	public void update(long id, Category category);

	public void remove(long id);
}
