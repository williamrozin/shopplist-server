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
import model.User;

@Path("/user")
@RequestScoped
public class UserAPI {
	
	@EJB
	private UserEJBLocal clienteEJB;
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public User login(@FormParam("email") String email, @FormParam("password") String password){
		return clienteEJB.login(email, password);
	}
	
	@POST
	@Path("/signup")
	@Consumes("application/json")
	public void signup(User user){
		clienteEJB.signup(user);
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