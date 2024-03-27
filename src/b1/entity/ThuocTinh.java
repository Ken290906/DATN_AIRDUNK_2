/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.entity;

/**
 *
 * @author DELL
 */
public class ThuocTinh {
    private String Masp;
    private String tensp;
    private int Delete;
    public ThuocTinh() {
    }

    public ThuocTinh(String Masp, String tensp, int Delete) {
        this.Masp = Masp;
        this.tensp = tensp;
        this.Delete = Delete;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getDelete() {
        return Delete;
    }

    public void setDelete(int Delete) {
        this.Delete = Delete;
    }

    @Override
    public String toString() {
        return "ThuocTinh{" + "Masp=" + Masp + ", tensp=" + tensp + ", Delete=" + Delete + '}';
    }

    
   
    
    
    
}
