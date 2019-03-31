/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Son
 */
public class ServerB1 {
    DatagramPacket packet;
    DatagramSocket socket;
            
    public static void main(String[] args) {
        ServerB1 s=new ServerB1();
        s.connect();
        String a=s.read();
        int b=Integer.parseInt(a);
        if(b==0) s.write("Không");
        else if(b==1) s.write("Một");
        else if(b==2) s.write("Hai");
        else if(b==3) s.write("Ba");
        else if(b==4) s.write("Bốn");
        else if(b==5) s.write("Năm");
        else if(b==6) s.write("Sáu");
        else if(b==7) s.write("Bảy");
        else if(b==8) s.write("Tám");
        else if(b==9) s.write("Chín");
        
    }
    public void connect(){
        try {
            socket =new DatagramSocket(3333);
        } catch (SocketException ex) {
            Logger.getLogger(ServerB1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void write(String a){
        byte gui[];
        gui=a.getBytes();
        packet=new DatagramPacket(gui, gui.length, packet.getAddress(), packet.getPort());
        try {
            socket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(ServerB1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String read(){
        byte nhan[]=new byte[256];
        packet=new DatagramPacket(nhan, nhan.length);
        try {
            socket.receive(packet);
            String data=(new String(packet.getData())).trim();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(ServerB1.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
