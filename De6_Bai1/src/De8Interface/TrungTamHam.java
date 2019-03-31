/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Nguyen Son
 */
public interface TrungTamHam extends Remote{
    public String spRanDOm() throws RemoteException;
    public String duDoan(String tensp,int gia) throws RemoteException;
}
