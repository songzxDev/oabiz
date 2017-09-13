/**
* @Title: ActiveMQConsumerServiceI.java
* @Package cn.yonyou.actbpm.activemq.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com
* @date 2017年7月4日 下午7:10:12
* @version V1.0
*/
package cn.songzx.oabiz.activemq.service;

import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * @ClassName: ActiveMQConsumerServiceI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年7月4日 下午7:10:12
 *
 */
public interface ActiveMQConsumerServiceI {
	/**
	 *
	 * @Date: 2017年7月4日下午7:21:01
	 * @Title: receive
	 * @Description: TODO(接收消息)
	 * @param destination
	 * @return
	 * @throws Exception
	 * @return TextMessage 返回值类型
	 */
	public TextMessage receive(Destination destination) throws Exception;
}
