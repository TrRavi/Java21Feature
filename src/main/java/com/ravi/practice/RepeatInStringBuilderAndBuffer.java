package com.ravi.practice;

public class RepeatInStringBuilderAndBuffer {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Ravi");
        stringBuilder.repeat("k ", 20);
        System.out.println(stringBuilder);

        StringBuffer stringBuffer = new StringBuffer("Ravi");
        stringBuffer.repeat("k ", 30);
        System.out.println(stringBuffer);
        System.out.println(stringBuffer);
    }
}
