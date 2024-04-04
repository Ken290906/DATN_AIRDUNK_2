/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.PTTT;
import b1.repository.PTTTrepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class PTTTservuces {

    private PTTTrepo repo = new PTTTrepo();

    public List<PTTT> getall() {
        return repo.getall();
    }
}
