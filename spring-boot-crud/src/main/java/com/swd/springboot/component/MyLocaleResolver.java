package com.swd.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 编写自己的国际化的操作
 */
public class MyLocaleResolver implements LocaleResolver {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 解析区域信息
     * @param request
     * @return locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //从请求的头部信息中获取信息
        String l = request.getParameter("l");
        //System.out.println(l);
        //logger.info(l);
        //获取本机默认的区域信息
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }


        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
