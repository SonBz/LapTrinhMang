/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeBai2Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Son
 */
public class Server {

    public static void main(String[] args) {
        //doc file
        ArrayList<MatHangBai2> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("mathangB2.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("\\$");
                MatHangBai2 mh = new MatHangBai2(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]));
                list.add(mh);
            }

            ServerSocket server = new ServerSocket(3333);
            Socket socket = server.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            int lc = 0;
            while (lc != 3) {
                lc = dis.readInt();
                switch (lc) {
                    case 1:
                        int count = 0;
                        s = dis.readUTF();

                        for (MatHangBai2 matHang : list) {

                            if (matHang.id.equals(s)) {
                                dos.writeUTF(matHang.hienThi());
                                count++;
                                break;
                            }

                        }
                        if (count == 0) {
                            dos.writeUTF("Mat Hang Khong Ton Tai " + s);
                        }

                        break;
                    case 2:
                        int lc1 = 0;
                        int sum=0;
                        String hoaDon="";
                        while (lc1 != 2) {
                            lc1 = dis.readInt();
                            switch (lc1) {
                                case 1:
                                    String idMh = dis.readUTF();
                                    int soLM = dis.readInt();
                                    for (MatHangBai2 mh : list) {
                                        if(mh.id.equals(idMh)){
                                            sum+= mh.giaBan*soLM;
                                            hoaDon +="Ten Hang :"+mh.tenHang+" | gia Ban :"+mh.giaBan+ 
                                                    " | So Luong Mua :"+soLM+" | Tong Tien :"+mh.giaBan*soLM+"\n";
                                        }
                                    }
                                    break;
                                case 2:
                                    dos.writeUTF(hoaDon);
                                    dos.writeInt(sum); 
                                    break;
                            }
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Bạn Chọn Sai Chọn Lại");
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
