package com.giousa.springstudy.thread;

import com.giousa.springstudy.custom.UserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {

    private static void thread1() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hello");

        System.out.println(threadLocal.get());

        ThreadLocal<UserDTO> threadLocalUser = ThreadLocal.withInitial(UserDTO::new);
        System.out.println(threadLocalUser.get().hashCode());
        System.out.println(threadLocalUser.get().hashCode());
        System.out.println(threadLocalUser.get().hashCode());

        System.out.println("---------------------");

        Runnable runnable1 = () -> {
            try {
                Thread.sleep(1000);
                ThreadLocal<UserDTO> threadLocal1 = ThreadLocal.withInitial(UserDTO::new);
                threadLocal1.get().setName("hello");
                threadLocal1.get().setId(1000);
                threadLocal1.set(threadLocal1.get());
                System.out.println("thread1 user hashcode: " + threadLocal1.get().hashCode());
            } catch (InterruptedException e) {
                System.out.println("thread1 error");
            }

        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(1000);
                ThreadLocal<UserDTO> threadLocal2 = ThreadLocal.withInitial(UserDTO::new);
                System.out.println("thread2 user hashcode: " + threadLocal2.get().hashCode());
            } catch (InterruptedException e) {
                System.out.println("thread2 error");
            }

        };

        Thread thread1 = new Thread(runnable1);
        thread1.start();
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        System.out.println("thread1 = " + thread1);
        System.out.println("thread2 = " + thread2);

        System.out.println("---------------------");

    }

    private static void thread2() {
        Callable<String> callable = () -> {
            System.out.println("2");
            Thread.sleep(2000);
            return "hello world";
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        System.out.println("1");
        long preTime = System.currentTimeMillis();
        futureTask.run();
        String s = null;
        try {
            System.out.println("3");
            s = futureTask.get(1L, TimeUnit.SECONDS);
            System.out.println("???????????????" + s + ",?????????" + (System.currentTimeMillis() - preTime) * 1.00d / 1000 + "???");
        } catch (Exception e) {
            System.out.println("?????????" + e);
            System.out.println("???????????????" + (System.currentTimeMillis() - preTime) * 1.00d / 1000 + "???");
        }
    }

    private static void thread3() {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        Callable<String> callable1 = () -> "hello_1";
        Callable<String> callable2 = () -> "hello_2";
        Callable<String> callable3 = () -> "hello_3";
        Callable<String> callable4 = () -> "hello_4";
        Callable<String> callable5 = () -> "hello_5";
        Future<String> submit1 = executorService.submit(callable1);
        Future<String> submit2 = executorService.submit(callable2);
        Future<String> submit3 = executorService.submit(callable3);
        Future<String> submit4 = executorService.submit(callable4);
        Future<String> submit5 = executorService.submit(callable5);

        try {
            System.out.println("future1: " + submit1.get());
            ;
            System.out.println("future2: " + submit2.get());
            ;
            System.out.println("future3: " + submit3.get());
            ;
            System.out.println("future4: " + submit4.get());
            ;
            System.out.println("future5: " + submit5.get());
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("getLargestPoolSize???" + executorService.getLargestPoolSize());
        System.out.println("getCompletedTaskCount???" + executorService.getCompletedTaskCount());
        System.out.println("getActiveCount???" + executorService.getActiveCount());
        System.out.println("getCorePoolSize???" + executorService.getCorePoolSize());
        System.out.println("getMaximumPoolSize???" + executorService.getMaximumPoolSize());
        System.out.println("getTaskCount???" + executorService.getTaskCount());


        executorService.shutdown();

    }

    private static void thread4() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        System.out.println("?????????" + new Date());
        executorService.schedule(() -> {
            System.out.println("?????????????????????" + new Date());

            try {
                System.out.println("???????????????...");
                Thread.sleep(2000);
                System.out.println("????????????");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("?????????" + new Date());
        executorService.shutdown();
    }

    /**
     * ?????????????????????
     * ????????????????????????????????????????????????1???????????????
     */
    private static void thread5() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ArrayList<Callable<String>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Callable<String> callable = () -> {
                Thread.sleep(500);
                return "hello_" + finalI;
            };
            callables.add(callable);
        }

        System.out.println("????????????");
        try {
            String s = executorService.invokeAny(callables);
            System.out.println("??????????????????" + s);
            System.out.println("-----------------");
            List<Future<String>> futures = executorService.invokeAll(callables);
            for (int i = 0; i < futures.size(); i++) {
                System.out.println("??????: " + futures.get(i).get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("???????????????");
            executorService.shutdown();
        }
    }

    private static void thread6() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture
                .supplyAsync(() -> "hello world", executorService)
                .thenApply(it -> "thenApply_" + it)
                .thenApply(it -> 1/0)
                .exceptionally(it -> {
                    System.out.println("it = "+it);
                    return null;
                })
                .whenComplete((s, t) -> System.out.println("s = " + s + ",t = " + t));

        executorService.shutdown();

    }

    public static void main(String[] args) {
        thread6();
    }
}
