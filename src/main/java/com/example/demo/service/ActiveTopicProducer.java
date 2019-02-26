package com.example.demo.service;

import com.example.demo.pojo.AcXqcFreezing;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;

@Service
public class ActiveTopicProducer {
	
    @Autowired 
    @Qualifier("jmsMessagingTemplate")
    private JmsMessagingTemplate jmsMessagingTemplate;
    
    @Autowired 
    @Qualifier("jmsTemplate")
    private JmsTemplate jmsTemplate;
    
    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message) throws JMSException{
    	System.out.println(jmsTemplate.getSessionAcknowledgeMode() + "------------------------------------------------------------------");
    	ActiveMQMessage msg = new ActiveMQMessage();
    	msg.setStringProperty("message", message);
    	// jmsTemplate.convertAndSend(destination, message);
    	jmsTemplate.convertAndSend(destination, msg);
    }

    // 发送消息，destination是发送到的队列，message是待发送的实体
    public void sendObjectMessage(Destination destination, AcXqcFreezing freezing) {
    	try {
	    	System.out.println(jmsTemplate.getSessionAcknowledgeMode() + "-----------------------------------------------------");
	    	jmsMessagingTemplate.convertAndSend(destination, freezing);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
