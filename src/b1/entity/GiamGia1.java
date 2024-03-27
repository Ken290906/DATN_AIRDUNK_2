/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class GiamGia1 {

    private String maVCH;
    private String maGiamGia;
    private int soLuong;
    private int giaTri;
    private float hanMuc;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private boolean deleted1;
    private Date createAt;
    private String createdBy;
    private Date updateAt;
    private String updateBy;
    private int trangThai;

    public GiamGia1() {
    }

    public GiamGia1(String maVCH, String maGiamGia, int soLuong, int giaTri, float hanMuc, Date ngayBatDau, Date ngayKetThuc, boolean deleted1, Date createAt, String createdBy, Date updateAt, String updateBy, int trangThai) {
        this.maVCH = maVCH;
        this.maGiamGia = maGiamGia;
        this.soLuong = soLuong;
        this.giaTri = giaTri;
        this.hanMuc = hanMuc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.deleted1 = deleted1;
        this.createAt = createAt;
        this.createdBy = createdBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.trangThai = trangThai;
    }

    public String getMaVCH() {
        return maVCH;
    }

    public void setMaVCH(String maVCH) {
        this.maVCH = maVCH;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public float getHanMuc() {
        return hanMuc;
    }

    public void setHanMuc(float hanMuc) {
        this.hanMuc = hanMuc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public boolean isDeleted1() {
        return deleted1;
    }

    public void setDeleted1(boolean deleted1) {
        this.deleted1 = deleted1;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "GiamGia1{" + "maVCH=" + maVCH + ", maGiamGia=" + maGiamGia + ", soLuong=" + soLuong + ", giaTri=" + giaTri + ", hanMuc=" + hanMuc + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", deleted1=" + deleted1 + ", createAt=" + createAt + ", createdBy=" + createdBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + ", trangThai=" + trangThai + '}';
    }
    
    
}