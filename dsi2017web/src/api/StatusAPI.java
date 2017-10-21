package api;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/status")
@RequestScoped
public class StatusAPI {
	
	@GET
	public String getClientes(){
		return "I am alive";
	}
}
