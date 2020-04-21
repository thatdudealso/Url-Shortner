package com.brilliant;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShorterRestController {
	
	@Autowired
	UrlRepo url;
	
	private Map<String, ShortenUrl> shortenUrlList = new HashMap<>();

	@RequestMapping(value="/shortenurl", method=RequestMethod.POST)
	public ResponseEntity<Object> getShortenUrl(@RequestBody ShortenUrl shortenUrl) throws MalformedURLException {
		String randomChar = getRandomChars();
		setShortUrl(randomChar,shortenUrl);
		url.save(shortenUrl);
		return new ResponseEntity<Object>(shortenUrl, HttpStatus.OK);
	}
	
	private void setShortUrl(String randomChar,ShortenUrl shortenUrl) throws MalformedURLException{
		shortenUrl.setShort_url("http://localhost:8080/s/"+randomChar);
	}
	
	@RequestMapping(value="/s/{randomstring}",method = RequestMethod.GET)
	public void getFullUrl(HttpServletResponse response,@PathVariable("randomstring") String randomString) throws IOException {
	System.out.println("Printing");
		response.sendRedirect("http://localhost:8080/s/"+randomString);

	}
	//public String getFullURL(String randomchar) {
//		  String url="http://localhost:8080/s/"+randomchar;
//		  String sql="Select longurl from URL where shorturl='"+url+"'";
//		  //return jdbc.queryForObject(sql, String.class);
	// }

	private String getRandomChars() {
		String randomStr = "";
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++)
			randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
		return randomStr;

	}

}
