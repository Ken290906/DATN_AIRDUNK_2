/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import ViewModelSP.sanphamviewmodel;
import b1.entity.DongSanPham;
import b1.entity.chitietsanpham;

import b1.repository.sanphamrepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class chitietsanphamservices {

    private sanphamrepo listrp = new sanphamrepo();

    public List<sanphamviewmodel> getall() {
        return listrp.getall();
    }
    
    public List<sanphamviewmodel> getAllGioHang() {
        return listrp.getAllGioHang();
    }

    public String Add(DongSanPham ctsp) {
        if (ctsp == null) {
            return "Add không thành công";
        }
        listrp.add(ctsp);
        return "Add thành công";
               
    }

    public boolean Xoa(String xoa) {
        return listrp.xoa(xoa);
    }

    public boolean Sua(DongSanPham ctsp, String sua) {
        return listrp.sua(ctsp, sua);
    }
    public List<sanphamviewmodel> Search(String timkiem){
        return  listrp.Search(timkiem);
    }
}
