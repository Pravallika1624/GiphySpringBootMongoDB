package com.demo.Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MyNote 
{
	@Id
	private String id;
	private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "MyNote [id=" + id + ", url=" + url + "]";
	}
	public MyNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyNote(String id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
	
	

}
