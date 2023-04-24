package com.acme.statusmgr.beans;

/**
 *  Decorates a ServerStatusInterface with the relevant information for the detail jreVersion, including the
 *  description and requestCost
 */
public class JREVersionDecorator implements  ServerStatusInterface{

    private final ServerStatusInterface severStatus;
    private final SystemStatusFacadeInterface systemStatusFacade;
    public JREVersionDecorator(ServerStatusInterface serverStatus, SystemStatusFacadeInterface systemStatusFacade) {
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
        return severStatus.getStatusDesc() + systemStatusFacade.getJREVersion();
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost() + 19;
    }
}
