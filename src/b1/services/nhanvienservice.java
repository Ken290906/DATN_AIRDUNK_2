/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.nhanvien;
import b1.repository.nhanvienrepo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class nhanvienservice {
    nhanvienrepo repo = new nhanvienrepo();
    
    public List<nhanvien> getAll(){
        return repo.getAll();
    }
    
    public boolean addNhanVien(nhanvien nv){
        return repo.addNhanVien(nv);
    }
    
    public boolean updateNhanVien(nhanvien nv, String oldid){
        return repo.updateNhanVien(nv, oldid);
    }
    
    public boolean deleteNhanVien(String id){
        return repo.deleteNhanVien(id);
    }
    
    public List<nhanvien> Search(String type){
        return repo.Search(type);
    }
}
