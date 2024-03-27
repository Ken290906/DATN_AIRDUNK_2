/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class chitietsanpham {

    private String masp;
    private String idhangsx;
    private String iddongsp;
    private String idphoimau;
    private String idsize;
    private String iddoday;
    private String idchatlieu;
    private String idmatde;
    private String idday;
    private String ghichu;
    private int giaban;
    private int delete;
    private Date createat;
    private String createby;
    private Date Updateat;
    private String updateby;
    private String trangthai;
    private int  soluong;
    public chitietsanpham() {
    }

    public chitietsanpham(String idhangsx, String iddongsp, String idphoimau, String idsize, String iddoday, String idchatlieu, String idmatde, String idday, int giaban, int delete) {
        this.idhangsx = idhangsx;
        this.iddongsp = iddongsp;
        this.idphoimau = idphoimau;
        this.idsize = idsize;
        this.iddoday = iddoday;
        this.idchatlieu = idchatlieu;
        this.idmatde = idmatde;
        this.idday = idday;
        this.giaban = giaban;
        this.delete = delete;
    }

    public chitietsanpham(String masp, String ghichu, int delete, String trangthai, int soluong) {
        this.masp = masp;
        this.ghichu = ghichu;
        this.delete = delete;
        this.trangthai = trangthai;
        this.soluong = soluong;
    }

    
    

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getIdhangsx() {
        return idhangsx;
    }

    public void setIdhangsx(String idhangsx) {
        this.idhangsx = idhangsx;
    }

    public String getIddongsp() {
        return iddongsp;
    }

    public void setIddongsp(String iddongsp) {
        this.iddongsp = iddongsp;
    }

    public String getIdphoimau() {
        return idphoimau;
    }

    public void setIdphoimau(String idphoimau) {
        this.idphoimau = idphoimau;
    }

    public String getIdsize() {
        return idsize;
    }

    public void setIdsize(String idsize) {
        this.idsize = idsize;
    }

    public String getIddoday() {
        return iddoday;
    }

    public void setIddoday(String iddoday) {
        this.iddoday = iddoday;
    }

    public String getIdchatlieu() {
        return idchatlieu;
    }

    public void setIdchatlieu(String idchatlieu) {
        this.idchatlieu = idchatlieu;
    }

    public String getIdmatde() {
        return idmatde;
    }

    public void setIdmatde(String idmatde) {
        this.idmatde = idmatde;
    }

    public String getIdday() {
        return idday;
    }

    public void setIdday(String idday) {
        this.idday = idday;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getUpdateat() {
        return Updateat;
    }

    public void setUpdateat(Date Updateat) {
        this.Updateat = Updateat;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "chitietsanpham{" + "masp=" + masp + ", idhangsx=" + idhangsx + ", iddongsp=" + iddongsp + ", idphoimau=" + idphoimau + ", idsize=" + idsize + ", iddoday=" + iddoday + ", idchatlieu=" + idchatlieu + ", idmatde=" + idmatde + ", idday=" + idday + ", ghichu=" + ghichu + ", giaban=" + giaban + ", delete=" + delete + ", createat=" + createat + ", createby=" + createby + ", Updateat=" + Updateat + ", updateby=" + updateby + ", trangthai=" + trangthai + ", soluong=" + soluong + '}';
    }

   

    


    

}
