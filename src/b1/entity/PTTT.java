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
public class PTTT {
    private String mathanhtoan;
    private String kieuthanhtoan;
    private int Delete;
    private Date Createat;
    private String CreateBy;
    private  Date UpdateAt;
    private String Updateby;

    public PTTT() {
    }

    public PTTT(String mathanhtoan, String kieuthanhtoan, int Delete, Date Createat, String CreateBy, Date UpdateAt, String Updateby) {
        this.mathanhtoan = mathanhtoan;
        this.kieuthanhtoan = kieuthanhtoan;
        this.Delete = Delete;
        this.Createat = Createat;
        this.CreateBy = CreateBy;
        this.UpdateAt = UpdateAt;
        this.Updateby = Updateby;
    }

    public String getMathanhtoan() {
        return mathanhtoan;
    }

    public void setMathanhtoan(String mathanhtoan) {
        this.mathanhtoan = mathanhtoan;
    }

    public String getKieuthanhtoan() {
        return kieuthanhtoan;
    }

    public void setKieuthanhtoan(String kieuthanhtoan) {
        this.kieuthanhtoan = kieuthanhtoan;
    }

    public int getDelete() {
        return Delete;
    }

    public void setDelete(int Delete) {
        this.Delete = Delete;
    }

    public Date getCreateat() {
        return Createat;
    }

    public void setCreateat(Date Createat) {
        this.Createat = Createat;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String CreateBy) {
        this.CreateBy = CreateBy;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date UpdateAt) {
        this.UpdateAt = UpdateAt;
    }

    public String getUpdateby() {
        return Updateby;
    }

    public void setUpdateby(String Updateby) {
        this.Updateby = Updateby;
    }

    @Override
    public String toString() {
        return "PTTT{" + "mathanhtoan=" + mathanhtoan + ", kieuthanhtoan=" + kieuthanhtoan + ", Delete=" + Delete + ", Createat=" + Createat + ", CreateBy=" + CreateBy + ", UpdateAt=" + UpdateAt + ", Updateby=" + Updateby + '}';
    }
    
    
    
}
