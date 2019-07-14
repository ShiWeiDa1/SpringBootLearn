package com.swd.springboot.lean;


import java.util.ArrayList;
import java.util.List;

public class NameList {
    private List names = new ArrayList<String>();

    //同步添加name
    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized void printAll(){
        System.out.println("---");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        final NameList nameList = new NameList();

        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    nameList.add("a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    nameList.add("b");
                    nameList.add("c");
                    nameList.printAll();
                }
            }.start();
        }
    }


}
