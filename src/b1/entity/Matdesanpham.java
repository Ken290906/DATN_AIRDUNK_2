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
public class Matdesanpham {
   private String IDmatde;
   private String matde;
    private int delete;
    private Date createdat;
    private String createby;
    private Date updateat;
    private String updateby;
   

    public Matdesanpham() {
    }

    public Matdesanpham(String IDmatde, String matde, int delete, String createby, String updateby) {
        this.IDmatde = IDmatde;
        this.matde = matde;
        this.delete = delete;
        this.createby = createby;
        this.updateby = updateby;
    }

    public String getIDmatde() {
        return IDmatde;
    }

    public void setIDmatde(String IDmatde) {
        this.IDmatde = IDmatde;
    }

    public String getMatde() {
        return matde;
    }

    public void setMatde(String matde) {
        this.matde = matde;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    @Override
    public String toString() {
        return "Matdesanpham{" + "IDmatde=" + IDmatde + ", matde=" + matde + ", delete=" + delete + ", createdat=" + createdat + ", createby=" + createby + ", updateat=" + updateat + ", updateby=" + updateby + '}';
    }

  
   
}
