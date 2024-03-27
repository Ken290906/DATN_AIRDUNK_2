/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.Daysp;
import b1.repository.dayrepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class dayservices {
    private dayrepo dr = new dayrepo();
    
    public List<Daysp> getall(){
        return dr.getall();
    } 
}
