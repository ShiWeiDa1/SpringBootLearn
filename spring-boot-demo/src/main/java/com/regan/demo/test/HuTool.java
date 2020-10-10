package com.regan.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import com.regan.demo.entity.UserDTO;

/**
 *@className: HuTool
 *@description:
 *@author: weida.shi
 *@date: 2020/8/3 20:07
 *@version: V1.0
 **/
public class HuTool {

    public static void main(String[] args) {

        CsvWriter writer = CsvUtil.getWriter("e:/testWrite.csv", CharsetUtil.CHARSET_GBK);
        // 按行写出
        writer.write(new String[] { "表具体", "表具体", "表具体" },new String[] { "表具体", "表具体", "表具体" });
        List<List<Object>> col = new ArrayList<>();
        String st = null;
        for (int i = 0; i < 1000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("aaa").append(",").append(st).append(",").append(3).append(",");
            sb.deleteCharAt(sb.length()-1);
            if(i==2){
                throw new RuntimeException();
            }
            writer.write(Collections.singleton(sb.toString()));
        }

        // List<?> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1",
        // DateUtil.date(), 250.7676);
        // List<?> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2",
        // DateUtil.date(), 0.111);
        // List<?> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3",
        // DateUtil.date(), 35);
        // List<?> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4",
        // DateUtil.date(), 28.00);
        // List<List<?>> rows = CollUtil.newArrayList(row1, row2, row3, row4,
        // row5);
        // BigExcelWriter writer = ExcelUtil.getBigWriter("e:/xxx.xlsx");
        // 一次性写出内容，使用默认样式
        // writer.write(col);
        // 关闭writer，释放内存
        // writer.close();
    }

}