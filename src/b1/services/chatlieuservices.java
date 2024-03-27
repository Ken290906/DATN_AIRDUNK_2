/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.Chatlieusp;
import b1.repository.Chatlieurepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class chatlieuservices {
    private Chatlieurepo clr = new Chatlieurepo();
    
    public List<Chatlieusp> getall(){
        return clr.getall();
    } 
}
