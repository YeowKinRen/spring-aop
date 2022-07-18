package com.yeow.spring.springaop.data;

import org.springframework.stereotype.Repository;

import com.yeow.spring.springaop.aspect.TrackTime;



/**
 * 
 * @author Yeow Kin Ren
 *
 */
@Repository
public class UserDao {
	
	@TrackTime
	public String retrieveUser(){
		return "User1";
	}

}