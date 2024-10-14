package com.activitiesBackend.activitiesBackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {

	    @Id
	    private String post_id;
	    
	    public String getPost_id() {
			return post_id;
		}
		public void setPost_id(String post_id) {
			this.post_id = post_id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		private String title;
	    private String content;

	    
}
