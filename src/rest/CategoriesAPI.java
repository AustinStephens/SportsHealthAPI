package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import service.CategoryService;

@Path("/categories")
public class CategoriesAPI {
	
	@GET
	@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listCategories() {
		
		return CategoryService.listCategories().toString();
		//return CategoryService.listCatByNav().toString();
	}
	
	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateCategory(String inputParams) {
		
		try {
			return CategoryService.updateCategory(new JSONObject(inputParams)).toString();
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
	public String getCategory(@PathParam("id") Integer id) {
		
		return CategoryService.getCategory(id).toString();
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addCategory(String inputParams) {
		
		try {
			return CategoryService.addCategory(new JSONObject(inputParams)).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "addArticleAPI failed";
	}
	
	@POST
	@Path("/delete/")
	@Produces("application/json")
	@Consumes("application/json")
	public String deleteCategory(String inputParams) {
		
		try {
			return CategoryService.deleteCategory(new JSONObject(inputParams)).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "deleteArticleAPI failed";
	}
}
