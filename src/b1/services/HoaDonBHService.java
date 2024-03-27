/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.HoaDonBH;
import b1.repository.HDBanHangRepository;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class HoaDonBHService {
    HDBanHangRepository repo = new HDBanHangRepository();
    
    public List<HoaDonBH> getAll() {
        return repo.getAllBanHang();
    }
    
    public boolean Add(HoaDonBH hdbh) {
        return repo.Add(hdbh);
    }
}
