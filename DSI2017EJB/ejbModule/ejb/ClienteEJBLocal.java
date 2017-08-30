package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Cliente;

@Local
public interface ClienteEJBLocal {
	public List<Cliente> todosClientes();

	void insereCliente(Cliente cliente);
}
