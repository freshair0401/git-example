package com.example.demo.config;

import javax.jms.DeliveryMode;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMQConfig {
	
	@Value("${spring.activemq.user}")
	private String userName;
	
	@Value("${spring.activemq.password}")
	private String password;
	
	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Bean
	public RedeliveryPolicy redeliveryPolicy(){
        RedeliveryPolicy  redeliveryPolicy=   new RedeliveryPolicy();
        //是否在每次尝试重新发送失败后,增长这个等待时间
        redeliveryPolicy.setUseExponentialBackOff(true);
        //重发次数,默认为6次   这里设置为10次
        redeliveryPolicy.setMaximumRedeliveries(10);
        //重发时间间隔,默认为1秒
        redeliveryPolicy.setInitialRedeliveryDelay(1);
        //第一次失败后重新发送之前等待500毫秒,第二次失败再等待500 * 2毫秒,这里的2就是value
        redeliveryPolicy.setBackOffMultiplier(2);
        //是否避免消息碰撞
        redeliveryPolicy.setUseCollisionAvoidance(false);
        //设置重发最大拖延时间-1 表示没有拖延只有UseExponentialBackOff(true)为true时生效
        redeliveryPolicy.setMaximumRedeliveryDelay(-1);
        return redeliveryPolicy;
	}
	
    @Bean(name = "connectionFactory")
    public ActiveMQConnectionFactory activeMQConnectionFactory (RedeliveryPolicy redeliveryPolicy){  
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        activeMQConnectionFactory.setTrustAllPackages(true); // 传送对象时，设置白名单
        return activeMQConnectionFactory;
    }
    /*
    @Bean
    public PooledConnectionFactory pooledConnectionFactory (ActiveMQConnectionFactory activeMQConnectionFactory){  
    	PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
    	pooledConnectionFactory.setConnectionFactory(activeMQConnectionFactory);
    	pooledConnectionFactory.setMaxConnections(100);
        return pooledConnectionFactory;
    }
	*/
    @Bean(name = "jmsTemplate")
    public JmsTemplate jmsTemplate(@Qualifier("connectionFactory") ActiveMQConnectionFactory activeMQConnectionFactory){
    	JmsTemplate jmsTemplate=new JmsTemplate();
    	// jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);//进行持久化配置 1表示非持久化，2表示持久化
    	jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
    	jmsTemplate.setSessionAcknowledgeMode(ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);//客户端签收模式
    	return jmsTemplate;
    }
    
    @Bean(name = "jmsMessagingTemplate")
    public JmsMessagingTemplate jmsMessagingTemplate(@Qualifier("connectionFactory") ActiveMQConnectionFactory activeMQConnectionFactory){
        JmsMessagingTemplate template = new JmsMessagingTemplate(activeMQConnectionFactory);
        return template;
    }
    
    //定义一个消息监听器连接工厂，这里定义的是点对点模式的监听器连接工厂
    @Bean(name = "jmsVirtualTopicListener")
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory factory =  new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        //设置连接数
        // factory.setConcurrency("1-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        // factory.setPubSubDomain(true);
        factory.setSessionAcknowledgeMode(ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);
        return factory;
    }
    
	/**
	 * 第二套配置信息
	 */
    
    /**
     * 配置用于异步发送的非持久化JmsTemplate
     */ 
//    @Autowired
//    @Bean
//    @Primary
//    public JmsTemplate asynJmsTemplate(PooledConnectionFactory pooledConnectionFactory) {
//        JmsTemplate template = new JmsTemplate(pooledConnectionFactory);
//        template.setExplicitQosEnabled(true);
//        template.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//        return template;
//    }
//
//    /**
//     * 配置用于同步发送的持久化JmsTemplate
//     */  
//    @Autowired
//    @Bean
//    public JmsTemplate synJmsTemplate(PooledConnectionFactory pooledConnectionFactory) {
//        JmsTemplate template = new JmsTemplate(pooledConnectionFactory);
//        return template;
//    }
//
////如果对于SpringBoot自动生成的PooledConnectionFactory需要调优，可以自己生PooledConnectionFactory调优参数
//    private PooledConnectionFactory getPooledConnectionFactory(String userName,String password,String brokerURL) {
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(userName,password,brokerURL);
//        ActiveMQPrefetchPolicy activeMQPrefetchPolicy = new ActiveMQPrefetchPolicy();
//        activeMQConnectionFactory.setPrefetchPolicy(activeMQPrefetchPolicy);
//        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
//        pooledConnectionFactory.setConnectionFactory(activeMQPrefetchPolicy);
//        pooledConnectionFactory.setMaxConnections(5);
//        return pooledConnectionFactory;
//    }
}
