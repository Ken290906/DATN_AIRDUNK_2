/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import ViewModelHD.HoaDon;
import ViewModelHD.HoaDonChiTiet;
import b1.repository.HDCTRepository;
import b1.repository.HoaDonRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class HoaDonService {
    
    HoaDonRepository repo = new HoaDonRepository();
    HDCTRepository repo1 = new HDCTRepository();
    
    public List<HoaDon> getAll() {
        return repo.getAll();
    }
    
//    public List<HoaDon> getAll(String maHD) {
//        return repo.getAll(maHD);
//    }
    
    public List<HoaDon> searchHoaDon(String maHD) {
        return repo.searchHoaDon(maHD);
    }
    
   
    public boolean exportToExcel(String filePath) {
        List<HoaDon> hds = repo.getAll();
        List<HoaDonChiTiet> hdct = repo1.getAll();
        
        return repo.exportToExcel(hds, hdct, filePath);
    }
    
    public List<HoaDon> searchGia(int min, int max) {
        return repo.searchGia(min, max);
    }
    
    public List<HoaDon> searchQR(String qrCode) {
        return repo.searchQR(qrCode);
    }
}
