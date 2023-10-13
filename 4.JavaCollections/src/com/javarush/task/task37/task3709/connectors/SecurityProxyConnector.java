package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    SimpleConnector simpleConnector;
    SecurityChecker securityChecker = new SecurityCheckerImpl();

    @Override
    public void connect() {
        System.out.println("Performing security check...");
        if (securityChecker.performSecurityCheck()) {
            simpleConnector.connect();
        } else {
            System.out.println("FAILED SECURITY CHECK, WON'T CONNECT!");
        }
    }

    public SecurityProxyConnector(String resourceString) {
        this.simpleConnector = new SimpleConnector(resourceString);
    }
}
