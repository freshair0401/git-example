package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;

public class ActiveConst {
	@Value("${activemq.main-thread.topic-order}")
	public static String orderTopic;
	
	@Value("${activemq.main-thread.topic-fund}")
	public String fundTopic;
}
