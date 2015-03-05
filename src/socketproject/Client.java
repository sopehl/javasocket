/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author semih
 */
public class Client implements Communication {

    private Socket clientSocket;
    private DataOutputStream dataOut;
    private DataInputStream dataIn;
    private String sentMessage;
    private String recievedMessage;
    private String IP;

    public Client(String IP) {
        this.IP = IP;
    }

    @Override
    public void connect(Integer portNumber) {
        try {
            clientSocket = new Socket(IP, portNumber);
            if (clientSocket.isConnected() == true) {
                System.out.println("you connected to " + clientSocket.getRemoteSocketAddress().toString());
            }
            System.out.println(clientSocket.isConnected());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disconnect() {
        try {
            this.clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendMessage(String message) {
        try {
            //clientSocket = new Socket("localhost",6066);
            dataOut = new DataOutputStream(clientSocket.getOutputStream());
            dataOut.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void recieveMessage() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                dataIn = new DataInputStream(clientSocket.getInputStream());
                recievedMessage = dataIn.readUTF();
                tx.setText(tx.getText() +"\n"+ getRecievedMessage());
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    JTextArea tx ;
    
    public void setTextArea(JTextArea tx){
        this.tx = tx;
    }
    
    public String getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(String sentMessage) {
        this.sentMessage = sentMessage;
    }

    public String getRecievedMessage() {
        return recievedMessage;
    }

    public void setRecievedMessage(String recievedMessage) {
        this.recievedMessage = recievedMessage;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    

}
