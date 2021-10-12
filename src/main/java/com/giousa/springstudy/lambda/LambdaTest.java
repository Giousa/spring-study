package com.giousa.springstudy.lambda;

import com.google.common.collect.Lists;
import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    private static void test1() {
        Stream<String> st = Stream.of("hello", "world", "east");
        List<String> l = st.filter(it -> it.contains("l")).collect(Collectors.toList());
        System.out.println(l);

        Stream<ArrayList<String>> generate = Stream.generate(() -> Lists.newArrayList("hello", "world", "east"));
        Stream<Double> generate1 = Stream.generate(Math::random);

//        BigInteger limit = new BigInteger("100");
//        Stream.iterate(BigInteger.ZERO, it -> it.add(BigInteger.ZERO)).forEach(System.out::println);

        UnaryOperator<Integer> unaryOperator = it -> it;
        Stream.iterate(1, unaryOperator).forEach(System.out::println);
    }

    private static void test2() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 9, 12, 33, 44, 22, 11, 1, 2, 3);
        System.out.println(list);
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }


    private static void test3() throws Exception {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 9, 12, 33, 44, 22, 11, 1, 2, 3);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println("max = " + max.get());

        ArrayList<Integer> list2 = Lists.newArrayList();
//        System.out.println("max21 = "+list2.stream().max(Integer::compareTo).get());
        System.out.println("max21 = " + list2.stream().max(Integer::compareTo).orElseThrow((() -> {
            System.out.println("抛出异常");
            return new Exception("这个有问题");
        })));
        System.out.println("max21 = " + list2.stream().max(Integer::compareTo).orElseGet(() -> {
            System.out.println("计算默认值");

            return 1000;
        }));
        System.out.println("max22 = " + list2.stream().max(Integer::compareTo).orElse(0));
    }


    private static void test4() {

        ArrayList<Integer> list1 = Lists.newArrayList(1, 2);
        ArrayList<Integer> list2 = Lists.newArrayList(300, 400);

        list1.stream().findFirst().ifPresent(list2::add);

        System.out.println(list2);

        System.out.println("----------------");

        List<Integer> collect = list1.stream().filter(it -> it > 100).collect(Collectors.toList());

//        list1.stream().findFirst().

        ArrayList<String> list3 = Lists.newArrayList("hello", "world");
        List<String> collect1 = list3.stream().map(StringUtils::toUpperCase).collect(Collectors.toList());
        System.out.println(collect1);


    }

    private static void test5() {
        Optional<Integer> optional1 = Optional.of(100);
        Optional<Object> optional2 = Optional.empty();
        Optional<Integer> optional3 = Optional.ofNullable(100000);

        System.out.println("optional1 = " + optional1.orElse(9));
        System.out.println("optional2 = " + optional2.orElse(99));
        System.out.println("optional2 = " + optional3.orElse(999));
    }

    private static void test6() {
        ArrayList<String> list = Lists.newArrayList("hello", "world");
        ArrayList<String> firstList = Lists.newArrayList("today", "tomy");
        ArrayList<String> secondList = Lists.newArrayList("custom", "famous");

        List<String> collect = list.stream().filter(it -> it.length() > 2).flatMap(it -> {
            System.out.println("第一次flatmap : " + it);
            return firstList.stream().map(String::toUpperCase);
        }).flatMap(it -> {
            System.out.println("第二次flatmap : " + it);
            return secondList.stream().map(String::toUpperCase);
        }).collect(Collectors.toList());

        System.out.println("获取新集合：");
        System.out.println(collect);

    }

    private static void test7() {
    }

    private static void test8() {
    }

    public static void main(String[] args) {
        try {
            test6();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
