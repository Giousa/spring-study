package com.giousa.springstudy.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CanonicalNameTest {

    private static final Map<String, String> aliasMap = new ConcurrentHashMap<>(16);


    public static String canonicalName(String name) {
        String canonicalName = name;
        // Handle aliasing...
        String resolvedName;
        do {
            System.out.println("请求get");
            resolvedName = aliasMap.get(canonicalName);
            System.out.println("resolvedName = "+resolvedName);
            if (resolvedName != null) {
                canonicalName = resolvedName;
            }
        }
        while (resolvedName != null);
        return canonicalName;
    }

    public static void main(String[] args) {
        aliasMap.put("A","111");
        aliasMap.put("B","222");
        aliasMap.put("C","333");
        aliasMap.put("D","444");

        String name = canonicalName("C");

        System.out.println("获取名称： "+name);
    }
}
