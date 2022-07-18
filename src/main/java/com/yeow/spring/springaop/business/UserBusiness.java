package com.yeow.spring.springaop.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeow.spring.springaop.aspect.TrackTime;
import com.yeow.spring.springaop.data.UserDao;

/**
 * 
 * @author Yeow Kin Ren
 *
 */
@Service
public class UserBusiness {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDao;
	
	@TrackTime
	public String calculateSomething(){
		//Business Logic
		String value = userDao.retrieveUser();
		logger.info("In Business - {}", value);
		return value;
	}
}