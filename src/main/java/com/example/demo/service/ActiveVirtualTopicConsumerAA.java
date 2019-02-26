package com.example.demo.service;

import com.example.demo.pojo.AcXqcFreezing;
import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Component
public class ActiveVirtualTopicConsumerAA {
    // q消费消息
    @JmsListener(destination = "Consumer.A.VirtualTopic.eventA")
    public void receiveQueue(ObjectMessage text) throws JMSException {
        AcXqcFreezing freezing = new AcXqcFreezing();
        BeanUtils.copyProperties(text.getObject(), freezing);
        System.out.println("ConsumerA组A收到的报文为:"+freezing.toString());
    }
}
