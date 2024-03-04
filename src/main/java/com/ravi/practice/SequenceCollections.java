package com.ravi.practice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class SequenceCollections {
    public static void main(String[] args) {
        forList();
        forSet();
    }

    private static void forSet() {
        LinkedHashSet<String> nameSet = new LinkedHashSet<>();
        nameSet.add("ravi");
        nameSet.add("ravi_1");
        nameSet.add("ravi_2");
        System.out.println(nameSet);
        System.out.println(nameSet.getFirst());
        System.out.println(nameSet.getLast());
        System.out.println(nameSet.reversed());
        nameSet.addFirst("ravi_1");
        System.out.println(nameSet);
    }

    private static void forList() {
        List<String> nameList = new ArrayList<>();
        nameList.add("ravi");
        nameList.add("ravi_1");
        nameList.add("ravi_2");
        nameList.add("ravi_3");

        System.out.println(nameList.getLast());
        System.out.println(nameList.getFirst());
        System.out.println(nameList.reversed());
        nameList.addLast("last_name");
        System.out.println(nameList);
        nameList.addFirst("first_name");
        System.out.println(nameList);
    }
}
