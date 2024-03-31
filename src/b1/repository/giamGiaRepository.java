/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import b1.View.giamgia;
import b1.entity.GiamGia1;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class giamGiaRepository {

    public List<GiamGia1> getAll() {
        List<GiamGia1> listGiamGia = new ArrayList<>();
        String sql = """
                     SELECT [MaVCH]
                           ,[MaGiamGia]
                           ,[SoLuong]
                           ,[Giatri]
                           ,[giatritoida]
                           ,[NgayBD]
                           ,[NgayKT]
                           ,[trangThai]
                       FROM [dbo].[VCH]
                        WHERE Deleted = 0;
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiamGia1 gg = new GiamGia1();
                gg.setMaVCH(rs.getString(1));
                gg.setMaGiamGia(rs.getString(2));
                gg.setSoLuong(rs.getInt(3));
                gg.setGiaTri(rs.getInt(4));
                gg.setHanMuc(rs.getFloat(5));
                gg.setNgayBatDau(rs.getDate(6));
                gg.setNgayKetThuc(rs.getDate(7));
                gg.setTrangThai(rs.getInt(8));
                listGiamGia.add(gg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGiamGia;
    }

    public List<GiamGia1> cbbBH() {
        List<GiamGia1> listGiamGia = new ArrayList<>();
        String sql = """
                     SELECT [MaVCH]
                           ,[MaGiamGia]
                       FROM [dbo].[VCH]
                        WHERE Deleted = 0;
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiamGia1 gg = new GiamGia1();
                gg.setMaVCH(rs.getString(1));
                gg.setMaGiamGia(rs.getString(2));
                listGiamGia.add(gg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGiamGia;
    }

    public boolean add(GiamGia1 gg) {
        int check = 0;
        String sql = """
INSERT INTO [dbo].[VCH]
                                ([MaVCH]
                                ,[MaGiamGia]
                                ,[SoLuong]
                                ,[GiaTri]
                                ,[giatritoida]
                                ,[NgayBD]
                                ,[NgayKT] 
                                ,[Deleted]
                                ,[CreatedAt]
                                ,[CreatedBy]
                                ,[UpdatedAt]
                                ,[UpdatedBy]
                                ,[trangThai])
                          VALUES
                                (?,?,?,?,?,?,?,?,?,?,?,?,?)
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gg.getMaVCH());
            ps.setObject(2, gg.getMaGiamGia());
            ps.setObject(3, gg.getSoLuong());
            ps.setObject(4, gg.getGiaTri());
            ps.setObject(5, gg.getHanMuc());
            ps.setObject(6, gg.getNgayBatDau());
            ps.setObject(7, gg.getNgayKetThuc());
            ps.setObject(8, 0);
            ps.setObject(9, gg.getCreateAt());
            ps.setObject(10, gg.getCreatedBy());
            ps.setObject(11, gg.getUpdateAt());
            ps.setObject(12, gg.getUpdateBy());
            ps.setObject(13, gg.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean remove(String id) {
        int check = 0;
        String sql = """
                     UPDATE [dbo].[VCH]
                              SET
                                 Deleted = 1
                            WHERE MaVCH=?
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateData(GiamGia1 gg, String id) {
        int check = 0;
        if (gg == null) {
            return false;
        } else {
            String sql = """
                                UPDATE [dbo].[VCH]
                                                                    SET [MaGiamGia] = ?
                                                                       ,[SoLuong] = ?
                                                                       ,[Giatri] = ?
                                                                       ,[giatritoida] = ?
                                                                       ,[NgayBD] = ?
                                                                       ,[NgayKT] = ?
                                                                  WHERE [MaVCH] = ?
                   """;
            try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setObject(1, gg.getMaGiamGia());
                ps.setObject(2, gg.getSoLuong());
                ps.setObject(3, gg.getGiaTri());
                ps.setObject(4, gg.getHanMuc());
                ps.setObject(5, gg.getNgayBatDau());
                ps.setObject(6, gg.getNgayKetThuc());
                ps.setObject(7, gg.getMaVCH());
                check = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return check > 0;
        }
    }

    public List<GiamGia1> Search(String timkiem) {
        List<GiamGia1> listGiamGia = new ArrayList<>();
        String sql = """
                     SELECT [MaVCH]
                           ,[MaGiamGia]
                           ,[SoLuong]
                           ,[GiaTri]
                           ,[giatritoida]
                           ,[NgayBD]
                           ,[NgayKT]
                       FROM [dbo].[VCH]
                       Where MaVCH like ? or MaGiamGia like ? or SoLuong like ? or GiaTri like ? or giatritoida like ? or NgayBD like ? or NgayKT like ?
                      """;
        try ( Connection c = DBConnect.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, timkiem + "%");
            ps.setObject(2, timkiem + "%");
            ps.setObject(3, timkiem + "%");
            ps.setObject(4, timkiem + "%");
            ps.setObject(5, timkiem + "%");
            ps.setObject(6, timkiem + "%");
            ps.setObject(7, timkiem + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiamGia1 gg = new GiamGia1();
                gg.setMaVCH(rs.getString(1));
                gg.setMaGiamGia(rs.getString(2));
                gg.setSoLuong(rs.getInt(3));
                gg.setGiaTri(rs.getInt(4));
                gg.setHanMuc(rs.getFloat(5));
                gg.setNgayBatDau(rs.getDate(6));
                gg.setNgayKetThuc(rs.getDate(7));
                listGiamGia.add(gg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGiamGia;
    }

    public static void main(String[] args) {
        List<GiamGia1> list = new giamGiaRepository().getAll();

        for (GiamGia1 giamGia1 : list) {
            System.out.println(giamGia1.toString());
        }
    }
}
