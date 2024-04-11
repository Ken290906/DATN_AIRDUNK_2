/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.entity;

/**
 *
 * @author Huanh
 */
public class HDChiTiet {
    private String maHDCT;
    private String maHD;
    private String maCTSP;
    private float donGia;
    private float thanhTien;

    public HDChiTiet() {
    }

    public HDChiTiet(String maHDCT, String maHD) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
    }
    
    public HDChiTiet(String maHDCT, String maHD, String maCTSP, float donGia, float thanhTien) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.maCTSP = maCTSP;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "HDChiTiet{" + "maHDCT=" + maHDCT + ", maHD=" + maHD + ", maCTSP=" + maCTSP + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }
    
    
    
}
