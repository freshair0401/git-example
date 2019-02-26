package com.example.demo.config;

import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

	@Value("VirtualTopic.${activemq.main-thread.topic-order}")
	private String orderTopic;
	
	@Value("VirtualTopic.${activemq.main-thread.topic-fund}")
	private String fundTopic;
	
	@Bean
	public Topic topicOrder() {
	    return new ActiveMQTopic(orderTopic);
	}
	
	@Bean
	public Topic topicFund() {
	    return new ActiveMQTopic(fundTopic);
	}
}
