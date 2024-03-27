/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModelKH;

import java.util.Date;

/**
 *
 * @author BigTech
 */
public class khachhangViewModel {
    private String MaKH;
    private String TenKH;
    private String SDT;
    private Date NgaySinh;
    public boolean isGioiTinh;

    public khachhangViewModel() {
    }

    public khachhangViewModel(String MaKH, String TenKH, String SDT, Date NgaySinh, boolean isGioiTinh) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.isGioiTinh = isGioiTinh;
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

    public boolean isIsGioiTinh() {
        return isGioiTinh;
    }

    public void setIsGioiTinh(boolean isGioiTinh) {
        this.isGioiTinh = isGioiTinh;
    }

    @Override
    public String toString() {
        return "khachhangViewModel{" + "MaKH=" + MaKH + ", TenKH=" + TenKH + ", SDT=" + SDT + ", NgaySinh=" + NgaySinh + ", isGioiTinh=" + isGioiTinh + '}';
    }
    

}