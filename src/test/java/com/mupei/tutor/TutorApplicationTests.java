package com.mupei.tutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void contextLoads() {
//		System.out.println();
		
		//日志级别由低到高trace<debug<info<warn<error
		//可以调整输出的日志级别，日志就只是在这个级别以后的高级别生效
		logger.trace("trace...");
		logger.debug("debug...");
		//SpringBoot的默认级别（Root级别）是info
		logger.info("info...");
		logger.warn("warn...");
		logger.error("error...");
		
	}

}
