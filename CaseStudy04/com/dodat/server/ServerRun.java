package com.dodat.server;

import java.rmi.RemoteException;
public class ServerRun {
    public static void main(String[] args) throws RemoteException {
        RMILoginServerView serverView = new RMILoginServerView();
        RMILoginServerControl serverControl = new RMILoginServerControl(serverView);
    }
}
