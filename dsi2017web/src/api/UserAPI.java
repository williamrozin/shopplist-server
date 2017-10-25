package api;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
	@Path("/login")
	@Produces("application/json")
	public User login(@HeaderParam("email") String email, @HeaderParam("password") String password){
		return clienteEJB.login(email, password);
	}
	
	@POST
	@Path("/signup")
	@Consumes("application/json")
	public void signup(String email, String password, String name){
		clienteEJB.signup(email, name, password);
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void update(@PathParam("id") long id, User user){
		clienteEJB.update(id, user);
	}
	
	@PUT
	@Path("/reset-password/{id}")
	@Consumes("application/json")
	public void changePassword(@PathParam("id") long id, String newPassword){
		clienteEJB.changePassword(id, newPassword);
	}	
}