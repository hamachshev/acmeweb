package com.acme.statusmgr.beans;

public class FreeJvmMemoryDecorator implements  ServerStatusInterface{

    private final ServerStatusInterface severStatus;
    private final SystemStatusFacadeInterface systemStatusFacade;
    public FreeJvmMemoryDecorator(ServerStatusInterface serverStatus, SystemStatusFacadeInterface systemStatusFacade) {
        this.severStatus = serverStatus;
        this.systemStatusFacade = systemStatusFacade;
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
        return severStatus.getStatusDesc() + systemStatusFacade.getFreeMemory();
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost() + 7;
    }
}
