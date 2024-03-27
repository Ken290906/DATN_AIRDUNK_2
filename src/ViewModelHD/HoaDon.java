/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModelHD;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class HoaDon {
    
    private String maHD;
    private String tenKH;
    private float tongTien;
    private String diaChi;
    private String maHTTT;
    private Date ngayTT;
    private Date ngaytaoHD;
    private int sdtKH;
    private int trangThai;
    private List<HoaDonChiTiet> chiTiet;

    public List<HoaDonChiTiet> getChiTiet() {
        return chiTiet;
    }
    
    public HoaDon() {
    }

    public HoaDon(String maHD, String tenKH, float tongTien, String diaChi, String maHTTT, Date ngayTT, Date ngaytaoHD, int sdtKH, int trangThai, List<HoaDonChiTiet> chiTiet) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.tongTien = tongTien;
        this.diaChi = diaChi;
        this.maHTTT = maHTTT;
        this.ngayTT = ngayTT;
        this.ngaytaoHD = ngaytaoHD;
        this.sdtKH = sdtKH;
        this.trangThai = trangThai;
        this.chiTiet = chiTiet;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(Date ngayTT) {
        this.ngayTT = ngayTT;
    }

    public Date getNgaytaoHD() {
        return ngaytaoHD;
    }

    public void setNgaytaoHD(Date ngaytaoHD) {
        this.ngaytaoHD = ngaytaoHD;
    }

    public int getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(int sdtKH) {
        this.sdtKH = sdtKH;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHTTT() {
        return maHTTT;
    }

    public void setMaHTTT(String maHTTT) {
        this.maHTTT = maHTTT;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", tenKH=" + tenKH + ", tongTien=" + tongTien + ", diaChi=" + diaChi + ", maHTTT=" + maHTTT + ", ngayTT=" + ngayTT + ", ngaytaoHD=" + ngaytaoHD + ", sdtKH=" + sdtKH + ", trangThai=" + trangThai + ", chiTiet=" + chiTiet + '}';
    }
  
 
}
