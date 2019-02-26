package com.example.demo.service;

import com.example.demo.pojo.AcXqcFreezing;

import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class ActiveVirtualTopicConsumerAA {
	
    // q消费消息
    @JmsListener(destination = "Consumer.${activemq.main-thread.topic-group-order}.VirtualTopic.${activemq.main-thread.topic-order}")
    public void receiveQueue(ObjectMessage text, Session session) throws JMSException {
    	try {
	        AcXqcFreezing freezing = new AcXqcFreezing();
	      BeanUtils.copyProperties(text.getObject(), freezing);
	        System.out.println("ConsumerA组A收到的报文为:"+freezing.toString());
//	        Thread.sleep(10000);
//	        text.acknowledge(); // 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
        } catch (Exception e) {
        	session.recover(); // 此不可省略 重发信息使用
        }
    }
}
