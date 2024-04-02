/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import ViewModelSP.sanphamviewmodel;
import b1.entity.chitietsanpham;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class sanphamrepo {

    public List<sanphamviewmodel> getall() {
        List<sanphamviewmodel> list = new ArrayList<>();
        String sql = """
                SELECT        dbo.ChiTietSP.MaCTSP, dbo.DSP.TenDSP, dbo.ChiTietSP.Ghichu, dbo.ChiTietSP.Soluong, dbo.ChiTietSP.Trangthai
                                                                                         FROM            dbo.DSP INNER JOIN
                                                                                                                  dbo.ChiTietSP ON dbo.DSP.IDdsp = dbo.ChiTietSP.IDDongSP
                                                                                         						 Where ChiTietSP.Deleted = 0 ORDER BY MaCTSP DESC
                     """;
        try ( Connection c = DBConnect.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanphamviewmodel spvm = new sanphamviewmodel();
                spvm.setMasp(rs.getString(1));
                spvm.setTensp(rs.getString(2));
                spvm.setMota(rs.getString(3));
                spvm.setSoluong(rs.getInt(4));
                spvm.setTrangthai(rs.getString(5));
                list.add(spvm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<sanphamviewmodel> getAllGioHang() {
        List<sanphamviewmodel> listsanpham = new ArrayList<>();
        String sql = """
                     SELECT        dbo.ChiTietSP.MaCTSP, dbo.DSP.TenDSP, dbo.ChiTietSP.Soluong
                        FROM            dbo.ChiTietSP INNER JOIN
                                            dbo.DSP ON dbo.ChiTietSP.IDDongSP = dbo.DSP.IDdsp                                                                                                                                                                                    						 Where ChiTietSP.Deleted = '0' ORDER BY MaCTSP DESC
                     """;
        try ( Connection c = DBConnect.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanphamviewmodel sp = new sanphamviewmodel();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setSoluong(rs.getInt(3));
           
                listsanpham.add(sp);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return listsanpham;
    }

    public boolean add(chitietsanpham ctsp, String tensp) {
        int check = 0;
        String sql = """
           INSERT INTO [dbo].[ChiTietSP]
                      ([MaCTSP]
                      ,[IDDongSP]
                      ,[Ghichu]
                     
                      ,[Deleted]
                    
                      ,[Trangthai]
                      ,[Soluong])
                VALUES (?,(Select IDdsp from DSP where TenDSP = ?),?,?,?,?)
                     """;
        try ( Connection c = DBConnect.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getMasp());
            ps.setObject(2, tensp);
            ps.setObject(3, ctsp.getGhichu());
            ps.setObject(4, ctsp.getDelete());
            ps.setObject(5, ctsp.getTrangthai());
            ps.setObject(6, ctsp.getSoluong());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(String xoa) {
        int check = 0;
        String sql = """
       UPDATE [dbo].[ChiTietSP]
                          SET Deleted = 1
                             
                        WHERE MaCTSP = ?
                     """;
        try ( Connection c = DBConnect.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean sua(chitietsanpham ctsp, String tensp, String sua) {
        int check = 0;
        String sql = """
              UPDATE [dbo].[ChiTietSP]
               SET [MaCTSP] = ?
                  ,[IDDongSP] = (Select IDdsp from DSP where TenDSP = ?)
                 
                  ,[Ghichu] = ?
                  
                
                  
                  ,[Trangthai] = ?
                  ,[Soluong] = ?
             WHERE MaCTSP = ?
                     """;
        try ( Connection c = DBConnect.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getMasp());
            ps.setObject(2, tensp);
            ps.setObject(3, ctsp.getGhichu());
            ps.setObject(4, ctsp.getTrangthai());
            ps.setObject(5, ctsp.getSoluong());
            ps.setObject(6, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<sanphamviewmodel> Search(String timkiem) {
        List<sanphamviewmodel> list = new ArrayList<>();
        String sql = """
              SELECT        dbo.ChiTietSP.MaCTSP, dbo.DSP.TenDSP, dbo.ChiTietSP.Ghichu, dbo.ChiTietSP.Soluong, dbo.ChiTietSP.Trangthai
FROM            dbo.DSP INNER JOIN
dbo.ChiTietSP ON dbo.DSP.IDdsp = dbo.ChiTietSP.IDDongSP
                  Where ChiTietSP.Deleted = 0 AND MaCTSP LIKE ? or DSP.TenDSP LIKE ?
                     """;
        try ( Connection c = DBConnect.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setObject(1, '%' + timkiem + '%');
            ps.setObject(2, '%' + timkiem + '%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanphamviewmodel spvm = new sanphamviewmodel();
                spvm.setMasp(rs.getString(1));
                spvm.setTensp(rs.getString(2));
                spvm.setMota(rs.getString(3));
                spvm.setSoluong(rs.getInt(4));
                spvm.setTrangthai(rs.getString(5));
                list.add(spvm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<sanphamviewmodel> spvm = new sanphamrepo().getall();
        for (sanphamviewmodel object : spvm) {
            System.out.println(object.toString());
        }
    }
}
