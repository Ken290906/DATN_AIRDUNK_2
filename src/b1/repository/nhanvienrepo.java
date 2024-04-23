/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import b1.entity.nhanvien;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class nhanvienrepo {

    public List<nhanvien> getAll() {
        List<nhanvien> list = new ArrayList<>();
        String sql = """
                     SELECT [MaNV]
                             ,[TenNV]
                             ,[Ngaysinh]
                             ,[Diachinha]
                             ,[Sdt]
                             ,[Email]
                         FROM [dbo].[NhanVien]
                     Where  [Deleted] = 0
                     """;
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setId(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setNgaySinh(rs.getDate(3));
                nv.setDiaChi(rs.getString(4));
                nv.setSđt(rs.getString(5));
                nv.setEmail(rs.getString(6));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addNhanVien(nhanvien nv) {
        int check = 0;
        String sql = """
                     INSERT INTO [dbo].[NhanVien]
                                ([MaNV]
                                ,[TenNV]
                                ,[Ngaysinh]
                                ,[Diachinha]
                                ,[Sdt]
                                ,[Email]
                                ,[IDChucVu]
                                ,[Deleted]
                                ,[CreatedAt]
                                ,[CreatedBy]
                                ,[UpdatedAt]
                                ,[UpdatedBy]
                                )
                          VALUES
                                (?,?,?,?,?,?,'CV-001', 1, 2024-01-27, 'Phúc', 2024-01-30, 'Phúc')
                     """;
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getNgaySinh());
            ps.setObject(4, nv.getDiaChi());
            ps.setObject(5, nv.getSđt());
            ps.setObject(6, nv.getEmail());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateNhanVien(nhanvien nv, String oldid) {
        int check = 0;
        String sql = """
                     UPDATE [dbo].[NhanVien]
                        SET [MaNV] = ?
                           ,[TenNV] = ?
                           ,[Ngaysinh] = ?
                           ,[Diachinha] = ?
                           ,[Sdt] = ?
                           ,[Email] = ?
                      WHERE MaNV LIKE ?
                     """;
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getNgaySinh());
            ps.setObject(4, nv.getDiaChi());
            ps.setObject(5, nv.getSđt());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, oldid);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteNhanVien(String id) {
        int check = 0;
        String sql = """
                UPDATE [dbo].[NhanVien]
                         SET 
                            [Deleted] = 1
                            
                       WHERE MaNV = ?
                     """;
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<nhanvien> Search(String type) {
        List<nhanvien> list = new ArrayList<>();
        String sql = """
                SELECT [MaNV]
                      ,[TenNV]
                      ,[Ngaysinh]
                      ,[Diachinha]
                      ,[Sdt]
                      ,[Email]
                FROM [dbo].[NhanVien]

                WHERE MaNV LIKE ? OR
                TenNV LIKE ? OR
		Ngaysinh LIKE ? OR
		Diachinha LIKE ? OR 
		Sdt LIKE ? OR
		Email LIKE ?;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, '%' + type + '%');
            ps.setObject(2, '%' + type + '%');
            ps.setObject(3, '%' + type + '%');
            ps.setObject(4, '%' + type + '%');
            ps.setObject(5, '%' + type + '%');
            ps.setObject(6, '%' + type + '%');
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    nhanvien nv = new nhanvien();
                    nv.setId(rs.getString(1));
                    nv.setTen(rs.getString(2));
                    nv.setNgaySinh(rs.getDate(3));
                    nv.setDiaChi(rs.getString(4));
                    nv.setSđt(rs.getString(5));
                    nv.setEmail(rs.getString(6));
                    list.add(nv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<nhanvien> list = new nhanvienrepo().getAll();
        for (nhanvien object : list) {
            System.out.println(object.toString());
        }
    }

}
