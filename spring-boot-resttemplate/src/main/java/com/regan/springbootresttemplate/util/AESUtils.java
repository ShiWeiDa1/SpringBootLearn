package com.regan.springbootresttemplate.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

import java.util.Arrays;

/**
 *@className: AESUtils
 *@description:
 *@author: weida.shi
 *@date: 2020/5/15 20:30
 *@version: V1.0
 **/
public class AESUtils {

    public static void main(String[] args) {
        encryptionByAES();
    }

    private static void encryptionByAES() {
        AES aes = SecureUtil.aes();
        System.out.println(Arrays.toString(aes.encrypt("epic#yxzh1997")));
    }
}