package com.dodat.client;

public class ClientRun {
    public static void main(String[] args) {
        RMILoginClientView clientView = new RMILoginClientView();
        RMILoginClientControl clientControl = new RMILoginClientControl(clientView);
        clientView.setVisible(true);
    }
}
