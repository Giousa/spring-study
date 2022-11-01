package com.giousa.springstudy.lambda;

import com.alibaba.fastjson.JSON;
import com.giousa.springstudy.bean.UserBean;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.tools.javac.util.StringUtils;

import java.util.*;
import java.util.function.Function;
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
//        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 9, 12, 33, 44, 22, 11, 1, 2, 3,2,3,4,5,6,7,8,9,0);
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
//        System.out.println(list);
//        System.out.println(list.stream().distinct().collect(Collectors.toList()));
        int totalSize = list.size();
        int page = 5;
        int size = 10;
        int totalPage = (totalSize % size == 0) ? totalSize / size : totalSize / size + 1;

        if (page < 1) {
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        System.out.println("totalPage = " + totalPage);
//        if(page > )
        List<Integer> integers = list.subList((page - 1) * size, (page < totalPage) ? size * page : totalSize );
        System.out.println(integers);

        System.out.println("--------------");

        List<Integer> newList = Lists.newArrayList(1,5,0);
        if(list.containsAll(newList)){
            System.out.println("数据匹配");
        }else {
            System.out.println("数据不匹配");
        }

        newList.stream().forEach(it -> {
            if(it == 1){
                System.out.println("数字=1");
                return;
            }
            System.out.println("准备打烊");
            System.out.println("数字="+it);
        });

        for (int i = 0; i < 10; i++) {
            if(i == 2){
                System.out.println("命中，打破");
                break;
            }
            System.out.println("i = "+i);

        }
        System.out.println("hello end");

        List<Long> ids = Lists.newArrayList(12L,34L);
        List<UserBean> list2 = Lists.newArrayList(new UserBean(1L,"A",12)
        ,new UserBean(2L,"B",23)
        ,new UserBean(12L,"C",32)
        ,new UserBean(23L,"D",42)
        ,new UserBean(34L,"E",122));
        List<UserBean> collect = list2.stream().filter(it -> ids.contains(it.getId())).collect(Collectors.toList());
        System.out.println(collect);
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

        String s = "何况";
        System.out.println(s.length());

    }

    private static void test8_t(Integer i, Function<Integer, String> function) {
        String apply = function.apply(i);
        System.out.println("value = " + apply);

        HashMap<String, String> map = Maps.newHashMap();
        map.put("AA", "123");
        map.put("BB", "456");
        map.put("CC", "789");
        map.put("DD", "000");

        for (String key : map.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + map.get(key));
        }

        System.out.println("---------");
        System.out.println(Lists.newArrayList(map.keySet()));
        System.out.println(Lists.newArrayList(map.values()));
    }

    private static void test8() {
        test8_t(22, f -> {
            System.out.println("内容是：");
            System.out.println(f);
            return 1000 + "hello";
        });
    }

    private static void test9() {
        UserBean u1 = new UserBean(1L, "AA", 11);
        UserBean u2 = new UserBean(2L, "BB", 22);
        UserBean u3 = new UserBean(3L, "CC", 33);
        UserBean u4 = new UserBean(4L, "DD", 44);

        ArrayList<UserBean> userBeans = Lists.newArrayList(u1, u2, u3, u4);
//        Map<Long, String> collect = userBeans.stream().collect(Collectors.toMap(UserBean::getId, UserBean::getName));
        Map<Long, String> collect = userBeans.stream().collect(Collectors.toMap(UserBean::getId, UserBean::getName, (v1, v2) -> v1));
        System.out.println(JSON.toJSONString(collect));

        List<String> listStr = Lists.newArrayList("AA", "BB", "CC");
        List<String> collect1 = listStr.stream().map(it -> it + " 备注: " + "hello").collect(Collectors.toList());
        System.out.println(collect1);

//        listStr.set(0, StringUtils.replaceEach(imTipConfigInfo.getTips().get(i)
//                , new String[]{"{prescriptionId}", "{doctorName}"}
//                , new String[]{prescriptionDetailInfo.getPrescriptionId(), expertDoctorInfo.getName()}));


    }

    private static void test10() {
        HashMap<String, String> map = Maps.newHashMap();
        map.put("AA", "123");
        map.put("BB", "456");
        map.put("CC", "789");
        map.put("DD", "000");

        for (String key : map.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + map.get(key));
        }

        System.out.println("---------");
        System.out.println(Lists.newArrayList(map.keySet()));
        System.out.println(Lists.newArrayList(map.values()));
        System.out.println("======");

        HashMap<String, List<String>> map2 = Maps.newHashMap();
        map2.put("AA", Lists.newArrayList("1", "2"));
        map2.put("BB", Lists.newArrayList("2", "3"));
        map2.put("CC", Lists.newArrayList("3", "4"));
        map2.put("DD", Lists.newArrayList("4", "5"));
        List<String> tagInfoList = Lists.newArrayList();
        map2.values().forEach(tagInfoList::addAll);
        System.out.println(tagInfoList);

        List<String> innerTag = Lists.newArrayList("1", "5", "6");
        List<String> tagInfos = tagInfoList.stream().filter(it -> {
            if (innerTag.size() > 0) {
                return !innerTag.contains(it);
            }
            return true;
        }).distinct().collect(Collectors.toList());

        System.out.println(tagInfos);

    }

    private static void test11() {
        String str = "1111,222,33,44,55,66";
        String[] split = str.split(",");

        List<Long> depts = Lists.newArrayList(1L, 2L, 3L, 4L, 5L);
        if (depts.contains(1L)) {
            System.out.println("这个 = ");
        } else {
            System.out.println("这个不等于");
        }

        int flag = 2;
        test12("hello", it -> {
            System.out.println("准备function");

            switch (flag) {
                case 1:
                    return true;

                case 2:
                    return false;

                default:
                    return false;
            }
        });
    }

    private static void test12(String str, Function<String, Boolean> function) {
        Boolean apply = function.apply("2");
        System.out.println(apply);
        if (apply) {
            System.out.println("触发");
        } else {
            System.out.println("没有命中");
        }

        System.out.println("function结束");

        return;
    }

    private static void test13() {
        Map<Long, List<UserBean>> list = Maps.newHashMap();

        List<UserBean> userBean1 = Lists.newArrayList();
        userBean1.add(new UserBean(1L, "A", 11));
        userBean1.add(new UserBean(2L, "B", 12));
        userBean1.add(new UserBean(3L, "C", 13));
        list.put(1001L, userBean1);

        List<UserBean> userBean2 = Lists.newArrayList();
        userBean2.add(new UserBean(3L, "C", 13));
        userBean2.add(new UserBean(4L, "D", 14));
        userBean2.add(new UserBean(5L, "E", 15));
        list.put(1002L, userBean2);


        List<UserBean> userBean3 = Lists.newArrayList();
        userBean3.add(new UserBean(1L, "A", 11));
        userBean3.add(new UserBean(7L, "G", 17));
        userBean3.add(new UserBean(9L, "I", 19));
        list.put(10003L, userBean3);

        List<Long> userIds = Lists.newArrayList();
        list.values().forEach(it -> userIds.addAll(it.stream().map(UserBean::getId).collect(Collectors.toList())));

        System.out.println("userIds: " + userIds.stream().distinct().collect(Collectors.toList()));

    }

    public static void main(String[] args) {
        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
