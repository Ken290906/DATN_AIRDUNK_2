/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.Matdesanpham;
import b1.repository.matderepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class matdeservices {
    private matderepo mdr = new matderepo();
    
    public List<Matdesanpham> getall(){
        return mdr.getall();
    }
}
