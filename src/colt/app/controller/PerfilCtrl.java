/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.controller;

import colt.app.dto.PerfilDTO;
import colt.app.model.PerfilMdl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class PerfilCtrl {
    
    PerfilMdl perfilMdl;

    public PerfilCtrl() {
      perfilMdl = new PerfilMdl();      
    }
    
    public PerfilDTO grabarPerfil(PerfilDTO perfil) throws SQLException{
        return perfilMdl.grabarPerfil(perfil);
    }

    public PerfilDTO actualizarPerfil(PerfilDTO selected) throws SQLException {
        return perfilMdl.actualizarPerfil(selected);
    }

    public void eliminar(PerfilDTO selected)throws SQLException {
        selected.setActivo("N");
        perfilMdl.actualizarPerfil(selected);
    }
    
    public ArrayList<PerfilDTO> consultar(PerfilDTO perfil)throws SQLException{
        return perfilMdl.consultar(perfil);
    }
    
}
