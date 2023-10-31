package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    private int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        boolean isRollbackPositionFound = false;
        List<Integer> versionsToDelete = new LinkedList<>();
        for (int version : versionHistoryMap.keySet()) {
            if (version == rollbackVersion) {
                isRollbackPositionFound = true;
                continue;
            }
            if (isRollbackPositionFound) {
                versionsToDelete.add(version);
            }
        }

        if (!isRollbackPositionFound) {
            return false;
        }

        for (int version : versionsToDelete) {
            versionHistoryMap.remove(version);
        }

        currentVersion = rollbackVersion;
        return true;
    }
}
