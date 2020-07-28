package com.wuwei.gateway.test;

import java.util.HashMap;

/**
 * @Author: wuwei
 * @Date:2020-03-21 19:46
 */
public class EqualsTest {

    public static void main(String[] args) {
        student s1 = new student(23);
        student s2 = new student(23);
        System.out.println(s1.equals(s2));

        String s11 = "abc";
        String s22 = "abc";
        System.out.println(s11.equals(s22));
        System.out.println(s11==s22);

        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);

        HashMap<String,student> h1 = new HashMap<>();
        h1.put("wu",s1);
        System.out.println(h1.get("wu").hashCode());
        h1.put("wu",s1);
        h1.put(null,s1);
        h1.put("wei",s1);
        h1.put("wu",s2);
        System.out.println(h1.get("wu").hashCode());
        System.out.println(h1.get("wei").hashCode());
        System.out.println(h1.get(null).hashCode());
        System.out.println(h1);

        Object key = new Object();
        key = "wu";
        System.out.println(key.hashCode());
        int keyh = key.hashCode();
        int keyx = (keyh-1)*(keyh^(keyh>>>16));
        System.out.println(keyx);


    }

}

 class student{

    private  int age;

    public student(int age){
        this.age = age;
    }
//    public boolean equals(Object obj){
//        student other = (student)obj;
//        return this.age == other.age;
//    }

}
