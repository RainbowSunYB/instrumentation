package org.rainbow.demo.instrumentation;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * Copyright (c) 2016-2017 by Justravel.com.
 * Created by Rainbow Sun.
 * Date: 17-2-28.
 * Time: 下午7:37.
 * Description:
 */
public class Attach {
    public static void main(String[] args) throws InterruptedException, IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        String agentPath = getAgentPath();

        VirtualMachine virtualMachine = VirtualMachine.attach("8779");

        virtualMachine.loadAgent(agentPath);

        virtualMachine.detach();

        System.out.println(getAgentPath());
    }

    private static String getAgentPath() {
        ProtectionDomain domain = Init.class.getProtectionDomain();
        CodeSource source = domain.getCodeSource();
        return source.getLocation().getPath();
    }

}
