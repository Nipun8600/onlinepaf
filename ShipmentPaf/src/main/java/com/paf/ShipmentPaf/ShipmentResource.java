package com.paf.ShipmentPaf;

//import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("shipments")
public class ShipmentResource 
{
	   
	
	ShipmentRepository repo = new ShipmentRepository();
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Shipment> getShipments() 
	{
		System.out.println("Shipment called...");
		//List<Shipment> shipments = Arrays.asList(s1,s2);
		return repo.getShipments();
	}
	
	
	@GET
	@Path("shipment/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Shipment getShipment(@PathParam("id") int id)
	{
		return repo.getShipment(id);
	}
	
	
	@POST
	@Path("shipment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Shipment createShip(Shipment s1)
	{
		System.out.println(s1);
		repo.create(s1);
		
		return s1;
	}

	@PUT
	@Path("shipment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Shipment updateShip(Shipment s1)
	{
		System.out.println(s1);
		repo.update(s1);
		
		return s1;
	}

	@DELETE
	@Path("shipment/{id}")
	public Shipment deleteship(@PathParam("id") int id)
	{
		Shipment s = repo.getShipment(id);
		
		if(s.getShipId()!=0)
			repo.delete(id);
		
		return s;
	}
	
	
	
}
