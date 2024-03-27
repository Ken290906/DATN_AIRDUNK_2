/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.entity;

/**
 *
 * @author ADMIN
 */
public class nhanvien {

    public nhanvien() {
    }

    public nhanvien(String id, String ten, String ngaySinh, String diaChi, String sđt, String email) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sđt = sđt;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nhanvien{" + "id=" + id + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", s\u0111t=" + sđt + ", email=" + email + '}';
    }
    private String id;
    private String ten;
    private String ngaySinh;
    private String diaChi;
    private String sđt;
    private String email;
}
