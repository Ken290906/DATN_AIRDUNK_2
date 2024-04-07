/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.entity;

import java.util.Date;

/**
 *
 * @author Huanh
 */
public class HoaDonBH {

    private String maHD;
    private String MaKH;
    private String MaHTTT;
    private String MaVCH;
    private String TenSP;
    private double Tongtien;
    private Date ngaytao;
    private Date ngaythanh;
    private String maNV;
    private int soluong;
    private boolean trangthai;
    private int trangthai2;
    public HoaDonBH() {
    }

    public HoaDonBH(String maHD, Date ngaytao, String maNV, int soluong, boolean trangthai) {
        this.maHD = maHD;
        this.ngaytao = ngaytao;
        this.maNV = maNV;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public HoaDonBH(String maHD, Date ngaytao, Date ngaythanh, String maNV, int soluong, boolean trangthai) {
        this.maHD = maHD;
        this.ngaytao = ngaytao;
        this.ngaythanh = ngaythanh;
        this.maNV = maNV;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public HoaDonBH(String maHD, String MaKH, double Tongtien, Date ngaytao, Date ngaythanh, String maNV, int soluong, String MaHTTT, int trangthai2) {
        this.maHD = maHD;
        this.MaKH = MaKH;
        this.Tongtien = Tongtien;
        this.ngaytao = ngaytao;
        this.ngaythanh = ngaythanh;
        this.maNV = maNV;
        this.soluong = soluong;
        this.MaHTTT = MaHTTT;
        this.trangthai2 = trangthai2;

    }

    public int getTrangthai2() {
        return trangthai2;
    }

    public void setTrangthai2(int trangthai2) {
        this.trangthai2 = trangthai2;
    }


   

    public String getMaHD() {
        return maHD;
    }

    @Override
    public String toString() {
        return "HoaDonBH{" + "maHD=" + maHD + ", MaKH=" + MaKH + ", MaHTTT=" + MaHTTT + ", MaVCH=" + MaVCH + ", TenSP=" + TenSP + ", Tongtien=" + Tongtien + ", ngaytao=" + ngaytao + ", ngaythanh=" + ngaythanh + ", maNV=" + maNV + ", soluong=" + soluong + ", trangthai=" + trangthai + ", trangthai2=" + trangthai2 + '}';
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaHTTT() {
        return MaHTTT;
    }

    public void setMaHTTT(String MaHTTT) {
        this.MaHTTT = MaHTTT;
    }

    public String getMaVCH() {
        return MaVCH;
    }

    public void setMaVCH(String MaVCH) {
        this.MaVCH = MaVCH;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaythanh() {
        return ngaythanh;
    }

    public void setNgaythanh(Date ngaythanh) {
        this.ngaythanh = ngaythanh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

}
