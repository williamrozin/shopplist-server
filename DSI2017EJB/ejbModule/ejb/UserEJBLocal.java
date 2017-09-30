package ejb;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.User;

@Local
@Table(name = "User")
public interface UserEJBLocal {
	public User getUser(long id);

	public void add(User user);

	public void update(long id, User user);

	public void remove(long id);
	
	public void changePassword(int id, String newPassword);
}
