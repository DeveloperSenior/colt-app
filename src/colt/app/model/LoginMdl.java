/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.model;

import colt.app.dto.UsuarioDTO;
import colt.app.net.ColtConnection;
import colt.app.properties.ColtProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class LoginMdl extends ColtConnection{

    final private ColtProperties propiedades;
    
    public LoginMdl() {
      super();
      propiedades = new ColtProperties();
    }

    public UsuarioDTO login(UsuarioDTO login) throws SQLException{
        UsuarioDTO respuesta = new UsuarioDTO();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("LoginMdl.login"));
         ps.setString(1, login.getLogin());
         ps.setString(2, login.getClave());
         ps.setString(3, "S");
         rs = ps.executeQuery();
         
         if(rs != null){
             while(rs.next()){
                 respuesta.setIdUsuario(rs.getInt("idusuario"));
                 respuesta.setCedula(rs.getString("cedula"));
                 respuesta.setNombre(rs.getString("nombre"));
                 respuesta.setApellido(rs.getString("apellido"));
             }
         }
         
        }finally{
            closeResources(con, ps, rs);
        }
        
        return respuesta;
    }
    
    
    
}
