/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.model;

import colt.app.dto.PerfilDTO;
import colt.app.net.ColtConnection;
import colt.app.properties.ColtProperties;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class PerfilMdl extends ColtConnection{
    final private ColtProperties propiedades;
    
    public PerfilMdl() {
      super();
      propiedades = new ColtProperties();
    }

    public PerfilDTO grabarPerfil(PerfilDTO perfil) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        PerfilDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("PerfilMdl.crear"));
         ps.setString(1, perfil.getNombre());
         ps.setString(2, perfil.getActivo());
         ps.setDate(3, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = perfil;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public PerfilDTO actualizarPerfil(PerfilDTO perfil) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        PerfilDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("PerfilMdl.actualizar"));
         ps.setString(1, perfil.getNombre());
         ps.setString(2, perfil.getActivo());
         ps.setInt(3, perfil.getIdPerfil());
         ps.executeUpdate();
         respuesta = perfil;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public ArrayList<PerfilDTO> consultar(PerfilDTO perfil) throws SQLException{
        ArrayList<PerfilDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("PerfilMdl.consultar"));
         ps.setString(1, "S");
         ps.setString(2, perfil.getNombre());
         ps.setInt(3, perfil.getIdPerfil());
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 PerfilDTO perfilr = new PerfilDTO();
                 perfilr.setIdPerfil(rs.getInt("idPerfil"));
                 perfilr.setNombre(rs.getString("nombrePerfil"));
                 perfilr.setActivo(rs.getString("activo"));
                 respuesta.add(perfilr);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }
    
}
