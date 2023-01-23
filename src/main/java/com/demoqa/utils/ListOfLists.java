package com.demoqa.utils;

import java.util.ArrayList;

public class ListOfLists {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> al=new ArrayList<ArrayList<String>>();
        ArrayList<String> li=new ArrayList<String>();
        ArrayList<String> li1=new ArrayList<String>();
        li.add("abc");
        li.add("def");
        li.add("ghi");
        li.add("jkl");
        li.add("mnop");

        li1.add("123");
        li1.add("456");
        li1.add("789");
        li1.add("101112");
        li1.add("121314");
       // System.out.println(li);
        al.add(li);
        al.add(li1);
        System.out.println(al);
        System.out.println(al.get(0));
        System.out.println(al.size());


    }
}
