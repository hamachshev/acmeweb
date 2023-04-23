package com.acme.statusmgr.beans;

public class AvailableProcessorsDecorator implements  ServerStatusInterface{

    private final ServerStatusInterface severStatus;
    public AvailableProcessorsDecorator(ServerStatusInterface serverStatus) {
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
        return severStatus.getStatusDesc() + ", and there are " + Runtime.getRuntime().availableProcessors() + " processors available";
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost();
    }
}
