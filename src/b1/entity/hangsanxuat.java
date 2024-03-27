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
public class hangsanxuat {
    private String IDhsx;
    private String tenhang;
    private int delete;
    private Date createdat;
    private String createby;
    private Date updateat;
    private String updateby;

    public hangsanxuat() {
    }

    public String getIDhsx() {
        return IDhsx;
    }

    public void setIDhsx(String IDhsx) {
        this.IDhsx = IDhsx;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
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

    public hangsanxuat(String IDhsx, String tenhang, int delete, String createby, String updateby) {
        this.IDhsx = IDhsx;
        this.tenhang = tenhang;
        this.delete = delete;
        this.createby = createby;
        this.updateby = updateby;
    }

    @Override
    public String toString() {
        return "hangsanxuat{" + "IDhsx=" + IDhsx + ", tenhang=" + tenhang + ", delete=" + delete + ", createdat=" + createdat + ", createby=" + createby + ", updateat=" + updateat + ", updateby=" + updateby + '}';
    }

    
    
    
}
