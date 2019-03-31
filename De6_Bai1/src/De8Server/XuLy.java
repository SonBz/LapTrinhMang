/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8Server;

import De8Interface.TrungTamHam;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nguyen Son
 */
public class XuLy extends UnicastRemoteObject implements TrungTamHam{

    ArrayList<MatHang> list;
    public XuLy(ArrayList<MatHang> listMh) throws RemoteException {
        super();
        list=listMh;
    }
    
    @Override
    public String spRanDOm() throws RemoteException {
        Random rd=new Random();
        int i=rd.nextInt(list.size());
        return list.get(i).tenHang;
    }

    @Override
    public String duDoan(String tensp, int gia) throws RemoteException {
      for(MatHang mh:list){
          if(mh.tenHang.equals(tensp)){
              if(gia>mh.gia){
                  return "Du Doan Cao";
              }
              if(gia<mh.gia){
                  return "du doan thap";
              }
              return "du doan chinh xac";
          }
      }
      return "";
    }
    
}
