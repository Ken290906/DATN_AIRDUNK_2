/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import b1.entity.HoaDonBH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class HDBanHangRepository {

    public List<HoaDonBH> getAllBanHang() {
        List<HoaDonBH> list = new ArrayList<>();

        String sql = """
                    SELECT        dbo.HoaDon.MaHD, dbo.HoaDon.MaNV, dbo.HoaDon.Soluong, dbo.HoaDon.NgayTaoHoaDon, dbo.HoaDon.Deleted
                           FROM            dbo.HoaDon FULL JOIN dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHoaDon 
                                                      FULL JOIN dbo.LichsuHD ON dbo.HoaDon.MaHD = dbo.LichsuHD.IDHoaDon
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBH hd = new HoaDonBH();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setSoluong(rs.getInt(3));
                hd.setNgaytao(rs.getDate(4));
                hd.setTrangthai(rs.getBoolean(5));

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean Add(HoaDonBH hdbh) {
        int check = 0; 

        String sql = """
                    INSERT INTO [dbo].[HoaDon]
                                             ([MaHD]
                                             ,[MaNV]
                                             ,[Soluong]
                                             ,[NgayTaoHoaDon]
                                             ,[Deleted])
                                       VALUES
                                             (?, ?, ?, ?, ?)
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hdbh.getMaHD());
            ps.setObject(2, hdbh.getMaNV());
            ps.setObject(3, hdbh.getSoluong());
            ps.setObject(4, hdbh.getNgaytao());
            ps.setObject(5, hdbh.isTrangthai());
           
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean Delete(String maHD) {
        int check = 0; 

        String sql = """
                    DELETE FROM [dbo].[HoaDon]
                                                   WHERE MaHD = ?
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maHD);
           
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<HoaDonBH> list = new HDBanHangRepository().getAllBanHang();

        for (HoaDonBH hoaDonBH : list) {
            System.out.println(hoaDonBH.toString());
        }
    }
}
