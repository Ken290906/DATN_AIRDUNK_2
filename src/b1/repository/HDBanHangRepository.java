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
                    SELECT [MaHD]
                           ,[Soluong]
                           ,[NgayThanhtoan]
                           ,[NgayTaoHoaDon]
                       FROM [dbo].[HoaDon]
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBH hd = new HoaDonBH();
                hd.setMaHD(rs.getString(1));
                hd.setSoluong(rs.getInt(2));
                hd.setNgaytt(rs.getDate(3));
                hd.setNgaytao(rs.getDate(4));
                

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
                                  ,[Soluong]
                                  ,[NgayThanhtoan]
                                  ,[NgayTaoHoaDon])
                            VALUES
                                  (?, ?, ?, ?)
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hdbh.getMaHD());
            ps.setObject(2, hdbh.getSoluong());
            ps.setObject(3, hdbh.getNgaytt());
            ps.setObject(4, hdbh.getNgaytao());
            
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
