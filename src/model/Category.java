package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.JSONArray;
import org.json.JSONObject;

public class Category {
	
	public int CategoryID;
	public String CategoryNavigation;
	public String CategoryName;
	public String CategoryContent;
	
	public Category() {
		
	}
	
	/*public JSONArray listCategories() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.categories WITH (NOLOCK) " +
				"ORDER BY categoryOrder";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		return query.lstQuery();
	}
	
	public JSONArray listVisibleCategories() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.categories WITH (NOLOCK) " +
				"WHERE categoryVisible = 1 ORDER BY categoryOrder";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		return query.lstQuery();
	}
	
	public JSONArray listCatByNav() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.categories WITH (NOLOCK) " +
				"WHERE categoryVisible = 1  ORDER BY categoryOrder";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		return query.lstQuery();
	}
	
	public JSONObject getCategory() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String articlesQuery = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.categories  WITH (NOLOCK) " +
				"WHERE categoryID = "+CategoryID+"";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		
		return query.getQuery();
	}
	
	public String updateCategory() {
		
		String message = "category Updated!";
	
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String update = "UPDATE "+mssqlConnection.getDatabase()+".dbo.categories SET " +
					"categoryName=IsNull(NullIf(?, ''), categoryName), categoryContent=IsNull(NullIf(?, ''), categoryContent), categoryImage=IsNull(NullIf(?, ''), categoryImage), " +
					"categoryVisible=IsNull(?, categoryVisible), categoryOrder=IsNull(?, categoryOrder), navigationID = IsNull(?, navigationID) " +
					" WHERE categoryID=?";
			
			PreparedStatement ps = connection.prepareStatement(update);
			
			ps.setString(1,  CategoryName);
			ps.setString(2,  CategoryContent);
			ps.setString(3, CategoryNavigation);
			ps.setInt(4, CategoryID);
			
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	public String addCategory() {
		
		String message = "category Added!";
	
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String add = "INSERT "+mssqlConnection.getDatabase()+".dbo.categories " +
					"(navigationID, categoryName, categoryContent, categoryImage, categoryVisible, categoryOrder) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(add);
			
			ps.setInt(1, navigationID);
			ps.setString(2, CategoryName);
			ps.setString(3, categoryContent);
			ps.setString(4, categoryImage);
			ps.setInt(5, categoryVisible);
			ps.setInt(6, categoryOrder);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	public String deleteCategory() {
		
		String message = "category " + CategoryID + " Deleted!";
	
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String delete = "DELETE FROM "+mssqlConnection.getDatabase()+".dbo.categories " +
					"WHERE categoryID = " + CategoryID;
			
			PreparedStatement ps = connection.prepareStatement(delete);
			
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
	}*/
	
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		this.CategoryID = categoryID;
	}
	public String getCategoryNavigation() {
		return CategoryNavigation;
	}
	public void setCategoryNavigation(String navigation) {
		this.CategoryNavigation = navigation;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		this.CategoryName = categoryName;
	}

	public String getCategoryContent() {
		return CategoryContent;
	}

	public void setCategoryContent(String categoryContent) {
		CategoryContent = categoryContent;
	}		
}
