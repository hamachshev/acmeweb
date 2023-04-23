package com.acme.statusmgr.beans;

public class SystemStatusFacade {
    static String getAvailableProcessors() {
        return ", and there are " + Runtime.getRuntime().availableProcessors() + " processors available";

    }

    static String getFreeMemory() {
        return ", and there are " + Runtime.getRuntime().freeMemory() + " bytes of JVM memory free";

    }

    static String getJREVersion() {
        return ", and the JRE version is " + Runtime.version().toString();

    }

    static String getTempLocation() {
        return ", and the server's temp file location is " + System.getenv("TEMP");

    }

    static String getTotalJVMMemory() {
        return ", and there is a total of " + Runtime.getRuntime().totalMemory() + " bytes of JVM memory";

    }
}
