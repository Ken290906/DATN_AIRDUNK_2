/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.SizeSanPham;
import b1.repository.Sizerepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class sizeservices {
    private Sizerepo sr = new Sizerepo();
    
    public List<SizeSanPham> getall(){
        return sr.getall();
    }
}
