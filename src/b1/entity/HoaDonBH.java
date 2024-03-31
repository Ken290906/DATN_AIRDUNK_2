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
    private Date ngaytao;
    private String maNV;
    private int soluong;
    private boolean trangthai;

    public HoaDonBH() {
    }

    public HoaDonBH(String maHD, Date ngaytao, String maNV, int soluong, boolean trangthai) {
        this.maHD = maHD;
        this.ngaytao = ngaytao;
        this.maNV = maNV;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
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

    @Override
    public String toString() {
        return "HoaDonBH{" + "maHD=" + maHD + ", ngaytao=" + ngaytao + ", maNV=" + maNV + ", soluong=" + soluong + ", trangthai=" + trangthai + '}';
    }

    
    
    
    
}
