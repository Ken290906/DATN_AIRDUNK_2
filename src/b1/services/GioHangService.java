/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import GioHangViewModel.GioHangViewMD;
import b1.entity.HDChiTiet;
import b1.repository.GioHangRepo;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class GioHangService {
    GioHangRepo repo = new GioHangRepo();
    
    public List<GioHangViewMD> getAll(String id) {
        return repo.getAll(id);
    }
    
    public boolean searchQR(HDChiTiet hdct, String QRCode) {
        return repo.searchQR(hdct, QRCode);
    }
}
