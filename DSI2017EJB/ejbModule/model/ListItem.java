package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="getAllListItems",
			query="select c from ListItem c")
})

@Entity
public class ListItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private MetaItem metaItem;
	private boolean checked;
	private float price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked() {
		this.checked = true;
	}

	public void unsetChecked() {
		this.checked = false;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
