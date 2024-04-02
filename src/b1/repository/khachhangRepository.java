/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import ViewModelKH.khachhangViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author BigTech
 */
public class khachhangRepository {

    public List<khachhangViewModel> getAll() {
        List<khachhangViewModel> list = new ArrayList<>();
        String sql = """
                  SELECT [MaKH]
                               ,[TenKhachHang]
                               ,[SDT]
                               ,[NgaySinh]
                               ,[GioiTinh]
                         
                           FROM [dbo].[KhachHang]  where Deleted = 0
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khachhangViewModel khModel = new khachhangViewModel();
                khModel.setMaKH(rs.getString(1));
                khModel.setTenKH(rs.getString(2));
                khModel.setSDT(rs.getString(3));
                khModel.setNgaySinh(rs.getDate(4));
                khModel.setIsGioiTinh(rs.getBoolean(5));

                list.add(khModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }public List<khachhangViewModel> getMaKH() {
        List<khachhangViewModel> list = new ArrayList<>();
        String sql = """
                  SELECT [MaKH]                                                                     
                           FROM [dbo].[KhachHang]  where Deleted = 0
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khachhangViewModel khModel = new khachhangViewModel();
                khModel.setMaKH(rs.getString(1));
                list.add(khModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    public List<khachhangViewModel> getTenKH() {
        List<khachhangViewModel> list = new ArrayList<>();
        String sql = """
                  SELECT  [TenKhachHang]                                                  
                           FROM [dbo].[KhachHang]  where Deleted = 0
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khachhangViewModel khModel = new khachhangViewModel();
                khModel.setTenKH(rs.getString(1));
                list.add(khModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public boolean add(b1.entity.khachhang kh1) {
        int check = 0;
        String sql = """
             INSERT INTO [dbo].[KhachHang]
                        ([MaKH]
                        ,[TenKhachHang]
                        ,[SDT]
                        ,[NgaySinh]
                        ,[GioiTinh]
                        ,[Deleted])
                            VALUES(?,?,?,?,?,?)
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh1.getMaKH());
            ps.setObject(2, kh1.getTenKH());
            ps.setObject(3, kh1.getSDT());
            ps.setObject(4, kh1.getNgaySinh());
            ps.setObject(5, kh1.getGioiTinh());
            ps.setObject(6, kh1.getDeleted());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public boolean xoa(String xoa) {
        int check = 0;
        String sql = """
                UPDATE [dbo].[KhachHang]
                         Set Deleted = 1
                         WHERE MaKH = ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public boolean sua(b1.entity.khachhang kh, String oldma) {
        int check = 0;
        String sql = """
                     UPDATE [dbo].[KhachHang]
                        SET 
                            [TenKhachHang] =?
                           ,[SDT] = ?
                           ,[NgaySinh] =?
                           ,[GioiTinh] = ?
                          
                      WHERE MaKH = ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getSDT());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getGioiTinh());
            ps.setObject(5, oldma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<khachhangViewModel> khList = new khachhangRepository().getAll();
        for (khachhangViewModel viewModel : khList) {
            System.out.println(viewModel.toString());

        }
    }

    public List<khachhangViewModel> Search(String type) {
        List<khachhangViewModel> list = new ArrayList<>();
        String sql = """
                     SELECT [MaKH]
                           ,[TenKhachHang]
                           ,[SDT]
                           ,[NgaySinh]
                           ,[GioiTinh]
                       FROM [dbo].[KhachHang]
                     
                       WHERE MaKH LIKE ? OR 
                             TenKhachHang LIKE ? OR 
                     		SDT LIKE ? OR
                     		NgaySinh LIKE ? OR
                     		GioiTinh LIKE ?;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 1; i <= 5; i++) {
                ps.setObject(i, type);

            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khachhangViewModel kh = new khachhangViewModel();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setSDT(rs.getString(3));
                kh.setNgaySinh(rs.getDate(4));
                kh.setIsGioiTinh(rs.getBoolean(5));
                list.add(kh);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<khachhangViewModel> Searchkhachhangbanhang(String timkiem) {
        List<khachhangViewModel> listsanpham = new ArrayList<>();
        String sql = """
SELECT [MaKH]
      ,[TenKhachHang]
      ,[SDT]
      ,[Deleted]
      ,[CreatedAt]
      ,[CreatedBy]
      ,[UpdatedAt]
      ,[UpdatedBy]
  FROM [dbo].[KhachHang]
  Where KhachHang.Deleted = 0 AND MaKH Like ? or TenKhachHang Like ? or SDT Like ? 
                       """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, '%' + timkiem + '%');
            ps.setObject(2, '%' + timkiem + '%');
            ps.setObject(3, '%' + timkiem + '%');

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khachhangViewModel khModel = new khachhangViewModel();
                khModel.setMaKH(rs.getString(1));
                khModel.setTenKH(rs.getString(2));
                khModel.setSDT(rs.getString(3));
                listsanpham.add(khModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsanpham;
    }
}
