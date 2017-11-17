package api;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import ejb.UserEJBLocal;
import model.Category;
import model.Login;
import model.User;

@Path("/user")
@RequestScoped
public class UserAPI {
	
	@EJB
	private UserEJBLocal clienteEJB;
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public User login(Login login){
		return clienteEJB.login(login.getEmail(), login.getPassword());
	}
	
	@POST
	@Path("/signup")
	@Produces("application/json")
	@Consumes("application/json")
	public User signup(User user){
		clienteEJB.signup(user);
		return user;
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void update(@PathParam("id") long id, User user){
		clienteEJB.update(id, user);
	}
	
	@PUT
	@Path("/reset-password/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void changePassword(@PathParam("id") long id, @FormParam("newPassword") String newPassword){
		clienteEJB.changePassword(id, newPassword);
	}	
}