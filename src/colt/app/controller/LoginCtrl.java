/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.controller;

import colt.app.dto.UsuarioDTO;
import colt.app.model.LoginMdl;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class LoginCtrl {
    private LoginMdl mdl;
    
    public LoginCtrl() {
        mdl = new LoginMdl();
    }
    
    public UsuarioDTO login(UsuarioDTO login) throws SQLException{
        return mdl.login(login);
    }
    
}
