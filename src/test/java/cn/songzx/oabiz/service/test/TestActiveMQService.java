package cn.songzx.oabiz.service.test;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.songzx.oabiz.activemq.service.ActiveMQConsumerServiceI;
import cn.songzx.oabiz.activemq.service.ActiveMQProducerServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-oabiz.xml", "classpath:spring-activemq.xml",
		"classpath:spring-mvc.xml" })
public class TestActiveMQService {

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	private ActiveMQProducerServiceI activeMQProducerService;

	public ActiveMQProducerServiceI getActiveMQProducerService() {
		return activeMQProducerService;
	}

	@Autowired
	public void setActiveMQProducerService(ActiveMQProducerServiceI activeMQProducerService) {
		this.activeMQProducerService = activeMQProducerService;
	}

	private ActiveMQConsumerServiceI activeMQConsumerService;

	public ActiveMQConsumerServiceI getActiveMQConsumerService() {
		return activeMQConsumerService;
	}

	@Autowired
	public void setActiveMQConsumerService(ActiveMQConsumerServiceI activeMQConsumerService) {
		this.activeMQConsumerService = activeMQConsumerService;
	}
	
	@Test
	public void testSendMessageToActbpm() {
		try {
			Connection connection = jmsTemplate.getConnectionFactory().createConnection();
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("yonyou.actbpm");
			activeMQProducerService.sendMessage(destination, "好吧，恭敬不如从命！");
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
