/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import ViewModelHD.LichSuHD;
import b1.repository.LichsuHDRepository;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class LichsuHDService {
    
    LichsuHDRepository repo = new LichsuHDRepository();
    
    public List<LichSuHD> getAll() {
        return repo.getAll();
    }

    public List<LichSuHD> getAll(String maHD) {
        return repo.getAll(maHD);
    }
    
}
