package com.im.cloud;


import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest{
    public static void main(String[] args) {
        Map<String,Integer> m = ImmutableMap.of("a",1,"b",2,"c",3);
        m.entrySet().stream().reduce((k,v)->{
            System.out.println(k);
            System.out.println(v);
            System.out.println();
            return v;
        });
    }
}
