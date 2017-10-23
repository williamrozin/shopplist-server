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
	public User getUser(long id) {
		return em.find(User.class, id);
	}

	@Override
	public void add(User user) {
		em.persist(user);
	}

	@Override
	public void update(long id, User newUser) {
		User oldUsr = em.find(User.class, id);

		if (newUser.getNome() != null)
			oldUsr.setNome(newUser.getNome());

		if (newUser.getNome() != null)
			oldUsr.setEmail(newUser.getEmail());

		em.merge(oldUsr);
	}

	@Override
	public void remove(long id) {
		User cli = em.find(User.class, id);
		em.remove(cli);
	}

	@Override
	public void changePassword(int id, String newPassword) {
		User oldUsr = em.find(User.class, id);

		if (newPassword != null)
			oldUsr.setPassword(newPassword);

		em.merge(oldUsr);
	}
}
