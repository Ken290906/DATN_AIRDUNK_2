/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;

import b1.entity.Chatlieusp;
import b1.entity.Daysp;
import b1.entity.Dodaysp;
import b1.entity.Matdesanpham;
import b1.entity.MauSanPham;
import b1.entity.ThuocTinh;
import b1.entity.hangsanxuat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class thuoctinhrepo {

    public List<ThuocTinh> getall() {
        List<ThuocTinh> listhuoctinh = new ArrayList<>();
        String sql = """
           SELECT [MaThuocTinh]
                               ,[TenThuocTinh]
                              
                           FROM [dbo].[ThuocTinh]
                         Where ThuocTinh.Deleted = 0
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh();
                tt.setMasp(rs.getString(1));
                tt.setTensp(rs.getString(2));
                listhuoctinh.add(tt);

            }

        } catch (Exception e) {
        }
        return listhuoctinh;
    }

    public List<hangsanxuat> gethsx() {
        List<hangsanxuat> listhsx = new ArrayList<>();
        String sql = """
                   SELECT [IDhsx]
                         ,[TenHang]
                     FROM [dbo].[HSX]
                     Where HSX.Deleted = 0
                   """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hangsanxuat hsx = new hangsanxuat();
                hsx.setIDhsx(rs.getString(1));
                hsx.setTenhang(rs.getString(2));
                listhsx.add(hsx);

            }
        } catch (Exception e) {
        }
        return listhsx;
    }

    public List<Chatlieusp> getchatlieu() {
        List<Chatlieusp> list = new ArrayList<>();
        String sql = """
                    SELECT [IDChatlieu]
                           ,[ChatlieuSP]
                       
                       FROM [dbo].[ChatLieu]
                     Where ChatLieu.Deleted = 0
                     
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chatlieusp cl = new Chatlieusp();
                cl.setIdchatlieu(rs.getString(1));
                cl.setChatlieusp(rs.getString(2));
                list.add(cl);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Daysp> getday() {
        List<Daysp> list = new ArrayList<>();

        String sql = """
                   SELECT [IDDay]
                           ,[dAYsp]
                         
                       FROM [dbo].[Dayy]
                     Where Dayy.Deleted = 0
                     """;

        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Daysp day = new Daysp();
                day.setIDday(rs.getString(1));
                day.setDaysp(rs.getString(2));
                list.add(day);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MauSanPham> getmausp() {
        List<MauSanPham> list = new ArrayList<>();
        String sql = """
                      SELECT [IDMau]
                            ,[TenMau]
                           
                        FROM [dbo].[PhoiMau]
                     Where PhoiMau.Deleted = 0
                      """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSanPham msp = new MauSanPham();
                msp.setIdmau(rs.getString(1));
                msp.setTenmau(rs.getString(2));
                list.add(msp);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Dodaysp> getdoday() {
        List<Dodaysp> list = new ArrayList<>();
        String sql = """
                     SELECT [IDDoday]
                            ,[doDaySP]
                          
                        FROM [dbo].[DoDay]
                     Where DoDay.Deleted = 0
                      """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dodaysp dd = new Dodaysp();
                dd.setIDdoday(rs.getString(1));
                dd.setDoday(rs.getString(2));
                list.add(dd);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Matdesanpham> getmatde() {
        List<Matdesanpham> list = new ArrayList<>();
        String sql = """
                     SELECT [IDMatDe]
                            ,[MatDeSP]
                         
                        FROM [dbo].[MatDe]
                     Where MatDe.Deleted = 0
                      """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Matdesanpham md = new Matdesanpham();
                md.setIDmatde(rs.getString(1));
                md.setMatde(rs.getString(2));
                list.add(md);

            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean Add(ThuocTinh tt) {
        int check = 0;
        String sql = """
                    INSERT INTO [dbo].[ThuocTinh]
                                  ([MaThuocTinh]
                                  ,[TenThuocTinh]
                                   ,[Deleted])
                            VALUES (?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, tt.getMasp());
            ps.setObject(2, tt.getTensp());
            ps.setObject(3, tt.getDelete());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean Addhsx(hangsanxuat hsx) {
        int check = 0;
        String sql = """
                 INSERT INTO [dbo].[HSX]
                                       ([IDhsx]
                                       ,[TenHang]
                                       ,[Deleted])
                                 VALUES
                                       (?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hsx.getIDhsx());
            ps.setObject(2, hsx.getTenhang());
            ps.setObject(3, hsx.getDelete());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean Addchatlieu(Chatlieusp cl) {
        int check = 0;
        String sql = """
                     INSERT INTO [dbo].[ChatLieu]
                                ([IDChatlieu]
                                ,[ChatlieuSP]
                                ,[Deleted])
                             
                          VALUES (?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, cl.getIdchatlieu());
            ps.setObject(2, cl.getChatlieusp());
            ps.setObject(3, cl.getDelete());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean addday(Daysp day) {
        int check = 0;
        String sql = """
                  INSERT INTO [dbo].[Dayy]
                                     ([IDDay]
                                     ,[dAYsp]
                                     ,[Deleted])
                                    
                               VALUES (?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, day.getIDday());
            ps.setObject(2, day.getDaysp());
            ps.setObject(3, day.getDelete());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean addmau(MauSanPham msp) {
        int check = 0;
        String sql = """
                 INSERT INTO [dbo].[PhoiMau]
                                          ([IDMau]
                                          ,[TenMau]
                                          ,[Deleted])
                                          
                                    VALUES (?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, msp.getIdmau());
            ps.setObject(2, msp.getTenmau());
            ps.setObject(3, msp.getDelete());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean addoday(Dodaysp dd) {
        int check = 0;
        String sql = """
                INSERT INTO [dbo].[DoDay]
                                               ([IDDoday]
                                               ,[doDaySP]
                                               ,[Deleted])
                                               
                                         VALUES (?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, dd.getIDdoday());
            ps.setObject(2, dd.getDoday());
            ps.setObject(3, dd.getDelete());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean addmd(Matdesanpham md) {
        int check = 0;
        String sql = """
               INSERT INTO [dbo].[MatDe]
                                                    ([IDMatDe]
                                                    ,[MatDeSP]
                                                    ,[Deleted]
                                                   )
                                              VALUES (?,?,?)
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, md.getIDmatde());
            ps.setObject(2, md.getMatde());
            ps.setObject(3, md.getDelete());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean Xoa(String xoa) {
        int check = 0;
        String sql = """
                    UPDATE [dbo].[ThuocTinh]
                                                           SET Deleted = 1
                                                         WHERE MaThuocTinh = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public boolean Xoahsx(String xoa) {
        int check = 0;
        String sql = """
                UPDATE [dbo].[HSX]
                                                             SET Deleted = 1
                                                           WHERE IDhsx = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public boolean Xoachatlieu(String xoa) {
        int check = 0;
        String sql = """
                   UPDATE [dbo].[ChatLieu]
                                                             SET Deleted = 1
                                                           WHERE IDChatlieu = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public boolean Xoamau(String xoa) {
        int check = 0;
        String sql = """
                 UPDATE [dbo].[PhoiMau]
                                                             SET Deleted = 1
                                                           WHERE PhoiMau.IDMau = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public boolean Xoadoday(String xoa) {
        int check = 0;
        String sql = """
               UPDATE [dbo].[DoDay]
                                                             SET Deleted = 1
                                                           WHERE IDDoday = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public boolean Xoamatde(String xoa) {
        int check = 0;
        String sql = """
             UPDATE [dbo].[MatDe]
                                                             SET Deleted = 1
                                                           WHERE IDMatDe = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public boolean Xoaday(String xoa) {
        int check = 0;
        String sql = """
                  UPDATE [dbo].[Dayy]
                                                             SET Deleted = 1
                                                           WHERE IDDay = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, xoa);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return check > 0;
    }

    public boolean Update(ThuocTinh tt, String update) {
        int check = 0;
        String sql = """
                  UPDATE [dbo].[ThuocTinh]
                            SET 
                               [TenThuocTinh] = ?
                              
                          WHERE MaThuocTinh = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setObject(1, tt.getTensp());
            ps.setObject(2, update);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean Updatehsx(String sua,hangsanxuat hsx){
        int check = 0;
        String sql = """
                UPDATE [dbo].[HSX]
                             SET [IDhsx] = ?
                                ,[TenHang] = ?
                               
                           WHERE IDhsx = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hsx.getIDhsx());
            ps.setObject(2, hsx.getTenhang());
                    ps.setObject(3, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean Updatedday(String sua,Daysp hsx){
        int check = 0;
        String sql = """
             UPDATE [dbo].[Dayy]
                              SET [IDDay] = ?
                                 ,[dAYsp] = ?
                                
                            WHERE IDDay = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hsx.getIDday());
            ps.setObject(2, hsx.getDaysp());
            ps.setObject(3, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean Updatemau(String sua,MauSanPham hsx){
        int check = 0;
        String sql = """
               UPDATE [dbo].[PhoiMau]
                              SET [IDMau] = ?
                                 ,[TenMau] = ?
                               
                            WHERE IDMau = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hsx.getIdmau());
            ps.setObject(2, hsx.getTenmau());
                    ps.setObject(3, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean Updatechatlieu(String sua,Chatlieusp hsx){
        int check = 0;
        String sql = """
             UPDATE [dbo].[ChatLieu]
                               SET [IDChatlieu] = ?
                                  ,[ChatlieuSP] = ?
                                 
                             WHERE IDChatlieu = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hsx.getIdchatlieu());
            ps.setObject(2, hsx.getChatlieusp());
            ps.setObject(3, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
      public boolean Updatedoday(String sua,Dodaysp hsx){
        int check = 0;
        String sql = """
          UPDATE [dbo].[DoDay]
                                SET [IDDoday] = ?
                                   ,[doDaySP] = ?
                              WHERE IDDoday = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hsx.getIDdoday());
            ps.setObject(2, hsx.getDoday());
            ps.setObject(3, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
         public boolean Updatemd(String sua,Matdesanpham hsx){
        int check = 0;
        String sql = """
         UPDATE [dbo].[MatDe]
                                 SET [IDMatDe] = ?
                                    ,[MatDeSP] = ?
                                  
                               WHERE IDMatDe = ?
                     """;
        try (Connection c = DBConnect.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setObject(1, hsx.getIDmatde());
            ps.setObject(2, hsx.getMatde());
            ps.setObject(3, sua);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
      
    public static void main(String[] args) {
        List<ThuocTinh> listtt = new thuoctinhrepo().getall();
        for (ThuocTinh thuocTinh : listtt) {
            System.out.println(thuocTinh.toString());
        }
    }
}
