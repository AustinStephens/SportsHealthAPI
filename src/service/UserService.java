package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserService {
	
	/*public static JSONArray listUsers() {
		
		JSONArray users = new JSONArray();
		
		User user = new User();
		users = user.listUsers();
		
		return users;
	}
	public static JSONObject updateUser(JSONObject input) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			User user = new User();
			user.setUserID(input.getInt("userID"));
			user.setFirstName(input.getString("firstName"));
			user.setLastName(input.getString("lastName"));
			user.setEmail(input.getString("email"));
			user.setUsername(input.getString("username"));
			user.setPassword(input.getString("password"));
			user.setActive(input.getInt("active"));
			
			message = user.updateUser();
			
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getUser(int id) {
		JSONObject UserJSONObj = new JSONObject();
		
		User user = new User();
		user.setUserID(id);
		UserJSONObj = user.getUser();
		
		return UserJSONObj;
	}
	
	public static JSONObject addUser(JSONObject input) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			User user = new User();
			user.setFirstName(input.getString("firstName"));
			user.setLastName(input.getString("lastName"));
			user.setEmail(input.getString("email"));
			user.setUsername(input.getString("username"));
			user.setPassword(input.getString("password"));
			user.setActive(input.getInt("active"));
			
			message = user.addUser();
			
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject authenticate(JSONObject input) {
		
		JSONObject result = new JSONObject();
		
		try {
			User user = new User();
			user.setUsername(input.getString("username"));
			user.setPassword(input.getString("password"));
			
			result = user.authenticate();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}*/

}
