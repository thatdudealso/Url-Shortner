package com.brilliant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepo extends CrudRepository<ShortenUrl, Integer>{
	//default  String getfull(String randomChar) {
		
//	}

}
