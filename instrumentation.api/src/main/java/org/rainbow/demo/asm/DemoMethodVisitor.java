package org.rainbow.demo.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Copyright (c) 2016-2017 by Justravel.com.
 * Created by Rainbow Sun.
 * Date: 17-2-28.
 * Time: 下午8:28.
 * Description:
 */
public class DemoMethodVisitor extends MethodVisitor {
    public DemoMethodVisitor(MethodVisitor mv) {
        super(Opcodes.ASM5, mv);
    }

    @Override public void visitCode() {
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "org/rainbow/demo/instrumentation/RunTime", "number", "()V", false);
    }
}
