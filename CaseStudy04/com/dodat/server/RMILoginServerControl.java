package com.dodat.server;

import com.dodat.user.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RMILoginServerControl extends UnicastRemoteObject implements RMILoginInterface {
    private static final long serialVersionUID = 1L;
    private int serverPort=777;
    private Registry registry;
    private String rmiService;
    private Connection con;
    private RMILoginServerView view;
    public RMILoginServerControl(RMILoginServerView view) throws RemoteException {
        super();
        this.view = view;
        try {
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind("rmi://localhost/login", this);
            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkUser(User user) {
        boolean check = false;
        List<User> users = new ArrayList<>();
        users.add(new User("0987654321", "q2w2e3"));
        users.add(new User("0983313567", "ki98u7"));
        users.add(new User("0912345678", "ngaythu5"));
        users.add(new User("0987452100", "so1dcv"));
//        System.out.println("Username: " + user.getUsername());
//        System.out.println("Password: " + user.getPassword());
        for (int i=0; i<4; i++) {
            if (users.get(i).getUsername().equals(user.getUsername()) && users.get(i).getPassword().equals(user.getPassword()))
                check = true;
        }
        return check;
    }
    @Override
    public String checkLogin(User user) throws RemoteException {
        if (checkUser(user)) {
//            System.out.println("Username: " + user.getUsername());
//            System.out.println("Password: " + user.getPassword());
//            System.out.println("Login successfully!");
            return "Login successfully!";
        }
        else {
//            System.out.println("Username: " + user.getUsername());
//            System.out.println("Password: " + user.getPassword());
//            System.out.println("Invalid username and/or password!");
            return "Invalid username and/or password!";
        }
    }
}
