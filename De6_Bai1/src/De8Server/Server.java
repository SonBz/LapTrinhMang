/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Son
 */
public class Server {
    public static void main(String[] args) {
        ArrayList<MatHang>list=new ArrayList<>();
        try {
            FileReader fr=new FileReader("mathang.txt");
            BufferedReader br=new BufferedReader(fr);
            String s="";
            while ((s=br.readLine())!=null) {                
                String a[]=s.split("\\$");
                MatHang mh=new MatHang(a[0], a[1], Integer.parseInt(a[2]));
                list.add(mh);
            }
            XuLy xl=new XuLy(list);
            LocateRegistry.createRegistry(1099);
            Naming.rebind("gameShow", xl); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
