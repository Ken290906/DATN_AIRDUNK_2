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
public class Chatlieusp {
    private String idchatlieu;
    private String chatlieusp;    
    private int delete;
    private Date createdat;
    private String createby;
    private Date updateat;
    private String updateby;

    public Chatlieusp() {
    }

    public Chatlieusp(String idchatlieu, String chatlieusp, int delete, String createby, String updateby) {
        this.idchatlieu = idchatlieu;
        this.chatlieusp = chatlieusp;
        this.delete = delete;
        this.createby = createby;
        this.updateby = updateby;
    }

    

    public String getIdchatlieu() {
        return idchatlieu;
    }

    public void setIdchatlieu(String idchatlieu) {
        this.idchatlieu = idchatlieu;
    }

    public String getChatlieusp() {
        return chatlieusp;
    }

    public void setChatlieusp(String chatlieusp) {
        this.chatlieusp = chatlieusp;
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
        return "Chatlieusp{" + "idchatlieu=" + idchatlieu + ", chatlieusp=" + chatlieusp + ", delete=" + delete + ", createdat=" + createdat + ", createby=" + createby + ", updateat=" + updateat + ", updateby=" + updateby + '}';
    }

    
    
    
}
