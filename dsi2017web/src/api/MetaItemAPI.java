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

import ejb.MetaItemEJBLocal;
import model.Category;
import model.MetaItem;

@Path("/meta-item")
@RequestScoped
public class MetaItemAPI {
	
	@EJB
	private MetaItemEJBLocal metaItemEJB;
	
	@GET
	@Produces("application/json")
	public List<MetaItem> getAllMetaItems(){
		return metaItemEJB.getAllMetaItems();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public MetaItem getMetaItem(@PathParam("id") long id){
		return metaItemEJB.getMetaItem(id);
	}

	@POST
	@Consumes("application/json")
	public void add(MetaItem metaItem){
		metaItemEJB.add(metaItem);
	}
	
	@POST
	@Consumes("application/json")
	@Path("/many")
	public void addMany(List<MetaItem> metaItems){
		for(MetaItem metaItem : metaItems) {
			metaItemEJB.add(metaItem);	
		}
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void update(@PathParam("id") long id, MetaItem metaItem){
		metaItemEJB.update(id, metaItem);
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes("application/json")
	public void remove(@PathParam("id") long id){
		metaItemEJB.remove(id);
	}
	
}