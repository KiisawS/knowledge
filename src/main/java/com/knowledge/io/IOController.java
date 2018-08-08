package com.knowledge.io;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/***
 * @ClassName IOController
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/8/1 10:55
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@RestController
@RequestMapping("/iocs")
@Slf4j
public class IOController {

    @PostMapping("/callInterface")
    public String callCommonInterface(@RequestParam String url,
                                      @RequestHeader("Content-Type") String contentType,
                                      HttpServletRequest request) {
        getParam(request);
        getValFromBody(request);
        return null;
    }

    private static final String ENCODING_FILTER_FILTERED = "EncodingFilter.FILTERED";

    private static final String SPRING_KEY = "org.springframework.";

    //过滤掉框架产生的参数
    private boolean isExcludeParam(String paramKey) {
        if (ENCODING_FILTER_FILTERED.equals(paramKey)) {
            return true;
        }
        if (paramKey.startsWith(SPRING_KEY)) {
            return true;
        }
        return false;
    }

    private Map<String, String> getParam(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>(16);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String val = request.getHeader(key);
            if (val == null) {
                continue;
            }
            params.put(key, val);
        }
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            if (isExcludeParam(key)) {
                continue;
            }
            params.put(key, request.getAttribute(key).toString());
        }
        Enumeration<String> parameterNames =  request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String val = request.getParameter(key);
            if (val == null) {
                continue;
            }
            params.put(key, val);
        }
        log.info("参数{}", params);
        return params;
    }

    private String getValFromBody(HttpServletRequest request) {
        try {
            StringBuilder sb = new StringBuilder();
            InputStream is = request.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            isr.close();
            is.close();

            log.info("参数{}", sb.toString());
            return sb.toString();
        } catch (IOException e) {
            //
            log.error("", e);
        }
        return null;
    }
}
