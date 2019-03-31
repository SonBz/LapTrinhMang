/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8Client;

import De8Interface.TrungTamHam;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Son
 */
public class Clien {
    public static void main(String[] args) {
        try {
            TrungTamHam tt=(TrungTamHam) Naming.lookup("rmi://localhost/gameShow");
            String tenSp=tt.spRanDOm();
            System.out.println("San Pham Du Doan :"+tenSp);
            int soLuot=1;
            while (soLuot<=7) {                
                 System.out.print("doan gia la thu "+soLuot+":");
                 int gia=new Scanner(System.in).nextInt();
                 String kq=tt.duDoan(tenSp, gia);
                 System.out.println(""+kq);
                 if(kq.equals("du doan chinh xac")){
                     return;
                 }
                 soLuot++;
            }
            System.out.println("Ban Da Doan Qua SO Luot");
        } catch (NotBoundException ex) {
            Logger.getLogger(Clien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Clien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Clien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
