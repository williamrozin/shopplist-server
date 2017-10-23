package ejb;

import javax.ejb.Local;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import model.User;

@Local
@Table(name = "User")
public interface UserEJBLocal {
	public User login(String email, String password);

	public void signup(User user);

	public void update(String email, User user);
	
	public void changePassword(String email, String newPassword);
}
