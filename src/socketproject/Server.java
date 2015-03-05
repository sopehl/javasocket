/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketproject;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author semih
 */
public class Server implements Communication {

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private String sentMessage;
    private String recievedMessage;

    @Override
    public void connect(Integer portNumber) {
        try {
            System.out.println("Wait for client...");
            serverSocket = new ServerSocket(portNumber);
            socket = serverSocket.accept();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disconnect() {
        try {
            socket.close();
            serverSocket.close();
            dataIn.close();
            dataOut.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendMessage(String message) {
        try {
            dataOut = new DataOutputStream(socket.getOutputStream());
            dataOut.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
                dataIn = new DataInputStream(socket.getInputStream());
                recievedMessage = dataIn.readUTF();
                tx.setText(tx.getText() +"\n"+ getRecievedMessage());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    

}
