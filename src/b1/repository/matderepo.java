/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;
import b1.entity.Matdesanpham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class matderepo {
    public  List<Matdesanpham> getall(){
        List<Matdesanpham> listhsx = new ArrayList<>();
        String sql = """
                   SELECT [IDMatDe]
                               ,[MatDeSP]
                               ,[Deleted]
                               ,[CreatedAt]
                               ,[CreatedBy]
                               ,[UpdatedAt]
                               ,[UpdatedBy]
                           FROM [dbo].[MatDe]
                     """;
        try (Connection c = DBConnect.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
               Matdesanpham hsx = new Matdesanpham();
                hsx.setIDmatde(rs.getString(1));
                hsx.setMatde(rs.getString(2));
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
        List<Matdesanpham> list = new matderepo().getall();
        for (Matdesanpham object : list) {
            System.out.println(object.toString());
        }
    }
}
