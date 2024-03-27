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
    private Date ngaytt;
    private int soluong;

    public HoaDonBH() {
    }

    public HoaDonBH(String maHD, Date ngaytao, Date ngaytt, int soluong) {
        this.maHD = maHD;
        this.ngaytao = ngaytao;
        this.ngaytt = ngaytt;
        this.soluong = soluong;
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

    public Date getNgaytt() {
        return ngaytt;
    }

    public void setNgaytt(Date ngaytt) {
        this.ngaytt = ngaytt;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", ngaytao=" + ngaytao + ", ngaytt=" + ngaytt + ", soluong=" + soluong + '}';
    }
    
    
    
    
}
