package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		User user = em.find(User.class, email);
		return user.login(email, password);
	}

	@Override
	public void signup(User user) {
		em.persist(user);
	}

	@Override
	public void update(String email, User newUser) {
		User oldUsr = em.find(User.class, email);

		if (newUser.getNome() != null)
			oldUsr.setNome(newUser.getNome());

		em.merge(oldUsr);
	}

	@Override
	public void changePassword(String email, String newPassword) {
		User oldUsr = em.find(User.class, email);

		if (newPassword != null)
			oldUsr.setPassword(newPassword);

		em.merge(oldUsr);
	}
}
