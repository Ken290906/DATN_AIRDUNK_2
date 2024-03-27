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
public class Dodaysp {
    private String IDdoday;
    private String doday;
      private int delete;
    private Date createdat;
    private String createby;
    private Date updateat;
    private String updateby;

    public Dodaysp() {
    }

    public Dodaysp(String IDdoday, String doday, int delete, String createby, String updateby) {
        this.IDdoday = IDdoday;
        this.doday = doday;
        this.delete = delete;
        this.createby = createby;
        this.updateby = updateby;
    }

    public String getIDdoday() {
        return IDdoday;
    }

    public void setIDdoday(String IDdoday) {
        this.IDdoday = IDdoday;
    }

    public String getDoday() {
        return doday;
    }

    public void setDoday(String doday) {
        this.doday = doday;
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
        return "Dodaysp{" + "IDdoday=" + IDdoday + ", doday=" + doday + ", delete=" + delete + ", createdat=" + createdat + ", createby=" + createby + ", updateat=" + updateat + ", updateby=" + updateby + '}';
    }

    
    
    
}
