/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.View.intefacee;

import ViewModelSP.sanphamchitietviewmodel;
import b1.entity.chitietsanpham;
import b1.repository.chitietsanphamviewmodelRepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public abstract class iterface2 implements interfacesp{
    chitietsanphamviewmodelRepo ctspr = new chitietsanphamviewmodelRepo();

    public iterface2() {
    }

    @Override
    public String Add(chitietsanpham ctsp) {
         if (ctsp == null) {
            return "Add không thành công";
        }
       ctspr.Add(ctsp);
       return "Add thành công";
    }
    

    

    @Override
    public boolean Delelte(String xoa) {
        return ctspr.Xoa(xoa);
    }

    @Override
    public boolean Excel(String xuatexcel) {
        List<sanphamchitietviewmodel> ec = ctspr.getall();
        return ctspr.exportToExcel(ec, xuatexcel);
    }

  

    @Override
    public List<sanphamchitietviewmodel> Search(String timkiem) {
        return ctspr.Search(timkiem);
    }

    @Override
    public boolean Update(chitietsanpham ctsp, String sua) {
        return ctspr.Sua(ctsp, sua);
    }

   

    @Override
    public List<sanphamchitietviewmodel> getall() {
        return ctspr.getall();
    }
    
    
    
}
