package com.dodat.server;

import com.dodat.user.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMILoginInterface extends Remote {
    String checkLogin(User user) throws RemoteException;
}
