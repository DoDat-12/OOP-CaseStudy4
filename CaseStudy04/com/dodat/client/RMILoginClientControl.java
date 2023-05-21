package com.dodat.client;

import com.dodat.server.RMILoginInterface;
import com.dodat.user.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMILoginClientControl {
    private String serverHost = "rmi://localhost/login";
    private int serverPort=777;
    private RMILoginInterface rmiServer;
    private String RMIService;
    private Registry registry;
    private RMILoginClientView clientView;
    public RMILoginClientControl(RMILoginClientView clientView) {
        this.clientView = clientView;
        LoginListener loginListener = new LoginListener();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                User user = clientView.getUser();
//                System.out.println("Username: " + user.getUsername());
//                System.out.println("Password: " + user.getPassword());
                registry = LocateRegistry.getRegistry(serverPort);
                rmiServer = (RMILoginInterface) registry.lookup(serverHost);
                String response = rmiServer.checkLogin(user);
                clientView.showMessage(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public String getServerHost() {
        return serverHost;
    }
    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }
    public int getServerPort() {
        return serverPort;
    }
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
