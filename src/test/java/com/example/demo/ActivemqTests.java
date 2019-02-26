package com.example.demo;

import com.example.demo.config.TopicConfig;
import com.example.demo.pojo.AcXqcFreezing;
import com.example.demo.service.ActiveTopicProducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import javax.jms.JMSException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqTests {

    @Autowired
    private ActiveTopicProducer producer;
    
    @Autowired
    private TopicConfig topicConfig;

    @Test
    public void contextLoads() throws InterruptedException, JMSException {
    	
        // 虚拟主题order
        for(int i=0; i < 10; i++){

        	AcXqcFreezing freezing = new AcXqcFreezing(i + "", "michelle", "", "", BigDecimal.ONE, "",
                    "", "", "", "");
        	System.out.println("发送order消息：" + freezing.toString());
            producer.sendObjectMessage(topicConfig.topicOrder(), freezing);
        }
        
        // 虚拟主题fund
        /*
        for(int i=0; i < 10; i++){

        	AcXqcFreezing freezing = new AcXqcFreezing(i + "", "michelle001", "", "", BigDecimal.ONE, "",
                    "", "", "", "");
            producer.sendObjectMessage(topicConfig.topicFund(), freezing);
        }
        */
        Thread.sleep(10000L);
//    	ActiveMQSchedul ams = new ActiveMQSchedul();
//    	ams.sendMessage();
    }
}

