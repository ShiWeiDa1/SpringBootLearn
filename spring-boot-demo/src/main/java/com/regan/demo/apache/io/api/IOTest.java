package com.regan.demo.apache.io.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 *@className: IOTest
 *@description:
 *@author: Regan
 *@date: 2021/1/26 9:36
 *@version: V1.0
 **/
public class IOTest {
    public static final String BATH_DOWNLOAD_TMP = "/tmp/dm/";

    @Test
    public void getTempDirectoryTest() {
        File tempDirectory = FileUtils.getTempDirectory();
        // C:\Users\swd\AppData\Local\Temp
        System.out.println(tempDirectory.getPath());
    }

    @Test
    public void writeCollectionToFileTest() throws IOException {
        List<String> collect = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            String s = UUID.randomUUID().toString();
            collect.add(s);
        }
        File tempDirectory = FileUtils.getTempDirectory();
        String path = tempDirectory.getPath();
        String filePath = BATH_DOWNLOAD_TMP + "//swd_" + UUID.randomUUID().toString() + ".txt";
        System.out.println(filePath);
        // 如果目录不存在则新建,覆盖,会校验权限
        FileUtils.writeLines(Paths.get(filePath).toFile(), collect);
    }

    @Test
    public void getFileNamePrefix() {
        // TODO: 2021/1/26 理解该方法
        String prefix = FilenameUtils.getPrefix("afasf:AYRTD:afdsafdsa/fdsafsdewf/df3gfds");
        System.out.println(prefix);
        String fileName = "awe.txt";
        String fileSuffix = StringUtils.substringAfterLast(fileName, ".");
        String filePrefix = StringUtils.substringBeforeLast(fileName, ".");
        System.out.println(filePrefix);
        System.out.println(fileSuffix);
    }
}
