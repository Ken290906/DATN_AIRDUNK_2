/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.Dodaysp;
import b1.repository.Dodayrepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class dodayservices {
    private Dodayrepo ddr = new Dodayrepo();
    
    public List<Dodaysp> getall(){
        return ddr.getall();
    }
}
