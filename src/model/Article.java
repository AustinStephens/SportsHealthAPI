package model;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import org.json.JSONArray;
import org.json.JSONObject;

public class Article {

	private int ArticleID;
	private int ArticleAuthorID;
	private String ArticleTitle;
	private String ArticleContent;
	private String ArticleCreateDate;
	private int ArticleVisible;
	private int ArticleCategoryID;
	private int ArticleLikes;
	private String ArticleThumbnail;

	public Article() {
		
	}
	
	public JSONArray listNewArticles() {
			
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT TOP 10 * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.articles WITH (NOLOCK) ORDER BY articleCreateDate DESC";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);	
		
		return query.lstQuery();
	}
	
	public JSONArray listPopularArticles() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT TOP 10 * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.articles WITH (NOLOCK) " +
				"ORDER BY articleLikes DESC";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		return query.lstQuery();
	}
	
	public JSONArray listNewArticlesThumbnail() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT TOP 4 * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.articles WITH (NOLOCK) ORDER BY articleCreateDate DESC";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		
		return query.lstQuery();
	}
	
	public JSONArray listPopularArticlesThumbnail() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT TOP 4 * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.articles WITH (NOLOCK) " +
				"ORDER BY articleLikes DESC";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		return query.lstQuery();
	}
	
	public String updateArticle() {
		
		String message = "Article Updated!";
	
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String updateArticle = "UPDATE "+mssqlConnection.getDatabase()+".dbo.articles SET " +
					"articleTitle=IsNull(NullIf(?, ''), articleTitle), articleContent=IsNull(NullIf(?, ''), articleContent),"+
					"articleImage=IsNull(NullIf(?, ''), articleImage), articleCategoryID=IsNull(?, articleCategoryID) "+
					" WHERE articleID=?";
			
			PreparedStatement ps = connection.prepareStatement(updateArticle);
			
			ps.setString(1,  ArticleTitle);
			ps.setString(2,  ArticleContent);
			ps.setInt(4, ArticleCategoryID);
			ps.setInt(5, ArticleID);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	public String addArticle() {
		
		String message = "Article Updated!";
	
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addArticle = "INSERT "+mssqlConnection.getDatabase()+".dbo.articles " +
					"(articleAuthorID, articleTitle, articleContent, articleCreateDate, articleVisible, articleCategoryID, articleImage) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addArticle);
			
			Date date = new Date();
			
			ps.setInt(1, ArticleAuthorID);
			ps.setString(2,  ArticleTitle);
			ps.setString(3,  ArticleContent);
			ps.setTimestamp(4,  new java.sql.Timestamp(date.getTime()));
			ps.setInt(5,  ArticleVisible);
			ps.setInt(6,  ArticleCategoryID);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	public JSONObject getArticle() {
			
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String articlesQuery = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.articles WITH (NOLOCK) " +
				"WHERE articleID = "+ArticleID+"";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		
		return query.getQuery();
	}
	//GETTERS AND SETTERS

	public int getArticleID() {
		return ArticleID;
	}

	public void setArticleID(int articleID) {
		this.ArticleID = articleID;
	}

	public int getArticleAuthorID() {
		return ArticleAuthorID;
	}

	public void setArticleAuthorID(int articleAuthorID) {
		this.ArticleAuthorID = articleAuthorID;
	}

	public String getArticleTitle() {
		return ArticleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.ArticleTitle = articleTitle;
	}

	public String getArticleContent() {
		return ArticleContent;
	}

	public void setArticleContent(String articleContent) {
		this.ArticleContent = articleContent;
	}

	public String getArticleCreateDate() {
		return ArticleCreateDate;
	}

	public void setArticleCreateDate(String articleCreateDate) {
		this.ArticleCreateDate = articleCreateDate;
	}

	public int getArticleVisible() {
		return ArticleVisible;
	}

	public void setArticleVisible(int articleVisible) {
		this.ArticleVisible = articleVisible;
	}
	
	public int getArticleLikes() {
		return ArticleLikes;
	}

	public void setArticleLikes(int articleLikes) {
		this.ArticleLikes = articleLikes;
	}

	public int getArticleCategoryID() {
		return ArticleCategoryID;
	}

	public void setArticleCategoryID(int articleCategoryID) {
		ArticleCategoryID = articleCategoryID;
	}

	public String getArticleThumbnail() {
		return ArticleThumbnail;
	}

	public void setArticleThumbnail(String articleThumbnail) {
		ArticleThumbnail = articleThumbnail;
	}
	
	
}
