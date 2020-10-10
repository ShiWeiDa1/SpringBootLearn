package com.swd.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 在DefaultErrorAttributes封装的错误信息上添加自定义的错误信息
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

        // 在错误信息中添加自己的信息
        map.put("company", "swd");

        // 获取额外的异常处理器的内容
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);

        map.put("ext", ext);

        return map;
    }

}
