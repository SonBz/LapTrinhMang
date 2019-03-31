/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeBai2Server;

/**
 *
 * @author Nguyen Son
 */
public class MatHangBai2 {
    public String id;
    public String tenHang;
    public int giaBan;
    public int soLTK;

    public MatHangBai2() {
    }

    
    public MatHangBai2(String id, String tenHang, int giaBan, int soLTK) {
        this.id = id;
        this.tenHang = tenHang;
        this.giaBan = giaBan;
        this.soLTK = soLTK;
    }
    public String hienThi(){
        return "Ma Hang :"+id +" | Ten Hang :"+tenHang+" | Gia Ban :"+giaBan+" | So TOn Kho :"+soLTK;
    }
}
