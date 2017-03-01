package org.rainbow.demo.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Copyright (c) 2016-2017 by Justravel.com.
 * Created by Rainbow Sun.
 * Date: 17-2-28.
 * Time: 下午8:27.
 * Description:
 */
public class DemoClassVisitor extends ClassVisitor {


    public DemoClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (!name.contains("run")) {
            return cv.visitMethod(access, name, desc, signature, exceptions);
        }
        System.out.println("meet method run");
        return new DemoMethodVisitor(cv.visitMethod(access, name, desc, signature, exceptions));
    }
}
