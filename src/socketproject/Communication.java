/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author semih
 */
public interface Communication extends Runnable{
    
    /**
     * Connect to server or wait for client who want to connect to server
     * @param portNumber is a way to connect for server or client
     */
    void connect(Integer portNumber);
    
    /**
     * Disconnect to server or leave from the server as client
     */
    void disconnect();
    
    /**
     * Sending the message to server or client
     *
     * @param message what message send to server or client
     * 
     * @see DataOutputStream
     * @see OutputStream
     */
    void sendMessage(String message);
    
    /**
     * Getting the message which sent from server or client
     * 
     * @see DataInputStream
     * @see InputStream
     */
    void recieveMessage();
    
}
