package com.acme.statusmgr.beans;

public class JREVersionDecorator implements  ServerStatusInterface{

    private final ServerStatusInterface severStatus;
    public JREVersionDecorator(ServerStatusInterface serverStatus) {
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
        return severStatus.getStatusDesc() + ", and the JRE version is " + Runtime.version().toString();
    }

    @Override
    public Integer getRequestCost() {
        return severStatus.getRequestCost();
    }
}