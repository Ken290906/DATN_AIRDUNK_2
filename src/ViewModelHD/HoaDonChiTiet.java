/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModelHD;

/**
 *
 * @author Huanh
 */
public class HoaDonChiTiet {
    
    private String maHDCT;
    private String maHD;
    private String idCTSP;
    private float donGia;
    private float thanhTien;
    
    

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHDCT, String maHD, String idCTSP, float donGia, float thanhTien) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.idCTSP = idCTSP;
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

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
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
        return "HoaDonChiTiet{" + "maHDCT=" + maHDCT + ", maHD=" + maHD + ", idCTSP=" + idCTSP + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }
    
    
    
    
}
