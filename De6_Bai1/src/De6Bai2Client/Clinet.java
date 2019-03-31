/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6Bai2Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Son
 */
public class Clinet {
    
     
    public static void main(String[] args) {
          try {
              Socket socket=new Socket("localhost",3333);
              DataInputStream dis =new DataInputStream(socket.getInputStream());
              DataOutputStream dos =new DataOutputStream(socket.getOutputStream());
              Scanner sn=new Scanner(System.in);
              int lc=0;
              String s="";
              while (lc!=3) {                  
                  System.out.println("++++++++++MENU++++++++");
                  System.out.println("Chọn 1:TÌm Kiếm Theo Mã Hàng");
                  System.out.println("Chọn 2:Lậ Hóa Đơn Thanh Toán");
                  
                  System.out.print("Bạn Chọn :");
                   lc=Integer.parseInt(sn.nextLine());
                   dos.writeInt(lc); 
                   switch(lc){
                       case 1:
                           System.out.print("Nhập Mã Hàng :");
                           String mh=sn.nextLine();
                           dos.writeUTF(mh); 
                           System.out.println(""+dis.readUTF());
                           break;
                       case 2:
                           int lc1=0;                         
                           while (lc1!=2) {                               
                               System.out.println("\t----Lap Hoa Don-----");
                               System.out.println("\tChon 1:Nhap Mat Hang Va So Luong Mua");
                               System.out.println("\tChon 2:Hoa Don Va Tong Tien Thanh Toan");
                               System.out.print("ban Chon :");
                               lc1=Integer.parseInt(sn.nextLine());
                               dos.writeInt(lc1); 
                               switch(lc1){
                                   case 1:
                                       System.out.print("Nhap Ma Hang:");
                                       String idMh =sn.nextLine();
                                       System.out.print("Nhap So Luong Mua :");
                                       int soLM=Integer.parseInt(sn.nextLine());
                                       dos.writeUTF(idMh);
                                       dos.writeInt(soLM); 
                                       break;
                                   case 2:
                                       System.out.println(dis.readUTF());
                                       System.out.println("Tong Tien :"+dis.readInt());
                                       break;
                                    default:
                                        System.out.println("nhap lai");
                                       break;
                               }
                           }
                           break;
                       default:
                           System.out.println("Bạn Chọn Sai Chọn Lại");
                           break;
                   }
              }
          } catch (IOException ex) {
              Logger.getLogger(Clinet.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
}    