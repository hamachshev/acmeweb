package com.acme.statusmgr.beans;

/**
 * Represents a facade that represents all available details to be requested
 */
public class SystemStatusFacade implements SystemStatusFacadeInterface{
     public String getAvailableProcessors() {
        return ", and there are " + Runtime.getRuntime().availableProcessors() + " processors available";

    }

     public String getFreeMemory() {
        return ", and there are " + Runtime.getRuntime().freeMemory() + " bytes of JVM memory free";

    }

     public String getJREVersion() {
        return ", and the JRE version is " + Runtime.version().toString();

    }

     public String getTempLocation() {
        return ", and the server's temp file location is " + System.getenv("TEMP");

    }

     public String getTotalJVMMemory() {
        return ", and there is a total of " + Runtime.getRuntime().totalMemory() + " bytes of JVM memory";

    }
}
