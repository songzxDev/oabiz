package cn.songzx.oabiz.controller;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.songzx.oabiz.activemq.service.ActiveMQConsumerServiceI;
import cn.songzx.oabiz.activemq.service.ActiveMQProducerServiceI;

@Controller
@RequestMapping(value = "/activemq")
public class ActiveMQController {

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

	@RequestMapping(value = "/sendMessageToActbpm")
	public String sendMessageToActbpm() {
		try {
			Connection connection = jmsTemplate.getConnectionFactory().createConnection();
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("yonyou.actbpm");
			activeMQProducerService.sendMessage(destination, "");
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
