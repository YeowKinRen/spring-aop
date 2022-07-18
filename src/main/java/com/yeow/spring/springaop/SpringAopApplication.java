package com.yeow.spring.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yeow.spring.springaop.business.InfoBusiness;
import com.yeow.spring.springaop.business.UserBusiness;

/**
 * 
 * @author Yeow Kin Ren
 *
 */
@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserBusiness business1;

	@Autowired
	private InfoBusiness business2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println();
		logger.info(business1.calculateSomething());
		
		System.out.println();
		System.out.println();
		logger.info(business2.calculateSomething());
	}

}
