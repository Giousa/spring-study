package com.giousa.springstudy.fanxing;

import com.giousa.springstudy.custom.BaseDTO;
import com.giousa.springstudy.custom.StudentDTO;
import com.giousa.springstudy.custom.UserDTO;

/**
 * 泛型：一般用于有返回值的，需要<T>返回
 * 通配符：一般用于无返回值的，void
 */
public class ArrayAlg {

    private <T> T getMiddle(T... t) {
        return t[t.length / 2];
    }

    private <T extends BaseDTO> T exec(T t){
        System.out.println("t = "+t);
        return t;
    }

    private void exec2(Pair<? extends BaseDTO> pair){
        BaseDTO first = pair.getFirst();
        System.out.println(first);
        first.baseMethod();
    }

    private void exec3(Pair<?> pair){
        System.out.println(pair);
    }

    private void exec4(Pair<? super BaseDTO> pair){
        System.out.println(pair);
    }

    public static void main(String[] args) {

        ArrayAlg arrayAlg = new ArrayAlg();
        String middle = arrayAlg.getMiddle("1", "2", "a", "g", "h");
        System.out.println(">>>>>>> : " + middle);

        UserDTO m = arrayAlg.getMiddle(
                new UserDTO(1, "a"),
                new UserDTO(2, "b"),
                new UserDTO(3, "c"),
                new UserDTO(4, "e"));
        System.out.println("m = "+m);

        System.out.println("---------------");

        arrayAlg.exec(new UserDTO(1,"a"));
        arrayAlg.exec(new StudentDTO(new UserDTO(100,"hello"),"eat|sleep"));

        System.out.println("---------------");

        Pair<UserDTO> userDTOPair = new Pair<>();
        userDTOPair.setFirst(new UserDTO(1,"hello world"));
        arrayAlg.exec2(userDTOPair);

    }
}
