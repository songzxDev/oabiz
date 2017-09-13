package cn.songzx.oabiz.service;

import java.util.Map;

public interface HttpClientServiceI {
	public static final String APPLICATION_JSON = "application/json;charset=UTF-8";

	public static final String CONTENT_TYPE_TEXT_JSON = "text/json;charset=UTF-8";
	/**
	 * 
	 * @Date: 2017年7月6日下午1:54:26
	 * @Title: sendHttpGet
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 * @return String 返回值类型
	 */
	public String sendHttpGet(String url, Map<String, Object> params) throws Exception;

	/**
	 * 
	 * @Date: 2017年7月6日下午1:54:32
	 * @Title: sendHttpPost
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 * @return String 返回值类型
	 */
	public String sendHttpPost(String url, Map<String, Object> params) throws Exception;

}
