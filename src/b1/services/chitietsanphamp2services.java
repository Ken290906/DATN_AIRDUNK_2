/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import ViewModelSP.sanphamchitietviewmodel;
import b1.entity.chitietsanpham;
import b1.repository.chitietsanphamviewmodelRepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class chitietsanphamp2services {
    private chitietsanphamviewmodelRepo spr = new chitietsanphamviewmodelRepo();
    
    public List<sanphamchitietviewmodel> getall(){
        return spr.getall();
    }
    public String add(chitietsanpham ctsp){
        if (ctsp == null) {
            return "Add không thành công";
        }
       spr.Add(ctsp);
       return "Add thành công";
    }
    public boolean xoa(String xoa){
        return spr.Xoa(xoa);
    }
    public boolean exportToExcel(String filePath) {
        List<sanphamchitietviewmodel> hds = spr.getall();
        
        return spr.exportToExcel(hds, filePath);
    }
    public boolean Sua(chitietsanpham ctsp,String sua){
        return spr.Sua(ctsp, sua);
    }
//    public List<sanphamchitietviewmodel> Search(String timkiem){
//        return  spr.Search(timkiem);
//    }
    public List<sanphamchitietviewmodel> Searchbanhang(String timkiem){
        return  spr.Searchbanhang(timkiem);
    }
    
    public List<sanphamchitietviewmodel> searchQR(String QRCode) {
        return spr.searchQR(QRCode);
    }
    public List<sanphamchitietviewmodel> click(){
        return spr.clicksanpham();
    }
    public  List<sanphamchitietviewmodel> timgia(int gia1,int gia2){
        return spr.TIMGIA(gia1, gia2);
    }
}
