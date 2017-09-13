package cn.songzx.oabiz.aop;

import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WorkFlowControllerAspect {

	private static Logger LOGGER = Logger.getLogger(WorkFlowControllerAspect.class);

	@Pointcut(value = "execution (* cn.songzx.oabiz.controller.WorkFlowController.*(..))")
	public void pointcut() {

	}

	@SuppressWarnings("unchecked")
	@SuppressAjWarnings({"adviceDidNotMatch"})
	@Before(value = "pointcut()")
	public void validateParams(JoinPoint pjp) throws Throwable {
		LOGGER.debug("方法：【" + pjp.getSignature().getName() + "】执行了参数校验操作！");
		Object[] args = pjp.getArgs();
		if (args[0] instanceof Map) {
			Map<String, Object> params = (Map<String, Object>) args[0];
			if (params == null || params.isEmpty()) {
				throw new Exception("输入参数为空！");
			}
		}

	}
}
