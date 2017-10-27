package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.MetaItem;

@Local
@Table(name = "MetaItem")
public interface MetaItemEJBLocal {
	public List<MetaItem> getAllMetaItems();
	
	public MetaItem getMetaItem(long id);

	public void add(String description, long id);

	public void update(long id, String description, long categoryId);

	public void remove(long id);
}
