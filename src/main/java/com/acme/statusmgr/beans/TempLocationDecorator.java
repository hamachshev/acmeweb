package com.acme.statusmgr.beans;

public class TempLocationDecorator implements ServerStatusInterface{

    private final ServerStatusInterface severStatus;
    public TempLocationDecorator(ServerStatusInterface serverStatus) {
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
        return severStatus.getStatusDesc() + SystemStatusFacade.getTempLocation();
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost();
    }
}
