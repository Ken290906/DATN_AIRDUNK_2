/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;


import ViewModelHD.LichSuHD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huanh
 */
public class LichsuHDRepository {
    
    public List<LichSuHD> getAll() {
        List<LichSuHD> list = new ArrayList<>();
        
        String sql = """
                     SELECT        dbo.HoaDon.MaHD, dbo.NhanVien.MaNV, dbo.LichsuHD.Ngaytao, dbo.LichsuHD.Hanhdong, dbo.LichsuHD.MaLSHD
                     FROM            dbo.LichsuHD INNER JOIN
                                              dbo.NhanVien ON dbo.LichsuHD.IDNV = dbo.NhanVien.MaNV INNER JOIN
                                              dbo.HoaDon ON dbo.LichsuHD.IDHoaDon = dbo.HoaDon.MaHD AND dbo.NhanVien.MaNV = dbo.HoaDon.MaNV
                     """;
        try(Connection con = DBConnect.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                LichSuHD lshd = new LichSuHD();
                lshd.setMaHD(rs.getString(1));
                lshd.setManv(rs.getString(2));
                lshd.setNgaytao(rs.getDate(3));
                lshd.setHanhDong(rs.getString(4));
                lshd.setMaLSHD(rs.getString(5));
                
                list.add(lshd);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<LichSuHD> getAll(String maHD) {
        List<LichSuHD> list = new ArrayList<>();
        
        String sql = """
                     SELECT        dbo.HoaDon.MaHD, dbo.NhanVien.MaNV, dbo.LichsuHD.Ngaytao, dbo.LichsuHD.Hanhdong, dbo.LichsuHD.MaLSHD
                                              FROM            dbo.NhanVien INNER JOIN
                                                                       dbo.LichsuHD ON dbo.NhanVien.MaNV = dbo.LichsuHD.IDNV INNER JOIN
                                                                       dbo.HoaDon ON dbo.NhanVien.MaNV = dbo.HoaDon.MaNV AND dbo.LichsuHD.IDHoaDon = dbo.HoaDon.MaHD
                                              WHERE dbo.HoaDon.MaHD = ?
                                              GROUP BY dbo.HoaDon.MaHD, dbo.NhanVien.MaNV, dbo.LichsuHD.Ngaytao, dbo.LichsuHD.Hanhdong, dbo.LichsuHD.MaLSHD
                     """;
        try(Connection con = DBConnect.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                LichSuHD lshd = new LichSuHD();
                lshd.setMaHD(rs.getString(1));
                lshd.setManv(rs.getString(2));
                lshd.setNgaytao(rs.getDate(3));
                lshd.setHanhDong(rs.getString(4));
                lshd.setMaLSHD(rs.getString(5));
                
                list.add(lshd);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        List<LichSuHD> list = new LichsuHDRepository().getAll();
        
        for (LichSuHD lshd : list) {
            System.out.println(lshd.toString());
        }
    }
    
}
