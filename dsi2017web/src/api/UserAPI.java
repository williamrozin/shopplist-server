package api;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ejb.UserEJBLocal;
import model.Category;
import model.User;

@Path("/user")
@RequestScoped
public class UserAPI {
	
	@EJB
	private UserEJBLocal clienteEJB;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public User login(String email, String password){
		return clienteEJB.login(email, password);
	}
	
	@POST
	@Consumes("application/json")
	public void signup(User user){
		clienteEJB.signup(user);
	}

	@PUT
	@Path("/{email}")
	@Consumes("application/json")
	public void update(@PathParam("email") String email, User user){
		clienteEJB.update(email, user);
	}
	
	@PUT
	@Path("/reset-password/{email}")
	@Consumes("application/json")
	public void changePassword(@PathParam("email") String email, String newPassword){
		clienteEJB.changePassword(email, newPassword);
	}	
}