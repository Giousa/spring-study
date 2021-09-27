package com.giousa.springstudy.fanxing;

import com.giousa.springstudy.custom.UserDTO;

import java.util.Objects;

public class PairMain {

    public static void main(String[] args) {

        Pair<String> pair1 = new Pair<>();
        pair1.setFirst("hello");
        pair1.setSecond("world");

        Pair<UserDTO> pair2 = new Pair<>();

        if(Objects.equals(pair1.getClass(),pair2.getClass())){
            System.out.println("类型相同");
        }else {
            System.out.println("类型不同");
        }

        if("hello" instanceof String){
            System.out.println("是String类型");
        }

    }
}
