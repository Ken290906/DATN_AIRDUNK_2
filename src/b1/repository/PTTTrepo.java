/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.repository;
import b1.entity.PTTT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class PTTTrepo {
   public List<PTTT> getall(){
       List<PTTT> listpttt =new ArrayList<>();
       String SQL = """
                    SELECT [MaTT]
                          ,[KieuThanhtoan]
                          ,[Deleted]
                          ,[CreatedAt]
                          ,[CreatedBy]
                          ,[UpdatedAt]
                          ,[UpdatedBy]
                      FROM [dbo].[PTthanhtoan]
                    """;
       try (Connection c = DBConnect.getConnection();PreparedStatement ps = c.prepareCall(SQL)){
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {               
               PTTT pttt = new PTTT();
               pttt.setMathanhtoan(rs.getString(1));
               pttt.setKieuthanhtoan(rs.getString(2));
               pttt.setDelete(rs.getInt(3));
               pttt.setCreateat(rs.getDate(4));
               pttt.setCreateBy(rs.getString(5));
               pttt.setUpdateAt(rs.getDate(6));
               pttt.setUpdateby(rs.getString(7));
               listpttt.add(pttt);
           }
       } catch (Exception e) {
       }
       return listpttt;
   }
    public static void main(String[] args) {
        List<PTTT> list = new PTTTrepo().getall();
        for (PTTT pttt : list) {
            System.out.println(pttt.toString());
        }
    }
}
