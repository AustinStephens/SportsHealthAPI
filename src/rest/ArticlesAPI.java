package rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;

import service.ArticleService;

@Path("/articles")
public class ArticlesAPI {

	@GET
	@Path("/listnew/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listNewArticles() {
		
		return ArticleService.listNewArticles().toString();
	}
	
	@GET
	@Path("/listpop/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listPopularArticles() {
		
		return ArticleService.listPopularArticles().toString();
	}
	
	@GET
	@Path("/thumbnailnew/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listArticlesThumbnail() {
		
		return ArticleService.listNewArticlesThumbnail().toString();
	}
	
	@GET
	@Path("/thumbnailpop/")
	@Produces("application/json")
	@Consumes("application/json")
	public String popularArticlesThumbnail() {
		
		return ArticleService.listPopularArticlesThumbnail().toString();
	}
	
	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateArticle(String inputParams) {
		
		try {
			return ArticleService.updateArticle(new JSONObject(inputParams)).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "update failed!";
	}
	
	@GET
	@Path("/{id}/")
	@Produces("text/html")
	@Consumes("text/html")
	public String getArticle(@PathParam("id") Integer id) {
		
		return ArticleService.getArticle(id).toString();
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addArticle(String inputParams) {
		
		try {
			return ArticleService.addArticle(new JSONObject(inputParams)).toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "addArticleAPI failed";
	}
	
}
