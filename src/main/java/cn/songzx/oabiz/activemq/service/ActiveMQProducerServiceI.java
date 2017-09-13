/**
* @Title: ActiveMQProducerServiceI.java
* @Package cn.yonyou.actbpm.activemq.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com
* @date 2017年7月4日 下午7:09:24
* @version V1.0
*/
package cn.songzx.oabiz.activemq.service;

import javax.jms.Destination;

/**
 * @ClassName: ActiveMQProducerServiceI
 * @Description: TODO(消息生产者)
 * @author Songzx songzx_2326@163.com
 * @date 2017年7月4日 下午7:09:24
 *
 */
public interface ActiveMQProducerServiceI {

	/**
	 *
	 * @Date: 2017年7月4日下午7:13:27
	 * @Title: sendMessage
	 * @Description: TODO(向默认队列发送消息)
	 * @param msg
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public void sendMessage(final String msg) throws Exception;

	/**
	 *
	 * @Date: 2017年7月4日下午7:12:38
	 * @Title: sendMessage
	 * @Description: TODO(向指定队列发送消息)
	 * @param destination
	 * @param msg
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public void sendMessage(Destination destination, final String msg) throws Exception;
}
