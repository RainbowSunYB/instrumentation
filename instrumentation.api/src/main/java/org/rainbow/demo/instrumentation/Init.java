package org.rainbow.demo.instrumentation;

import java.lang.instrument.Instrumentation;

/**
 * Copyright (c) 2016-2017 by Justravel.com.
 * Created by Rainbow Sun.
 * Date: 17-2-28.
 * Time: 下午7:39.
 * Description:
 */
public class Init {
    private static Instrumentation inst;

    /**
     * 命令行启动
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("pre main");
        inst = instrumentation;

        inst.addTransformer(new DemoTransformer());
    }

    /**
     * 类加载调用
     */
    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("agent main");
        inst = instrumentation;

        DemoTransformer demoTransformer = new DemoTransformer();
        try {
            inst.addTransformer(demoTransformer, true);
            System.out.println("add transformer success");
            inst.retransformClasses(Class.forName("org.rainbow.demo.instrumentation.RunTime"));
            System.out.println("retransform success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inst.removeTransformer(demoTransformer);
        }
    }

    public static Instrumentation instrumentation() {
        return inst;
    }
}
