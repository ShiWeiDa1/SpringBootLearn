package com.swd.springboot.test;

/**
 * @author swd
 */
public class InitTest {
    public  static Dog dog = new Dog();

    public InitTest() {
        System.out.println("InitTest con");
    }

    public static void main(String[] args) {
        //InitTest initTest = new InitTest();
    }

}
class Dog{
    public Dog(){
        System.out.println("dog的无参构造");
    }
}
