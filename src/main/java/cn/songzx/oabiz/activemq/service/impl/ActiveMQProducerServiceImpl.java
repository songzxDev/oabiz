/**
* @Title: ActiveMQProducerServiceImpl.java
* @Package cn.yonyou.actbpm.activemq.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com
* @date 2017年7月4日 下午7:14:15
* @version V1.0
*/
package cn.songzx.oabiz.activemq.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import cn.songzx.oabiz.activemq.service.ActiveMQProducerServiceI;

/**
 * @ClassName: ActiveMQProducerServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年7月4日 下午7:14:15
 *
 */
@Service(value = "activeMQProducerService")
public class ActiveMQProducerServiceImpl implements ActiveMQProducerServiceI {
	private static Logger LOGGER = Logger.getLogger(ActiveMQProducerServiceImpl.class);

	private JmsTemplate jmsTemplate;

	/**
	 * @return the jmsTemplate
	 */
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	/**
	 * @param jmsTemplate
	 *            the jmsTemplate to set
	 */
	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	/**
	 * @Date: 2017年7月4日下午7:14:15
	 * @Title: sendMessage
	 * @Description: TODO(向默认队列发送消息)
	 * @param msg
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public void sendMessage(final String msg) throws Exception {
		String destination = jmsTemplate.getDefaultDestination().toString();
		LOGGER.debug("向队列" + destination + "发送了消息------------" + msg);
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});

	}

	/**
	 * @Date: 2017年7月4日下午7:14:15
	 * @Title: sendMessage
	 * @Description: TODO(向指定队列发送消息)
	 * @param destination
	 * @param msg
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public void sendMessage(Destination destination, final String msg) throws Exception {
		LOGGER.debug("向队列" + destination.toString() + "发送了消息------------" + msg);
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});

	}

}
