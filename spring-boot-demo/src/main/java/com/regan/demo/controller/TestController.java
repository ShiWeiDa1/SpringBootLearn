package com.regan.demo.controller;

import cn.hutool.core.io.FileUtil;
import com.regan.demo.entity.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *@className: TestController
 *@description:
 *@author: weida.shi
 *@date: 2020/8/14 22:57
 *@version: V1.0
 **/
@Controller
public class TestController {

    @RequestMapping(value = "/GetAreaCodes", method = RequestMethod.GET)
    @ResponseBody
    public String getAreaCode(UserDTO user) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            list.add(UUID.randomUUID().toString());
        }
        String path = "/data/aada.txt";
        FileUtil.writeUtf8Lines(list, path);
        InputStream inputStream = FileUtil.getInputStream(path);
        inputStream.close();
        System.out.println(FileUtil.del(path));
        return null;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            list.add(UUID.randomUUID().toString());
        }
        String path = "/data/aada.txt";
        // FileUtil.writeUtf8Lines(list,path);
        // ByteArrayInputStream byteArrayInputStream = new
        // ByteArrayInputStream(new byte[] { 's' });
        // FileUtil.writeUtf8Lines(list, path);
        // BufferedInputStream bufferedInputStream =
        // FileUtil.getInputStream(path);
        // MultipartFile file = new MockMultipartFile("d",null,
        // MediaType.APPLICATION_OCTET_STREAM_VALUE,bufferedInputStream);
        // InputStream inputStream = file.getInputStream();
        // FileUtil.writeFromStream(inputStream,"d:\\aad.txt");
        System.out.println(FileUtil.del(path));

        // FileOutputStream fileOutputStream = new FileOutputStream("/aa.txt");
        // writeToLocal("d:\\aa.txt", byteArrayInputStream);
    }

    private static void writeToLocal(String destination, InputStream input) throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        downloadFile.close();
        input.close();
    }
}