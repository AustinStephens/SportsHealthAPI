package rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import service.UserService;

@Path("/users")
public class UsersAPI {

	/*@GET
	@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listUsers() {
		
		return UserService.listUsers().toString();
	}
	
	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateUser(String inputParams) {
		
		try {
			return UserService.updateUser(new JSONObject(inputParams)).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "update failed!";
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getUser(@PathParam("id") Integer id) {
		
		return UserService.getUser(id).toString();
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addUser(String inputParams) {
		
		try {
			return UserService.addUser(new JSONObject(inputParams)).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "adduserAPI failed";
	}
	
	@POST
	@Path("/authenticate/")
	@Produces("application/json")
	@Consumes("application/json")
	public String authenticate(String inputParams) {
		
		try {
			return UserService.authenticate(new JSONObject(inputParams)).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "authentication failed";
	}
	*/
}
