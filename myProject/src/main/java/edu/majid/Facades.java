package edu.majid;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;



@Path("/")
public class Facades {
	private final static Logger LOGGER = Logger.getLogger(Facades.class.getName());

	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestService() {
		LOGGER.info("Ping -- server is Up !");
		// WellHeadFactory.createRandomData();
		return "Hello Majid! This is coming from my webservice!!";
	}

	@POST
	@Path("/resetPassword")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String resetPassword(String jsonIN) {
		LOGGER.info("In  /resetPassword");
		JSONObject json = new JSONObject(jsonIN);
		String token = (String) json.get("token");
		System.out.println(token);
		String password = (String) json.get("password");
		System.out.println(token);
		/*
		 * ....
		*/
		return "KO";

	}
	

}
