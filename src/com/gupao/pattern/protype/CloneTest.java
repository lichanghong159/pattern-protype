package com.gupao.pattern.protype;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @createby: lichanghong on 2018-05-23 10:32
 **/
public class CloneTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<Integer, Integer>();
        map.put(1,2);
        map.put(2,1);
        ArrayList list = new ArrayList();
        LinkedList l = new LinkedList();
        System.out.println(map.size());
       /* Student stu  = new Student("tom",18);
        try {
            Student stu1 = (Student) stu.clone();
            System.out.println(stu.hashCode());
            System.out.println(stu1.hashCode());
            System.out.println(stu);
            System.out.println(stu1);
            System.out.println(5>>>10);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
    }
    public void add(int a,int b){
        //局部表量表
        int c,d;
        boolean flag =false;
        //操作数栈
        c =a;
        Integer i = 1;

    }
}
