package org.rainbow.demo.instrumentation;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.rainbow.demo.asm.DemoClassVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Copyright (c) 2016-2017 by Justravel.com.
 * Created by Rainbow Sun.
 * Date: 17-2-28.
 * Time: 下午8:24.
 * Description:
 */
public class DemoTransformer implements ClassFileTransformer {
    @Override public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        System.out.println(className);

        if (!className.contains("RunTime")) {
            return null;
        }

        System.out.println("meet class RunTime");
        ClassReader cr = new ClassReader(classfileBuffer);
        ClassWriter classWriter = new ClassWriter(2);
        cr.accept(new DemoClassVisitor(classWriter), ClassReader.SKIP_DEBUG);

        byte[] bytes = classWriter.toByteArray();

        writeFile("/tmp/Old.class", classfileBuffer);
        writeFile("/tmp/New.class", bytes);

        return bytes;
    }

    private void writeFile(String fileName, byte[] bytes) {
        try {
            File file = new File(fileName);
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(bytes);
            fout.close();
        } catch (Exception e) {

        }
    }
}
