/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModelSP;

/**
 *
 * @author DELL
 */
public class sanphamviewmodel {
   private String masp;
   private String tensp;
   private String mota;
   private int soluong;
   private String trangthai;
   
    public sanphamviewmodel() {
    }

    public sanphamviewmodel(String masp, String tensp, String mota, int soluong, String trangthai) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "sanphamviewmodel{" + "masp=" + masp + ", tensp=" + tensp + ", mota=" + mota + ", soluong=" + soluong + ", trangthai=" + trangthai + '}';
    }
           

    
    
    
}
