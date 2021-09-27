package com.giousa.springstudy.fanxing;

import lombok.Data;

@Data
public class Pair<T> {

    private T first;

    private T second;
}
