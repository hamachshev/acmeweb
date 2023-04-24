package com.acme.statusmgr.beans;

/**
 *  Decorates a ServerStatusInterface with the relevant information for the detail freeJVMMemory, including the
 *  description and requestCost
 */
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
