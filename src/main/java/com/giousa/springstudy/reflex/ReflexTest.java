package com.giousa.springstudy.reflex;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ReflexTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        URLEncoder.encode("","utf-8");
        String s= "https%3A%2F%2Fh5.test.shantaijk.cn%2Fhealth_report%2F%23%2Fbase";

        String decode = URLDecoder.decode(s, "utf-8");
        System.out.println(decode);

    }
}
