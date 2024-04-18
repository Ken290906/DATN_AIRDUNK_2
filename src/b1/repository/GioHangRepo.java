/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import GioHangViewModel.GioHangViewMD;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Huanh
 */
public class GioHangRepo {

    public List<GioHangViewMD> getAll(String id) {
        List<GioHangViewMD> listGH = new ArrayList<>();

        String sql = """
                   SELECT        dbo.ChiTietSP.MaCTSP, dbo.HoaDon.MaHD, dbo.HoaDonChiTiet.MaHDCT, dbo.DSP.TenDSP, dbo.HSX.TenHang, dbo.PhoiMau.TenMau, dbo.Size.SizeSP, dbo.ChatLieu.ChatlieuSP, dbo.Dayy.dAYsp, dbo.HoaDonChiTiet.SoLuong, 
                                            dbo.HoaDonChiTiet.DonGia
                   FROM            dbo.ChiTietSP INNER JOIN
                                            dbo.HoaDonChiTiet ON dbo.ChiTietSP.MaCTSP = dbo.HoaDonChiTiet.IDChiTietSP INNER JOIN
                                            dbo.HoaDon ON dbo.HoaDonChiTiet.MaHoaDon = dbo.HoaDon.MaHD INNER JOIN
                                            dbo.ChatLieu ON dbo.ChiTietSP.IDChatlieu = dbo.ChatLieu.IDChatlieu INNER JOIN
                                            dbo.Dayy ON dbo.ChiTietSP.IDDay = dbo.Dayy.IDDay INNER JOIN
                                            dbo.Size ON dbo.ChiTietSP.IDSize = dbo.Size.IDSize INNER JOIN
                                            dbo.PhoiMau ON dbo.ChiTietSP.IDPhoiMau = dbo.PhoiMau.IDMau INNER JOIN
                                            dbo.HSX ON dbo.ChiTietSP.IDHangSX = dbo.HSX.IDhsx INNER JOIN
                                            dbo.DSP ON dbo.ChiTietSP.IDDongSP = dbo.DSP.IDdsp
                where dbo.HoaDon.MaHD like ?
                   """;
        try (Connection con = new DBConnect().getConnection();  
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHangViewMD kh = new GioHangViewMD();
                
                kh.setMctsp(rs.getString(1));
                kh.setMaHD(rs.getString(2));
                kh.setMaHDCT(rs.getString(3));
                kh.setIddongsp(rs.getString(4));
                kh.setIdhangsx(rs.getString(5));
                kh.setIdphoimau(rs.getString(6));
                kh.setIdsize(rs.getString(7));
                kh.setIdchatlieu(rs.getString(8));
                kh.setIdday(rs.getString(9));
                kh.setSoluong(rs.getInt(10));
                kh.setGiaban(rs.getInt(11));
                listGH.add(kh);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return listGH;
    }
    
    
}
