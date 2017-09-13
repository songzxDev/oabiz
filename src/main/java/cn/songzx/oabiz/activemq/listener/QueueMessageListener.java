/**
* @Title: QueueMessageListener.java
* @Package cn.yonyou.actbpm.activemq.listener
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com
* @date 2017年7月4日 下午5:39:53
* @version V1.0
*/
package cn.songzx.oabiz.activemq.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * @ClassName: QueueMessageListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年7月4日 下午5:39:53
 *
 */
public class QueueMessageListener implements MessageListener {
	private static Logger LOGGER = Logger.getLogger(QueueMessageListener.class);

	/**
	 * @Date: 2017年7月4日下午5:40:40
	 * @Title: onMessage
	 * @Description: TODO(当收到消息后，自动调用该方法)
	 * @param message
	 * @return 返回值类型
	 */
	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			LOGGER.debug("已接收到消息，延迟处理中......");
			Thread.sleep(20000);
			LOGGER.debug("开始处理");
			LOGGER.debug(this.getClass().getSimpleName() + "监听到了文本消息：\t" + tm.getText());
			// do something ...
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
