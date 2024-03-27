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
public class DongSanPham {
    private String IDdsp;
    private String tendsp;
      private boolean delete;
    private Date createdat;
    private String createby;
    private Date updateat;
    private String updateby;

    public DongSanPham() {
    }

    public DongSanPham(String IDdsp, String tendsp, boolean delete, Date createdat, String createby, Date updateat, String updateby) {
        this.IDdsp = IDdsp;
        this.tendsp = tendsp;
        this.delete = delete;
        this.createdat = createdat;
        this.createby = createby;
        this.updateat = updateat;
        this.updateby = updateby;
    }

    public String getIDdsp() {
        return IDdsp;
    }

    public void setIDdsp(String IDdsp) {
        this.IDdsp = IDdsp;
    }

    public String getTendsp() {
        return tendsp;
    }

    public void setTendsp(String tendsp) {
        this.tendsp = tendsp;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
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
        return "DongSanPham{" + "IDdsp=" + IDdsp + ", tendsp=" + tendsp + ", delete=" + delete + ", createdat=" + createdat + ", createby=" + createby + ", updateat=" + updateat + ", updateby=" + updateby + '}';
    }
    
    
}
