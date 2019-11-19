package com.bilin.controller.webhook;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/webHook")
public class WebHookController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebHookController.class);
	
	@RequestMapping(value ="/send", method = RequestMethod.POST)
	@ResponseBody
	public String send(HttpServletRequest request) {
		String a = ReadAsChars(request);
		logger.warn("发送告警：request={}", a);
		JSONObject jsonObj = request2Json(request);
		System.out.println(jsonObj.toJSONString());
		return "ok";
	}

	
	

    // 字符串读取
    // 方法一
	public static String ReadAsChars(HttpServletRequest request) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try {
			br = request.getReader();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();

	}
    
	

    /**
     * 将request参数值转为json
     */
 
 public static JSONObject request2Json(HttpServletRequest request) {
        JSONObject requestJson = new JSONObject();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] pv = request.getParameterValues(paramName);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pv.length; i++) {
                if (pv[i].length() > 0) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(pv[i]);
                }
            }
            requestJson.put(paramName, sb.toString());
        }
        return requestJson;
    }
	
	public static Map getParamMap(ServletRequest request) {
		Map paramMap = new HashMap();

		Map<String, String[]> defaultParamMap = request.getParameterMap();
		Iterator<Map.Entry<String, String[]>> it = defaultParamMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String[]> entry = (Map.Entry) it.next();

			String[] values = (String[]) entry.getValue();
			if ((values == null) || (values.length == 0)) {
				paramMap.put(entry.getKey(), null);
			} else if (values.length == 1) {
				if (StringUtils.isEmpty(values[0])) {
					String mayBeJson = (String) entry.getKey();
					try {
						Map tempMap = (Map) JSON.parseObject(mayBeJson, Map.class);
						if ((tempMap != null) && (tempMap.size() > 0)) {
							paramMap.putAll(tempMap);
						} else {
							paramMap.put(entry.getKey(), values[0]);
						}
					} catch (Exception e) {
						paramMap.put(entry.getKey(), values[0]);
					}
				} else {
					paramMap.put(entry.getKey(), values[0]);
				}
			} else {
				paramMap.put(entry.getKey(), values[0]);
			}
		}

		return paramMap;
	}
	
}
