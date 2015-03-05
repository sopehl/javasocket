/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketproject;

/**
 *
 * @author semih
 */
public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client("localhost");
        client.connect(6066);
        client.recieveMessage();
        
    }
}
