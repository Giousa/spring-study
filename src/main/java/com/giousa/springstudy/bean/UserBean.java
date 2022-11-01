package com.giousa.springstudy.bean;

public class UserBean {

    private Long id;

    private String name;

    private Integer age;

    public UserBean() {
//        System.out.println("UserBean no param has init");
    }

    public UserBean(Long id, String name, Integer age) {
//        System.out.println("UserBean three param has init");
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private void eat() {
        System.out.println("用户：" + name + " has eat method");
    }

    private String say(String text) {
        return "用户： " + name + ",say :" + text;
    }

    private String left(String title,Integer num){
        return "用户： " + name + ",title :" + title+",num : "+num;
    }

    public void sleep() {
        System.out.println("用户：" + name + " has eat sleep");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
