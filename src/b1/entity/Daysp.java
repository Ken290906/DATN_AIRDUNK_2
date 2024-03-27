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
public class Daysp {

    private String IDday;
    private String daysp;
 private int delete;
    private Date createdat;
    private String createby;
    private Date updateat;
    private String updateby;

    public Daysp() {
    }

    public Daysp(String IDday, String daysp, int delete, String createby, String updateby) {
        this.IDday = IDday;
        this.daysp = daysp;
        this.delete = delete;
        this.createby = createby;
        this.updateby = updateby;
    }

    

    public String getIDday() {
        return IDday;
    }

    public void setIDday(String IDday) {
        this.IDday = IDday;
    }

    public String getDaysp() {
        return daysp;
    }

    public void setDaysp(String daysp) {
        this.daysp = daysp;
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
        return "Daysp{" + "IDday=" + IDday + ", daysp=" + daysp + ", delete=" + delete + ", createdat=" + createdat + ", createby=" + createby + ", updateat=" + updateat + ", updateby=" + updateby + '}';
    }

   
    
    
    
}
