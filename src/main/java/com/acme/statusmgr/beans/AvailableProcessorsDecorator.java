package com.acme.statusmgr.beans;

/**
 *  Decorates a ServerStatusInterface with the relevant information for the detail Available processors, including the
 *  description and requestCost
 */
public class AvailableProcessorsDecorator implements  ServerStatusInterface{

    private final ServerStatusInterface severStatus;

    private final SystemStatusFacadeInterface systemStatusFacade;
    public AvailableProcessorsDecorator(ServerStatusInterface serverStatus, SystemStatusFacadeInterface systemStatusFacade) {
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
        return severStatus.getStatusDesc() + systemStatusFacade.getAvailableProcessors();
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost() + 3;
    }
}
