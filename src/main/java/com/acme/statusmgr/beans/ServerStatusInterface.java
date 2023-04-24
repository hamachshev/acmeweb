package com.acme.statusmgr.beans;

/**
 * An interface that represents a SeverStatus, including basic and also detailed to be returned from the detailed REST
 * endpoint to Spring
 */
public interface ServerStatusInterface {

    long getId();
    String getContentHeader();

    String getStatusDesc();

    Integer getRequestCost();


}
