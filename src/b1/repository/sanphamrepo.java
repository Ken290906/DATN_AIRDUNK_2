/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import ViewModelSP.sanphamviewmodel;
import b1.entity.DongSanPham;
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
             SELECT [IDdsp]
                                                                                                                                               ,[TenDSP]
                                                                                                                                               ,[Deleted]
                                                                                                                                               ,[Trangthai]
                                                                                                                                               ,[soluong]
                                                                                                                                               ,[mota]
                                                                                                                                           FROM [dbo].[DSP]
                                                                                                                                           Where Deleted = 0
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanphamviewmodel spvm = new sanphamviewmodel();
                spvm.setMasp(rs.getString(1));
                spvm.setTensp(rs.getString(2));
                spvm.setDelete(rs.getInt(3));
                spvm.setTrangthai(rs.getString(4));
                spvm.setSoluong(rs.getInt(5));
                spvm.setMota(rs.getString(6));
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
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
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

    public boolean add(DongSanPham dsp) {
        int check = 0;
        String sql = """
           INSERT INTO [dbo].[DSP]
                           ([IDdsp]
                           ,[TenDSP]
                           ,[Deleted]
                           ,[Trangthai]
                           ,[soluong]
                           ,[mota])
                     VALUES (?,?,?,?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, dsp.getIDdsp());
            ps.setObject(2, dsp.getTendsp());
            ps.setObject(3, dsp.getDelete());
            ps.setObject(4, dsp.getTrangthai());
            ps.setObject(5, dsp.getSoluong());
            ps.setObject(6, dsp.getMota());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(String xoa) {
        int check = 0;
        String sql = """
       UPDATE [dbo].[DSP]
                          SET Deleted = 1                           
                        WHERE IDdsp = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean sua(DongSanPham ctsp, String sua) {
        int check = 0;
        String sql = """
            UPDATE [dbo].[DSP]
                SET [TenDSP] = ?
                 
                   ,[mota] = ?
              WHERE IDdsp = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getTendsp());
            ps.setObject(2, ctsp.getMota());
            ps.setObject(3, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<sanphamviewmodel> Search(String timkiem) {
        List<sanphamviewmodel> list = new ArrayList<>();
        String sql = """
             SELECT [IDdsp]
                                                                 ,[TenDSP]
                                                                 ,[Deleted]
                                                                 ,[Trangthai]
                                                                 ,[soluong]
                                                                 ,[mota]
                                                             FROM [dbo].[DSP]
                                                         
                                              Where IDdsp LIKE ? or TenDSP LIKE ? OR Trangthai LIKE ? OR soluong LIKE ? OR mota LIKE ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setObject(1, '%' + timkiem + '%');
            ps.setObject(2, '%' + timkiem + '%');
            ps.setObject(3,  '%' + timkiem + '%');
            ps.setObject(4, '%' + timkiem + '%');
             ps.setObject(5, '%' + timkiem + '%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanphamviewmodel spvm = new sanphamviewmodel();
                spvm.setMasp(rs.getString(1));
                spvm.setTensp(rs.getString(2));
                spvm.setDelete(rs.getInt(3));
                spvm.setTrangthai(rs.getString(4));
                spvm.setSoluong(rs.getInt(5));
                spvm.setMota(rs.getString(6));
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
