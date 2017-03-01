package org.rainbow.demo.instrumentation;

import java.lang.management.ManagementFactory;

/**
 * Copyright (c) 2016-2017 by Justravel.com.
 * Created by Rainbow Sun.
 * Date: 17-2-28.
 * Time: 下午7:32.
 * Description:
 */
public class RunTime {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        while (true) {
            RunTime.run();
            Thread.sleep(500);
        }
    }

    public static void run() {
        i++;
    }

    public static void number() {
        System.out.println(i);
    }
}
