/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.entity;

import java.util.Date;

/**
 *
 * @author BigTech
 */
public class khachhang {
    private String MaKH;
    private String TenKH;
    private String SDT;
    private Date NgaySinh;
    private Boolean GioiTinh;
    private int Deleted;

    public khachhang() {
    }

    public khachhang(String MaKH, String TenKH, String SDT, Date NgaySinh, Boolean GioiTinh, int Deleted) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.Deleted = Deleted;
    }

    public khachhang(String MaKH, String TenKH, String SDT, Boolean GioiTinh, int Deleted) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.Deleted = Deleted;
    }
    

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getDeleted() {
        return Deleted;
    }

    public void setDeleted(int Deleted) {
        this.Deleted = Deleted;
    }

    @Override
    public String toString() {
        return "khachhang{" + "MaKH=" + MaKH + ", TenKH=" + TenKH + ", SDT=" + SDT + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", Deleted=" + Deleted + '}';
    }

}