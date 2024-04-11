/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import b1.entity.HDChiTiet;
import b1.entity.HoaDonBH;
import b1.entity.LichSuHoaDon;
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
                     WHERE dbo.HoaDon.Deleted = 1 OR dbo.HoaDon.Deleted = 2
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBH hd = new HoaDonBH();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setSoluong(rs.getInt(3));
                hd.setNgaytao(rs.getDate(4));
                hd.setTrangthai2(rs.getFloat(5));

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<HoaDonBH> getAllID(String maHD) {
        List<HoaDonBH> list = new ArrayList<>();

        String sql = """
                    SELECT        dbo.HoaDon.MaHD, dbo.HoaDon.MaNV, dbo.HoaDon.Soluong, dbo.HoaDon.NgayTaoHoaDon, dbo.HoaDon.Deleted
                           FROM            dbo.HoaDon FULL JOIN dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHoaDon 
                                                      FULL JOIN dbo.LichsuHD ON dbo.HoaDon.MaHD = dbo.LichsuHD.IDHoaDon
                     WHERE dbo.HoaDon.MaHD = ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBH hd = new HoaDonBH();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setSoluong(rs.getInt(3));
                hd.setNgaytao(rs.getDate(4));
                hd.setTrangthai2(rs.getFloat(5));

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDonBH> searchHDBH(String maHD) {
        List<HoaDonBH> list = new ArrayList<>();

        String sql = """
                    SELECT        dbo.HoaDon.MaHD, dbo.HoaDon.MaNV, dbo.HoaDon.Soluong, dbo.HoaDon.NgayTaoHoaDon, dbo.HoaDon.Deleted
                           FROM            dbo.HoaDon FULL JOIN dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHoaDon 
                                                      FULL JOIN dbo.LichsuHD ON dbo.HoaDon.MaHD = dbo.LichsuHD.IDHoaDon
                     WHERE dbo.HoaDon.MaHD like ? OR
                           dbo.HoaDon.MaNV like ? OR
                           dbo.HoaDon.Soluong like ? OR
                           dbo.HoaDon.NgayTaoHoaDon like ?
                     AND dbo.HoaDon.Deleted = 0
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, '%' + maHD + '%');
            ps.setObject(2, '%' + maHD + '%');
            ps.setObject(3, '%' + maHD + '%');
            ps.setObject(4, '%' + maHD + '%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBH hd = new HoaDonBH();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setSoluong(rs.getInt(3));
                hd.setNgaytao(rs.getDate(4));
                hd.setTrangthai2(rs.getFloat(5));

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean Add(HoaDonBH hdbh, HDChiTiet hdct, LichSuHoaDon lshd) {
        int check = 0;

        String sqlHD = """
                    INSERT INTO [dbo].[HoaDon]
                                             ([MaHD]
                                             ,[MaNV]
                                             ,[Soluong]
                                             ,[NgayTaoHoaDon]
                                             ,[Deleted])
                                       VALUES
                                             (?, ?, ?, ?, ?)
                     """;
        
        String sqlHDCT = """
                    INSERT INTO [dbo].[HoaDonChiTiet]
                                                        ([MaHDCT]
                                                        ,[MaHoaDon])
                                                  VALUES
                                                        (?, ?)
                     """;
        
        String sqlLSHD = """
                    INSERT INTO [dbo].[LichsuHD]
                                                        ([MaLSHD]
                                                        ,[IDHoaDon]
                                                        ,[IDNV])
                                                  VALUES
                                                        (?, ?, ?)
                     """;
        try (Connection con = DBConnect.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sqlHD); 
                PreparedStatement ps1 = con.prepareStatement(sqlHDCT);
                PreparedStatement ps2 = con.prepareStatement(sqlLSHD)) {
            ps.setObject(1, hdbh.getMaHD());
            ps.setObject(2, hdbh.getMaNV());
            ps.setObject(3, hdbh.getSoluong());
            ps.setObject(4, hdbh.getNgaytao());
            ps.setObject(5, hdbh.getTrangthai2());
            check = ps.executeUpdate();
            
            ps1.setObject(1, hdct.getMaHDCT());
            ps1.setObject(2, hdct.getMaHD());
            check = ps1.executeUpdate();
            
            ps2.setObject(1, lshd.getMaLSHD());
            ps2.setObject(2, lshd.getMaHD());
            ps2.setObject(3, lshd.getMaNV());
            check = ps2.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean Delete(String maHD) {
        int check = 0;

        String sql = """
                    UPDATE [dbo].[HoaDon]
                                                      SET [Deleted] = 3
                                                   
                                                    WHERE MaHD = ? 
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maHD);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

     public boolean update(HoaDonBH hd, HDChiTiet hdct, LichSuHoaDon lshd, String MaVCH, String sua,String MaKH) {
        int check = 0;
        String sql = """
                  UPDATE [dbo].[HoaDon]
                   SET [MaNV] = ?
                      ,[MaKH] = (SELECT TOP 1 MaKH FROM KhachHang WHERE TenKhachhang = ?) 
                      ,[MaHTTT] = ?
                      ,[MaVCH] = (SELECT MaVCH FROM VCH WHERE MaGiamGia = ?)
                      ,[TenKH] = ?
                      ,[Soluong] = ?
                      ,[Tongtien] = ?
                      ,[DiachiKH] = ? 
                      ,[NgayThanhtoan] = ?
                      ,[NgayTaoHoaDon] = ?
                      ,[SdtKH] = ?
                      ,[Deleted] = ?
                 WHERE MaHD = ?   
                      """;
        
        String sqlHDCT = """
                         UPDATE [dbo].[HoaDonChiTiet]
                            SET [MaHDCT] = ?
                               ,[IDChiTietSP] = ?
                               ,[DonGia] = ?
                               ,[Thanhtien] = ?
                          WHERE MaHoaDon = ?
                         """;
        
        String sqlLSHD = """
                         UPDATE [dbo].[LichsuHD]
                            SET [MaLSHD] = ?
                               ,[IDNV] = ?
                               ,[Hanhdong] = ?
                               ,[Ngaytao] = ?
                          WHERE IDHoaDon = ?
                         """;
        
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hd.getMaNV());
            ps.setObject(2, MaKH);
            ps.setObject(3, hd.getMaHTTT());
            ps.setObject(4, MaVCH);
            ps.setObject(5, hd.getTenKH());
            ps.setObject(6, hd.getSoluong());
            ps.setObject(7, hd.getTongtien());
            ps.setObject(8, hd.getDiaChi());
            ps.setObject(9, hd.getNgaythanh());
            ps.setObject(10, hd.getNgaytao());
            ps.setObject(11, hd.getSdt());
            ps.setObject(12, hd.getTrangthai2());
            ps.setObject(13, sua);
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
