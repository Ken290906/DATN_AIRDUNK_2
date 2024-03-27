/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import ViewModelHD.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Huanh
 */
public class HDCTRepository {
    
    public List<HoaDonChiTiet> getAll() {
        
        List<HoaDonChiTiet> list = new ArrayList<>();
        
        String sql = """
                     SELECT        dbo.HoaDon.MaHD, dbo.ChiTietSP.MaCTSP, dbo.HoaDonChiTiet.DonGia, dbo.HoaDonChiTiet.Thanhtien
                     FROM            dbo.HoaDon INNER JOIN
                                              dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHoaDon INNER JOIN
                                              dbo.ChiTietSP ON dbo.HoaDonChiTiet.IDChiTietSP = dbo.ChiTietSP.MaCTSP
                     """;
        
        try(Connection con = DBConnect.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHD(rs.getString(1));
                hdct.setIdCTSP(rs.getString(2));
                hdct.setDonGia(rs.getFloat(3));
                hdct.setThanhTien(rs.getFloat(4));
                
                list.add(hdct);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
    
    public List<HoaDonChiTiet> getAll(String maHD) {
        
        List<HoaDonChiTiet> list = new ArrayList<>();
        
        String sql = """
                     SELECT        dbo.HoaDon.MaHD, dbo.ChiTietSP.MaCTSP, dbo.HoaDonChiTiet.DonGia, dbo.HoaDonChiTiet.Thanhtien
                                              FROM            dbo.ChiTietSP INNER JOIN
                                                                       dbo.HoaDonChiTiet ON dbo.ChiTietSP.MaCTSP = dbo.HoaDonChiTiet.IDChiTietSP INNER JOIN
                                                                       dbo.HoaDon ON dbo.HoaDonChiTiet.MaHoaDon = dbo.HoaDon.MaHD
                                              WHERE dbo.HoaDon.MaHD = ?
                                              GROUP BY dbo.HoaDonChiTiet.MaHDCT, dbo.HoaDon.MaHD, dbo.ChiTietSP.MaCTSP, dbo.HoaDonChiTiet.DonGia, dbo.HoaDonChiTiet.Thanhtien
                     """;
        
        try(Connection con = DBConnect.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHD(rs.getString(1));
                hdct.setIdCTSP(rs.getString(2));
                hdct.setDonGia(rs.getFloat(3));
                hdct.setThanhTien(rs.getFloat(4));
                
                list.add(hdct);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
    
    public static void main(String[] args) {
        List<HoaDonChiTiet> list = new HDCTRepository().getAll();
        
        for (HoaDonChiTiet hd : list) {
            System.out.println(hd.toString());
        }
    }
    
}
