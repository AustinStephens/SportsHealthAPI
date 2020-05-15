package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Category;

public class CategoryService {
	public static JSONArray listCategories() {
		
		JSONArray results = new JSONArray();
		
		Category category = new Category();
		//results = category.listCategories();
		
		return results;
	}
	
	public static JSONArray listCatByNav() {
		
		JSONArray results = new JSONArray();
		
		Category category = new Category();
		//results = category.listCatByNav();
		
		return results;
	}
	
	public static JSONObject updateCategory(JSONObject input) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			/*Category category = new Category();
			category.setCategoryID(input.getInt("categoryID"));
			category.setNavigationID(input.getInt("navigationID"));	
			category.setCategoryName(input.getString("categoryName"));
			category.setCategoryContent(input.getString("categoryContent"));
			category.setCategoryImage(input.getString("categoryImage"));
			category.setCategoryOrder(input.getInt("categoryOrder"));
			category.setCategoryVisible(input.getInt("categoryVisible"));
			
			message = category.updateCategory();*/
			
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getCategory(int id) {
		
		JSONObject jo = new JSONObject();
		
		Category category = new Category();
		category.setCategoryID(id);
		//jo = category.getCategory();
		
		return jo;
	}
	
	public static JSONObject addCategory(JSONObject input) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			/*Category category = new Category();
			category.setNavigationID(input.getInt("navigationID"));			
			category.setCategoryName(input.getString("categoryName"));
			category.setCategoryContent(input.getString("categoryContent"));
			category.setCategoryImage(input.getString("categoryImage"));
			category.setCategoryVisible(input.getInt("categoryVisible"));
			category.setCategoryOrder(input.getInt("categoryOrder"));
			
			message = category.addCategory();*/
			
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject deleteCategory(JSONObject input) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			Category category = new Category();
			category.setCategoryID(input.getInt("categoryID"));
			
			//message = category.deleteCategory();
			
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
