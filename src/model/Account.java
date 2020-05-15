package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Account {

	public int accountID;
	public String firstName;
	public String lastName;
	public String email;
	public String username;
	public String password;
	public int active;
	public Date userCreateDate;
	public String permissionLevel;
	public char gender;
	public ArrayList<Article> bookmarkedArticles;
	public ArrayList<Article> likedArticles;
	public ArrayList<Address> addresses;
	
	public Account() {
		bookmarkedArticles = new ArrayList<Article>();
		likedArticles = new ArrayList<Article>();
		addresses = new ArrayList<Address>();
	}
	
	public JSONArray listAccounts() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		String articlesQuery = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK) ";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		return query.lstQuery();
	}
	
	public String updateAccount() {
		
		String message = "User Updated!";
	
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String updateArticle = "UPDATE "+mssqlConnection.getDatabase()+".dbo.users SET " +
					"firstName=IsNull(NullIf(?, ''), firstName), lastName=IsNull(NullIf(?, ''), lastName), "+
					"email=IsNull(NullIf(?, ''), email), username=IsNull(NullIf(?, ''), username), password=IsNull(NullIf(?, ''), password), "
					+ "active=IsNull(?, active) "+
					" WHERE userID=?";
			
			PreparedStatement ps = connection.prepareStatement(updateArticle);
			
			ps.setString(1,  firstName);
			ps.setString(2,  lastName);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setInt(6, active);
			ps.setInt(7, accountID);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	public String addUser() {
		
		String message = "User Updated!";
	
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addArticle = "INSERT "+mssqlConnection.getDatabase()+".dbo.users " +
			"(firstName, lastName, email, username, password, active, userCreateDate) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addArticle);
			Date date = new Date();
			
			ps.setString(1, firstName);
			ps.setString(2,  lastName);
			ps.setString(3,  email);
			ps.setString(4,  username);
			ps.setString(5,  password);
			ps.setInt(6, active);
			ps.setTimestamp(7,  new java.sql.Timestamp(date.getTime()));
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	public JSONObject getAccount() {
			
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String articlesQuery = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK) " +
				"WHERE accountID = "+accountID+"";
		
		SQLQuery query = new SQLQuery();
		query.setSqlString(articlesQuery);
		
		
		return query.getQuery();
	}
	
	public JSONObject authenticate() {
		
		JSONObject result = new JSONObject();
		String message = "Username or Password is incorrect.";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String articlesQuery = "SELECT * " +
			  		"FROM "+mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK) " +
					"WHERE username = '"+username.replace("'", "''")+"'";
			
			java.sql.Statement stmt = connection.createStatement(
		 			java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, 
		 			java.sql.ResultSet.CONCUR_READ_ONLY);
			
			ResultSet listResult = stmt.executeQuery(articlesQuery);
			
			while(listResult.next()) {
				String dbPassword = listResult.getString("password");
				String dbActive = listResult.getString("active");
				int dbUserID = listResult.getInt("userID");
				
				result.put("userID", dbUserID);
				
				if(dbPassword.equals(password)) {
					if(dbActive.equals("0")) {
						message = "This user is currently deactivated.";	
					} else {
						message = "success";
					}
				}
			}
			
			result.put("message", message);
			
			//Close Connections
            try { if (listResult!= null) listResult.close(); } catch (Exception e) {};
            try { if (stmt!= null) stmt.close(); } catch (Exception e) {};
            try { if (connection!= null) connection.close(); } catch (Exception e) {};
		} catch (Exception e) {	}
		
		return result;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	public String getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public ArrayList<Article> getBookmarkedArticles() {
		return bookmarkedArticles;
	}

	public void setBookmarkedArticles(ArrayList<Article> bookmarkedArticles) {
		this.bookmarkedArticles = bookmarkedArticles;
	}

	public ArrayList<Article> getLikedArticles() {
		return likedArticles;
	}

	public void setLikedArticles(ArrayList<Article> likedArticles) {
		this.likedArticles = likedArticles;
	}
	
	
	
	
}