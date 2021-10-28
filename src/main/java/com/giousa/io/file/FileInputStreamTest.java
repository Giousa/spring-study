package com.giousa.io.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInputStreamTest {

    private static String path = "/Users/zhangmengmeng/Desktop/txt/春江花月夜.txt";

    private static void test1(){
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            System.out.println("fileInputStream:");
            System.out.println(fileInputStream);

            byte[] bytes = new byte[1024];
            int read = fileInputStream.read(bytes, 0, bytes.length);
            System.out.println("read = "+read);

            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            new DataInputStream(new BufferedInputStream(fileInputStream));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test3(){
        try {
            PrintWriter printWriter = new PrintWriter("/Users/zhangmengmeng/Desktop/txt/test-fileinput.txt");
            printWriter.println("hello world");

            printWriter.print("AAA");
            printWriter.print("BBB");
            printWriter.print("CCC");

            printWriter.print(8999);

//            printWriter.printf("this is a printwriter:: %d,%s",100,"hero");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test3();
    }
}
