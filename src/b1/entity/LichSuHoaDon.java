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
public class LichSuHoaDon {
    
    private String maLSHD;
    private String maHD;
    private String maNV;
    private String hanhDong;
    private Date ngayTao;

    public LichSuHoaDon() {
    }
    
    public LichSuHoaDon(String maLSHD, String maHD, String maNV) {
        this.maLSHD = maLSHD;
        this.maHD = maHD;
        this.maNV = maNV;
    }

    public LichSuHoaDon(String maLSHD, String maHD, String maNV, String hanhDong, Date ngayTao) {
        this.maLSHD = maLSHD;
        this.maHD = maHD;
        this.maNV = maNV;
        this.hanhDong = hanhDong;
        this.ngayTao = ngayTao;
    }

    public String getMaLSHD() {
        return maLSHD;
    }

    public void setMaLSHD(String maLSHD) {
        this.maLSHD = maLSHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(String hanhDong) {
        this.hanhDong = hanhDong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "LichSuHoaDon{" + "maLSHD=" + maLSHD + ", maHD=" + maHD + ", maNV=" + maNV + ", hanhDong=" + hanhDong + ", ngayTao=" + ngayTao + '}';
    }
    
    
    
    
}
