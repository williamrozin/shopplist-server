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

	@Override
	public Cliente getCliente(long id) {
		// TODO Auto-generated method stub
		return em.find(Cliente.class, id);
	}

	@Override
	public void remove(long id) {
		Cliente cli = em.find(Cliente.class, id);
		em.remove(cli);
	}

	@Override
	public void update(long id, Cliente newCliente) {
		// TODO Auto-generated method stub
		Cliente oldCli = em.find(Cliente.class, id);

		if(newCliente.getNome() != null)
			oldCli.setNome(newCliente.getNome());
		
		oldCli.setSexo(newCliente.getSexo());
		
		em.merge(oldCli);
	}
}
