package com.giousa.springstudy.bean;

import java.util.UUID;

public class CustomServiceCryptImpl implements CustomServiceCrypt {

    public CustomServiceCryptImpl() {
        System.out.println("CustomServiceCrypt has init");
    }

    @Override
    public String encrypt(String str) {
        return UUID.randomUUID().toString() + "@" + str;
    }

    @Override
    public String decrypt(String str) {
        String[] split = str.split("@");
        if (split.length != 2) {
            return null;
        }
        return split[1];
    }
}
