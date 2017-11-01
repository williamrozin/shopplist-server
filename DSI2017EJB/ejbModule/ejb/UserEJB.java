package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.ShoppingList;
import model.User;

/**
 * Session Bean implementation class ClienteEJB
 */
@Stateless
public class UserEJB implements UserEJBLocal {

	@PersistenceContext(name = "dsi2017context")
	private EntityManager em;

	public UserEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String email, String password) {
		List<User> users = em.createNamedQuery("getAllUsers", User.class).getResultList();
		
		for(User user:users) {
			if (user.login(email, password)) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public void signup(User user) {
		em.persist(user);
	}

	@Override
	public void update(long id, User newUser) {
		User oldUsr = em.find(User.class, id);

		if (newUser.getName() != null)
			oldUsr.setName(newUser.getName());

		em.merge(oldUsr);
	}

	@Override
	public void changePassword(long id, String newPassword) {
		User oldUsr = em.find(User.class, id);

		if (newPassword != null)
			oldUsr.setPassword(newPassword);

		em.merge(oldUsr);
	}
}
