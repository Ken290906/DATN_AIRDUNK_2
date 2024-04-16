/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.GiamGia1;
import b1.repository.giamGiaRepository;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class GiamGiaService {

    giamGiaRepository repo = new giamGiaRepository();

    public List<GiamGia1> getAll() {
        return repo.getAll();
    }
    
    public List<GiamGia1> cbbBH() {
        return repo.cbbBH();
    }
    
    public boolean add(GiamGia1 gg) {
        return repo.add(gg);
    }
    
    public boolean remove(String id) {
        return repo.remove(id);
    }
    
    public boolean updateData(GiamGia1 gg, String id) {
        return repo.updateData(gg, id);
    }
    
    public List<GiamGia1> Search(String timkiem) {
        return repo.Search(timkiem);
    }
    
    public List<GiamGia1> timTrangThai(int trangThai) {
        return repo.timTrangThai(trangThai);
    }
}
