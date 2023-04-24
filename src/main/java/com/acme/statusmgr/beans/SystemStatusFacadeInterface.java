package com.acme.statusmgr.beans;

/**
 * An interface that mandates the required methods to be a SystemStatus facade, for a real, working facade or a mock
 * facade for testing.
 */
public interface SystemStatusFacadeInterface {

    String getAvailableProcessors();

    String getFreeMemory();

    String getJREVersion();

    String getTempLocation();

    String getTotalJVMMemory();
}
