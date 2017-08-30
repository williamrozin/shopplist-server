package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;

/**
 * Session Bean implementation class ClienteEJB
 */
@Stateless
public class ClienteEJB implements ClienteEJBLocal {

	@PersistenceContext(name="dsi2017context")
    private EntityManager em;
	
    public ClienteEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<Cliente> todosClientes() {
		Query q = 
			em.createNamedQuery("todosclientes");
		return q.getResultList();
	}

	@Override
	public void insereCliente(Cliente cliente) {
		em.persist(cliente);
	}
}
