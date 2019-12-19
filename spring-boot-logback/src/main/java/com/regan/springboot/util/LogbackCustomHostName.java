package com.regan.springboot.util;

import ch.qos.logback.core.PropertyDefinerBase;
import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *@className: LogbackCustomHostName
 *@description: 获取记录日志主机名称
 *@author: weida.shi
 *@date: 2019/12/13 14:11
 *@version: V1.0
 **/
public class LogbackCustomHostName extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        try {

            final InetAddress netAddress = getInetAddress();
            // 获取主机名 linux多网卡无法根据环境指定具体网卡，此方法只能在windows下使用
            String hostName = getHostName(netAddress);
            if (StringUtils.isNotBlank(hostName) && hostName.length() >= 15) {
                hostName = hostName.substring(hostName.length() - 15);
            }
            return hostName;
        } catch (Exception e) {
            return "unknown_exception";
        }
    }

    public static InetAddress getInetAddress() {

        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHostName(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String ip = netAddress.getHostName();
        return ip;
    }

}