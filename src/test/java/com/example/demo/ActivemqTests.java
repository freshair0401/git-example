package com.example.demo;

import com.example.demo.pojo.AcXqcFreezing;
import com.example.demo.service.ActiveTopicProducer;

import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqTests {

    @Autowired
    private ActiveTopicProducer producer;

    @Test
    public void contextLoads() {
    	
        // 虚拟主题
        Destination destination = new ActiveMQTopic("VirtualTopic.eventA");
        
        for(int i=0; i < 10; i++){

        	AcXqcFreezing freezing = new AcXqcFreezing(i + "", "michelle", "", "", BigDecimal.ONE, "",
                    "", "", "", "");
            producer.sendObjectMessage(destination, freezing);
        }
//    	ActiveMQSchedul ams = new ActiveMQSchedul();
//    	ams.sendMessage();
    }
}

