/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import ViewModelHD.HoaDonChiTiet;
import b1.repository.HDCTRepository;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class HDCTService {
    
    HDCTRepository repo = new HDCTRepository();
    
    public List<HoaDonChiTiet> getAll() {
        return repo.getAll();
    }
    
    public List<HoaDonChiTiet> getAll(String maHD) {
        return repo.getAll(maHD);
    }
}
