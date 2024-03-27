/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;
import b1.entity.SizeSanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class Sizerepo {
     public  List<SizeSanPham> getall(){
         List<SizeSanPham> listdsp = new ArrayList<>();
        String sql = """
                   SELECT [IDSize]
                             ,[SizeSP]
                             ,[Deleted]
                             ,[CreatedAt]
                             ,[CreatedBy]
                             ,[UpdatedAt]
                             ,[UpdatedBy]
                         FROM [dbo].[Size]
                     """;
        try (Connection c = DBConnect.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                SizeSanPham hsx = new SizeSanPham();
                hsx.setIDsize(rs.getString(1));
                hsx.setMasize(rs.getString(2));
                hsx.setDelete(rs.getBoolean(3));
                hsx.setCreatedat(rs.getDate(4));
                hsx.setCreateby(rs.getString(5));
                hsx.setUpdateat(rs.getDate(6));
                hsx.setUpdateby(rs.getString(7));
                listdsp.add(hsx);
            }
        } catch (Exception e) {
        }
        return listdsp;
    }
    public static void main(String[] args) {
        List<SizeSanPham> list = new Sizerepo().getall();
        for (SizeSanPham object : list) {
            System.out.println(object.toString());
        }
    }
}
