/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.DongSanPham;
import b1.repository.dongsanphamrepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class dspservices {
    private dongsanphamrepo dspr = new dongsanphamrepo();
    public List<DongSanPham> getall(){
        return dspr.getall();
    }
}
