package com.acme.statusmgr.beans;

public class TotalJVMMemoryDecorator implements  ServerStatusInterface{

    private final ServerStatusInterface severStatus;
    public TotalJVMMemoryDecorator(ServerStatusInterface serverStatus) {
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
        return severStatus.getStatusDesc() + ", and there is a total of " + Runtime.getRuntime().totalMemory() + " bytes of JVM memory";
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost();
    }
}
