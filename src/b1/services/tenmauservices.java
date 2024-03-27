/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.MauSanPham;
import b1.repository.tenmaurepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class tenmauservices {
    private tenmaurepo tmr = new tenmaurepo();
    public List<MauSanPham> getall(){
        return tmr.getall();
    }
}
