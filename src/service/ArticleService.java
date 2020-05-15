package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Article;
import view.ArticleView;

public class ArticleService {
	
	public static JSONArray listNewArticles() {
		
		JSONArray articles = new JSONArray();
		
		Article article = new Article();
		articles = article.listNewArticles();
		
		return articles;
	}
	
	public static JSONArray listPopularArticles() {
		
		JSONArray articles = new JSONArray();
		
		Article article = new Article();
		articles = article.listPopularArticles();
		
		return articles;
	}
	
public static JSONArray listNewArticlesThumbnail() {
		
		JSONArray articles = new JSONArray();
		
		Article article = new Article();
		articles = article.listNewArticlesThumbnail();
		
		return articles;
	}
	
	public static JSONArray listPopularArticlesThumbnail() {
		
		JSONArray articles = new JSONArray();
		
		Article article = new Article();
		articles = article.listPopularArticlesThumbnail();
		
		return articles;
	}
	
	public static JSONObject updateArticle(JSONObject input) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			Article article = new Article();
			article.setArticleID(input.getInt("articleID"));
			article.setArticleTitle(input.getString("articleTitle"));
			article.setArticleContent(input.getString("articleContent"));
			//article.setCategoryID(Integer.parseInt(input.getString("articleCategoryID")));
			//article.setArticleImage(input.getString("articleImage"));
			
			message = article.updateArticle();
			
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getArticle(int id) {
		JSONObject articleJSONObj = new JSONObject();
		
		Article article = new Article();
		article.setArticleID(id);
		articleJSONObj = article.getArticle();
		ArticleView view = new ArticleView();
		
		try {
			article.setArticleAuthorID(articleJSONObj.getInt("articleAuthorID"));
			article.setArticleCategoryID(articleJSONObj.getInt("articleCategoryID"));
			article.setArticleContent(articleJSONObj.getString("articleContent"));
			article.setArticleCreateDate(articleJSONObj.getString("articleCreateDate"));
			article.setArticleLikes(articleJSONObj.getInt("articleLikes"));
			article.setArticleThumbnail(articleJSONObj.getString("articleThumbnail"));
			article.setArticleTitle(articleJSONObj.getString("articleTitle"));
			article.setArticleVisible(articleJSONObj.getInt("articleVisible"));

			view.setArticle(article);
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return view.articleView();
	}
	
	public static JSONObject addArticle(JSONObject input) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			Article article = new Article();
			article.setArticleTitle(input.getString("articleTitle"));
			article.setArticleContent(input.getString("articleContent"));
			article.setArticleAuthorID(input.getInt("articleAuthorID"));
			article.setArticleVisible(1);
			//article.setCategoryID(Integer.parseInt(input.getString("articleCategoryID")));
			
			message = article.addArticle();
			
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
