package com.acme.statusmgr.beans;

/**
 * Represents a facade that represents all available details to be requested, to be able to have generic data for testing
 */
public class MockServerStatusFacade implements SystemStatusFacadeInterface{
    @Override
    public String getAvailableProcessors() {
        return ", and there are 4 processors available";
    }

    @Override
    public String getFreeMemory() {
        return ", and there are 127268272 bytes of JVM memory free";
    }

    @Override
    public String getJREVersion() {
        return ", and the JRE version is 15.0.2+7-27" ;
    }

    @Override
    public String getTempLocation() {
        return ", and the server's temp file location is M:\\\\AppData\\\\Local\\\\Temp";
    }

    @Override
    public String getTotalJVMMemory() {
        return ", and there is a total of 159383552 bytes of JVM memory" ;
    }
}
