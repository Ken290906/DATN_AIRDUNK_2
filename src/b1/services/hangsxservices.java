/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.hangsanxuat;
import b1.repository.hangsanxuatrepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class hangsxservices {
    private hangsanxuatrepo hsxr = new hangsanxuatrepo();
    
    public List<hangsanxuat> getall(){
        return hsxr.getall();
    }
}
