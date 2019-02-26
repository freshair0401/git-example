package com.example.demo.service;

import com.example.demo.pojo.AcXqcFreezing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class ActiveTopicProducer {
	
    @Autowired 
    private JmsMessagingTemplate jmsTemplate;
    
    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
    	System.out.println("------------------------------------------------------------------");
        jmsTemplate.convertAndSend(destination, message);
    }

    // 发送消息，destination是发送到的队列，message是待发送的实体
    public void sendObjectMessage(Destination destination, AcXqcFreezing freezing){
        jmsTemplate.convertAndSend(destination, freezing);
    }
}
