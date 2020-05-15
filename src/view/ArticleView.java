package view;

import model.Article;

public class ArticleView {
	
	private Article article;
	
	public ArticleView() {
		
	}
	
	public String articleView() {
		return  "      <div class=\"col-lg-12\">\r\n" + 
				"      \r\n" + 
				"        <img id=\"articleImage\" class=\"img-fluid rounded\" src=\"uploads/images/"+article.getArticleThumbnail()+"\" alt=\"\" />\r\n" + 
				"\r\n" + 
				"        <!-- Title -->\r\n" + 
				"        <h1 id=\"articletitle\" class=\"mt-4\">"+article.getArticleTitle()+"</h1>\r\n" + 
				"        \r\n" + 
				"\r\n" + 
				"        <!-- Author -->\r\n" + 
				"        <p class=\"lead\">\r\n" + 
				"          by\r\n" + 
				"          <a id=\"articleAuthorID\" href=\"#\">Austin Stephens</a>\r\n" + 
				"        </p>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"		<div class=\"row ml-1\">\r\n" + 
				"        	<!-- Date/Time -->\r\n" + 
				"        	<p>Posted on&nbsp;</p> <p id=\"articleCreateDate\"> "+article.getArticleCreateDate()+"</p>\r\n" + 
				"        	\r\n" + 
				"        	<img id=\"articleBookmark\" src=\"uploads/images/bookmark.svg\" title=\"Bookmark\" class=\"ml-auto\" onClick=\"\" />\r\n" + 
				"		</div>\r\n" + 
				"       \r\n" + 
				"\r\n" + 
				"        <hr>\r\n" + 
				"\r\n" + 
				"        <!-- Post Content -->\r\n" + 
				"        <p id=\"articleContent\" class=\"lead\">"+article.getArticleContent()+"</p>\r\n" + 
				"        <hr>\r\n" + 
				"\r\n" + 
				"      </div>";
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}
