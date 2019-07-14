package com.swd.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.tree.TreeCellEditor;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCrudApplicationTests {

    @Test
    public void contextLoads() {
        ListNode listNode = new ListNode(3);
        listNode.next=new ListNode(4);
        listNode=listNode.next;



        listNode.next=new ListNode(5);
        listNode = listNode.next;

        System.out.println(listNode);
        ArrayList<Integer> list = printListFromTailToHead(listNode);
        for (int l:list) {
            System.out.println(l);
        }
        /*int arr[][] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(find(14,arr));*/

      /*  String s = replaceSpace(new StringBuffer("We Are Happy."));
        System.out.println(s);*/
    }



    @Test
    public  void test01(){
        HashMap<Integer,User> map  =  new HashMap<>();
        map.put(1,new User("tom",13));
        map.put(3,new User("aom",3));
        map.put(2,new User("bom",33));
        System.out.println(map.toString());
        HashMap<Integer, Object> mapSort = hashMapSort(map);


        System.out.println(mapSort);

    }

    public static HashMap<Integer,Object> hashMapSort(HashMap<Integer,User> map){
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<Map.Entry<Integer, User>> entries = map.entrySet();
        ArrayList<Map.Entry<Integer,User>> list = new ArrayList<Map.Entry<Integer,User>>(entries);

        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }


        return linkedHashMap;



    }


    /*
        输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
    * */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list  =  new ArrayList<>();
        while (null!=listNode){
            list.add(listNode.val);
            listNode=listNode.next;

        }
        return list;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.
     * 则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */

    public static String replaceSpace(StringBuffer str) {
        for (int i=0;i<str.length();++i){
            System.out.println(str.charAt(i));

            if (str.charAt(i)==32){
                System.out.println(i);
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    public static boolean find(int target,int array[][]){
        for (int i=0;i<array.length;++i){
            for (int j=0;j<array[i].length;++j){

                if(target==array[i][j]){
                    return  true;

                }
            }
        }
        return false;

    }


}

class ListNode {
    int val;

    ListNode next = null;

    ListNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class  User{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}