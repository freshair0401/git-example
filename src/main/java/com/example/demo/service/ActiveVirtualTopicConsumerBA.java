package com.example.demo.service;

import com.example.demo.pojo.AcXqcFreezing;
import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Component
public class ActiveVirtualTopicConsumerBA {
    // 消费消息
    @JmsListener(destination = "Consumer.B.VirtualTopic.eventA")
    public void receiveQueue(ObjectMessage text) throws JMSException {
        AcXqcFreezing freezing = new AcXqcFreezing();
        BeanUtils.copyProperties(text.getObject(), freezing);
        System.out.println("ConsumerB组A收到的报文为:"+freezing.toString());
    }
}
