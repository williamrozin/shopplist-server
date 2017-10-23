package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.ListItem;

@NamedQueries({ @NamedQuery(name = "getAllListItems", query = "SELECT e FROM ListItem e") })

@Local
public interface ListItemEJBLocal {

	public List<ListItem> getAllListItems();

	public void add(ListItem listItem);

	public void update(long id, ListItem listItem);

	public void remove(long id);
}
