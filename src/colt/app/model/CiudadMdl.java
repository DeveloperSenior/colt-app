/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.model;

import colt.app.dto.CiudadDTO;
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
public class CiudadMdl extends ColtConnection{
    final private ColtProperties propiedades;
    
    public CiudadMdl() {
      super();
      propiedades = new ColtProperties();
    }

    public CiudadDTO grabarCiudad(CiudadDTO ciudad) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        CiudadDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.crear"));
         ps.setString(1, ciudad.getNombre());
         ps.setString(2, ciudad.getDepartamento());
         ps.setString(3, ciudad.getPais());
         ps.setDate(4, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = ciudad;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public CiudadDTO actualizarCiudad(CiudadDTO ciudad) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        CiudadDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.actualizar"));
         ps.setString(1, ciudad.getNombre());
          ps.setString(2, ciudad.getDepartamento());
         ps.setString(3, ciudad.getPais());
         ps.setInt(4, ciudad.getIdCiudad());
         ps.executeUpdate();
         respuesta = ciudad;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
        public CiudadDTO eliminarCiudad(CiudadDTO ciudad) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        CiudadDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.eliminar"));
         ps.setInt(1, ciudad.getIdCiudad());
         ps.executeUpdate();
         respuesta = ciudad;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public ArrayList<CiudadDTO> consultar(CiudadDTO ciudad) throws SQLException{
        ArrayList<CiudadDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.consultar"));
         ps.setString(1, "S");
         ps.setString(2, ciudad.getNombre());
         ps.setInt(3, ciudad.getIdCiudad());
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 CiudadDTO ciudadr = new CiudadDTO();
                 ciudadr.setIdCiudad(rs.getInt("idCiudad"));
                 ciudadr.setNombre(rs.getString("nombre"));
                 ciudadr.setDepartamento(rs.getString("departamento"));
                 ciudadr.setPais(rs.getString("pais"));
                 respuesta.add(ciudadr);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }
    
}
