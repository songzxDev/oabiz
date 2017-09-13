package cn.songzx.oabiz.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.songzx.oabiz.service.HttpClientServiceI;

@Controller
@RequestMapping("/workFlow")
public class WorkFlowController {

	private Logger LOGGER = Logger.getLogger(WorkFlowController.class);
	
	private HttpClientServiceI httpClientService;

	public HttpClientServiceI getHttpClientService() {
		return httpClientService;
	}

	@Autowired
	public void setHttpClientService(HttpClientServiceI httpClientService) {
		this.httpClientService = httpClientService;
	}

	@Value(value = "${http.request.workFlow.url}")
	private String url;

	@RequestMapping(value = "/startProcess", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String startProcess(@RequestBody Map<String, Object> params) {
		try {
			LOGGER.debug(url);
			String response = httpClientService.sendHttpPost(url + "workFlow/startProcess", params);
			LOGGER.debug(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
