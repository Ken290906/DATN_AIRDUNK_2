/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.repository.LoginRepository;

/**
 *
 * @author Huanh
 */
public class LoginService {
    LoginRepository repo = new LoginRepository();
    
    public boolean Login(String acc, String password) {
        return repo.Login(acc, password);
    }
}
