package ejb;

import javax.ejb.Local;
import model.User;

@Local
public interface UserEJBLocal {
	public User getUser(long id);

	public void add(User user);

	public void update(long id, User user);

	public void remove(long id);
	
	public void changePassword(int id, String newPassword);
}
