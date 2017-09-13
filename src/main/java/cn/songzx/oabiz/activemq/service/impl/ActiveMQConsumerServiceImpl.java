/**
* @Title: ActiveMQConsumerServiceImpl.java
* @Package cn.yonyou.actbpm.activemq.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com
* @date 2017年7月4日 下午7:21:36
* @version V1.0
*/
package cn.songzx.oabiz.activemq.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import cn.songzx.oabiz.activemq.service.ActiveMQConsumerServiceI;

/**
 * @ClassName: ActiveMQConsumerServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年7月4日 下午7:21:36
 *
 */
@Service(value = "activeMQConsumerService")
public class ActiveMQConsumerServiceImpl implements ActiveMQConsumerServiceI {
	private static Logger LOGGER = Logger.getLogger(ActiveMQConsumerServiceImpl.class);

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
	 * @Date: 2017年7月4日下午7:21:36
	 * @Title: receive
	 * @Description: TODO(接收消息)
	 * @param destination
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public TextMessage receive(Destination destination) throws Exception {
		TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
		try {
			LOGGER.debug("从队列" + destination.toString() + "收到了消息：\t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

		return tm;
	}

}
