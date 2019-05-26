/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.controller;

import colt.app.dto.PerfilDTO;
import colt.app.dto.UsuarioDTO;
import colt.app.model.PerfilMdl;
import colt.app.model.UsuarioMdl;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class UsuarioCtrl {
    
    UsuarioMdl usuarioMdl;
    PerfilMdl perfilMdl;

    public UsuarioCtrl() {
      usuarioMdl = new UsuarioMdl();
      perfilMdl = new PerfilMdl();
    }
    
    public UsuarioDTO grabarUsuario(UsuarioDTO usuario) throws SQLException{
        return usuarioMdl.grabarUsuario(usuario);
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO selected) throws SQLException {
        return usuarioMdl.actualizarUsuario(selected);
    }

    public void eliminar(UsuarioDTO selected)throws SQLException {
        usuarioMdl.eliminarUsuario(selected);
    }
    
    public ArrayList<UsuarioDTO> consultar(UsuarioDTO usuario)throws SQLException{
        return usuarioMdl.consultar(usuario);
    }
    
    public ArrayList<PerfilDTO> consultarPerfiles(PerfilDTO perfil) throws SQLException{
        return perfilMdl.consultar(perfil);
    }
}
