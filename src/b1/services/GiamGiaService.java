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
    
    public boolean add(GiamGia1 gg){
        return repo.add(gg);
    }
    
    public boolean remove(String id) {
       return repo.remove(id);
    }
     
    public boolean updateData(GiamGia1 gg, String id) {
        return repo.updateData(gg, id);
    }
    
    public List<GiamGia1> Search(String timkiem,String tiemkiem1) {
        return repo.Search(timkiem);
    }
}
