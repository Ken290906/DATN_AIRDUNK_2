/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import ViewModelSP.sanphamviewmodel;
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

    public boolean Add(chitietsanpham ctsp, String Dongsp) {
        return listrp.add(ctsp, Dongsp);
    }

    public boolean Xoa(String xoa) {
        return listrp.xoa(xoa);
    }

    public boolean Sua(chitietsanpham ctsp, String tensp, String sua) {
        return listrp.sua(ctsp, tensp, sua);
    }
    public List<sanphamviewmodel> Search(String timkiem){
        return  listrp.Search(timkiem);
    }
}
