/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;
import b1.entity.Daysp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class dayrepo {
     public  List<Daysp> getall(){
         List<Daysp> listdsp = new ArrayList<>();
        String sql = """
                  SELECT [IDDay]
                               ,[dAYsp]
                               ,[Deleted]
                               ,[CreatedAt]
                               ,[CreatedBy]
                               ,[UpdatedAt]
                               ,[UpdatedBy]
                           FROM [dbo].[Dayy]
                     """;
        try (Connection c = DBConnect.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Daysp hsx = new Daysp();
                hsx.setIDday(rs.getString(1));
                hsx.setDaysp(rs.getString(2));
                hsx.setDelete(rs.getInt(3));
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
        List<Daysp> list = new dayrepo().getall();
        for (Daysp object : list) {
            System.out.println(object.toString());
        }
    }
}
