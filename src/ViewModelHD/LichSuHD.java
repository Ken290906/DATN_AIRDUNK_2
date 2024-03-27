/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModelHD;

import java.util.Date;

/**
 *
 * @author Huanh
 */
public class LichSuHD {
    
    
    private String maHD;
    private String manv;
    private Date ngaytao;
    private String hanhDong;
    private String maLSHD;

    public LichSuHD() {
    }

    public LichSuHD(String maHD, String manv, Date ngaytao, String hanhDong, String maLSHD) {
        this.maHD = maHD;
        this.manv = manv;
        this.ngaytao = ngaytao;
        this.hanhDong = hanhDong;
        this.maLSHD = maLSHD;
    }

    
    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(String hanhDong) {
        this.hanhDong = hanhDong;
    }

    public String getMaLSHD() {
        return maLSHD;
    }

    public void setMaLSHD(String maLSHD) {
        this.maLSHD = maLSHD;
    }

    @Override
    public String toString() {
        return "LichSuHD{" + "maHD=" + maHD + ", manv=" + manv + ", ngaytao=" + ngaytao + ", hanhDong=" + hanhDong + ", maLSHD=" + maLSHD + '}';
    }

    
    
    
   
    
}
