package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.MetaItem;

@NamedQueries({ @NamedQuery(name = "getAllMetaItems", query = "SELECT e FROM MetaItem e") })

@Local
@Table(name = "MetaItem")
public interface MetaItemEJBLocal {
	public List<MetaItem> getAllMetaItems();

	public void add(MetaItem metaItem);

	public void update(long id, MetaItem metaItem);

	public void remove(long id);
}
