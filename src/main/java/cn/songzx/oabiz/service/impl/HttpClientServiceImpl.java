package cn.songzx.oabiz.service.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.songzx.oabiz.service.HttpClientServiceI;

@Service(value = "httpClientService")
public class HttpClientServiceImpl implements HttpClientServiceI {

	private static Logger LOGGER = Logger.getLogger(HttpClientServiceImpl.class);

	/**
	 * 
	 * @Date: 2017年7月6日下午1:58:45
	 * @Title: sendHttpGet
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public String sendHttpGet(String url, Map<String, Object> params) throws Exception {
		// 实例化httpclient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 实例化get方法
		HttpGet httpget = new HttpGet(url);
		// 请求结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 执行get方法
			response = httpclient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
				LOGGER.debug(content);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 
	 * @Date: 2017年7月6日下午1:58:52
	 * @Title: sendHttpPost
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public String sendHttpPost(String url, Map<String, Object> params) throws Exception {
		// 实例化httpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 实例化post方法
		HttpPost httpPost = new HttpPost(url);
		// 结果
		CloseableHttpResponse response = null;
		String content = "";
		
		String encoderJson = JSON.toJSONString(params);
		httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
		// 将JSON 进行 UTF-8 编码,以便传输中文
		StringEntity entity = new StringEntity(encoderJson, "UTF-8");
		entity.setContentType(CONTENT_TYPE_TEXT_JSON);
		entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
		httpPost.setEntity(entity);
		try {
			// 执行post方法
			response = httpclient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "UTF-8");
				LOGGER.debug(content);
			}
		}
		return content;
	}

}
