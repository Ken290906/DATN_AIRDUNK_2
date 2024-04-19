/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.HDChiTiet;
import b1.entity.HoaDonBH;
import b1.entity.LichSuHoaDon;
import b1.entity.chitietsanpham;
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

    public List<HoaDonBH> getAllID(String maHD) {
        return repo.getAllID(maHD);
    }

    public List<HoaDonBH> searchHDBH(String maHD) {
        return repo.searchHDBH(maHD);
    }

    public boolean Add(HoaDonBH hdbh, LichSuHoaDon lshd) {
        return repo.Add(hdbh, lshd);
    }

    public boolean Delete(String maHD, String maHD1, String maHD2) {
        return repo.Delete(maHD, maHD1, maHD2);
    }

    public boolean DeleteGH(String idHDCT) {
        return repo.DeleteGH(idHDCT);
    }

    public String UpdateBanhang(HoaDonBH hd, LichSuHoaDon lshd, String MaVCH, String sua, String sua2, String MaKH) {
        if (hd == null || lshd == null || MaVCH == null || sua == null || sua2 == null || MaKH == null) {
            return "Ko thành công";
        }
        repo.update(hd, lshd, MaVCH, sua, sua2, MaKH);
        return "Đã xuất lên giỏ hàng";
    }

    public String AddSPGH(HDChiTiet hdct) {
        if (hdct == null) {
            return "Ko đủ đk để thêm sp vào giỏ hàng";
        }
        repo.AddSPGH(hdct);
        return "Đã thêm vào giỏ hàng";
    }
    public boolean UpdateSL(int soluong,String id){
         return repo.UpdateSL(soluong, id);
     }
     public boolean addHDCT(String idHD, String idSPCT, int soLuong, double giaBan){
         return  repo.addHDCT(idHD, idSPCT, soLuong, giaBan);
     }
     public boolean updateHDCT(String idHD, int soLuong, String idCTSP){
         return repo.updateHDCT(idHD, soLuong, idCTSP);
     }
     public boolean updateSP(int idSPCT, int soLuongConLai){
         return repo.updateSP(idSPCT, soLuongConLai);
     }

}
