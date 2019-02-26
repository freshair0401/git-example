package com.example.demo.schedul;

import com.example.demo.pojo.AcXqcFreezing;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
@EnableScheduling
public class ActiveMQSchedul {

	@Autowired 
    private JmsMessagingTemplate jmsTemplate;

    // 发送消息
    @Scheduled(fixedDelay = 5000)
    public void sendMessage(){
        Destination destination = new ActiveMQTopic("VirtualTopic.eventA");
        AcXqcFreezing freezing = new AcXqcFreezing();
        for(int i=0; i<5; i++){
            freezing.setBizNo(i + "");
            jmsTemplate.convertAndSend(destination, freezing);
        }
    }
}
