package com.yeow.spring.springaop.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeow.spring.springaop.data.InfoDao;

/**
 * 
 * @author Yeow Kin Ren
 *
 */
@Service
public class InfoBusiness {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private InfoDao infoDao;
	
	public String calculateSomething(){
		//Business Logic
		String value =  infoDao.retrieveInfo();
		logger.info("In Business - {}", value);
		return value;
	}
}