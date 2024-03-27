/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;
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
public class hangsanxuatrepo {
    public  List<hangsanxuat> getall(){
        List<hangsanxuat> listhsx = new ArrayList<>();
        String sql = """
                     SELECT [IDhsx]
                           ,[TenHang]
                           ,[Deleted]
                           ,[CreatedAt]
                           ,[CreatedBy]
                           ,[UpdatedAt]
                           ,[UpdatedBy]
                       FROM [dbo].[HSX]
                     """;
        try (Connection c = DBConnect.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                hangsanxuat hsx = new hangsanxuat();
                hsx.setIDhsx(rs.getString(1));
                hsx.setTenhang(rs.getString(2));
                hsx.setDelete(rs.getInt(3));
                hsx.setCreatedat(rs.getDate(4));
                hsx.setCreateby(rs.getString(5));
                hsx.setUpdateat(rs.getDate(6));
                hsx.setUpdateby(rs.getString(7));
                listhsx.add(hsx);
            }
        } catch (Exception e) {
        }
        return listhsx;
    }
    public static void main(String[] args) {
        List<hangsanxuat> list = new hangsanxuatrepo().getall();
        for (hangsanxuat object : list) {
            System.out.println(object.toString());
        }
    }
}
