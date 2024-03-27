/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.View.intefacee;

import ViewModelSP.sanphamchitietviewmodel;
import b1.entity.chitietsanpham;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface interfacesp {
    List<sanphamchitietviewmodel> getall();
    String Add(chitietsanpham ctsp);
    boolean Delelte(String xoa);
    boolean Update(chitietsanpham ctsp,String sua);
    List<sanphamchitietviewmodel> Search(String timkiem);
    boolean Excel(String xuatexcel); 
}
