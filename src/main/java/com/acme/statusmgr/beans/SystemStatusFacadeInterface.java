package com.acme.statusmgr.beans;

public interface SystemStatusFacadeInterface {

    String getAvailableProcessors();

    String getFreeMemory();

    String getJREVersion();

    String getTempLocation();

    String getTotalJVMMemory();
}
