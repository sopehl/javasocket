/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketproject;

import java.util.Scanner;

/**
 *
 * @author semih
 */
public class ServerTest {
    public static void main(String[] args) {
        Server s = new Server();
        s.connect(6066);
        
        Scanner scan = new Scanner(System.in);
        
        while(true){
            System.out.println("Send it:");
            s.sendMessage(scan.nextLine());
        }
    }
}
