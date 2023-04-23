package com.acme.statusmgr.beans;

public class FreeJvmMemoryDecorator implements  ServerStatusInterface{

    private final ServerStatusInterface severStatus;
    public FreeJvmMemoryDecorator(ServerStatusInterface serverStatus) {
        this.severStatus = serverStatus;
    }

    @Override
    public long getId() {
        return severStatus.getId();
    }

    @Override
    public String getContentHeader() {
        return severStatus.getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return severStatus.getStatusDesc() + ", and there are " + Runtime.getRuntime().freeMemory() + " bytes of JVM memory free";
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost();
    }
}
