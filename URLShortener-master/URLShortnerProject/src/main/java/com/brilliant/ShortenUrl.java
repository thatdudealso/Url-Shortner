package com.brilliant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShortenUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int Urlid; //makes the colums through here by using those vars
	private String full_url;
	private String short_url;
	public String getFull_url() {
		return full_url;
	}
	public void setFull_url(String full_url) {
		this.full_url = full_url;
	}
	public String getShort_url() {
		return short_url;
	}
	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
	
	
}
