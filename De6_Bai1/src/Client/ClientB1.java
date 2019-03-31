/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.sun.swing.internal.plaf.basic.resources.basic;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Son
 */
public class ClientB1 {
    DatagramSocket socket;
    DatagramPacket packet;
    public static void main(String[] args) {
        ClientB1 c=new ClientB1();
        c.connect();
        System.out.print("Nhap So :");
        int a=new Scanner(System.in).nextInt();      
        c.write(a+"");
        System.out.println("Ket Qua :"+c.read());
                
    }
    public void connect(){
        try {
            socket=new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(ClientB1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void write(String a){
        byte gui[];
        gui=a.getBytes();
        try {
            packet=new DatagramPacket(gui, gui.length, InetAddress.getByName("localhost"), 3333);
            socket.send(packet); 
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientB1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientB1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String read(){
        byte nhan[]=new byte[256];
        packet=new DatagramPacket(nhan, nhan.length);
        try {
            socket.receive(packet);
            String data=(new String(packet.getData(),0,packet.getLength()));
            return data;
        } catch (IOException ex) {
            Logger.getLogger(ClientB1.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
