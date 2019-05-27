/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.model;

import colt.app.dto.CiudadDTO;
import colt.app.dto.RutaDTO;
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
public class RutaMdl extends ColtConnection{
    final private ColtProperties propiedades;
    
    public RutaMdl() {
      super();
      propiedades = new ColtProperties();
    }

    public RutaDTO grabarRuta(RutaDTO ruta) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        RutaDTO respuesta = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.crear"));
         ps.setString(1, ruta.getCodigo());
         ps.setString(2, ruta.getDescripcion());
         ps.setInt(3, ruta.getDestino().getIdCiudad());
         ps.setInt(4, ruta.getOrigen().getIdCiudad());
         ps.setDate(5, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = ruta;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public RutaDTO actualizarRuta(RutaDTO ruta) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        RutaDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.actualizar"));
         ps.setString(1, ruta.getDescripcion());
         ps.setInt(2, ruta.getDestino().getIdCiudad());
         ps.setInt(3, ruta.getOrigen().getIdCiudad());
         ps.executeUpdate();
         respuesta = ruta;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
        public RutaDTO eliminarRuta(RutaDTO ruta) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        RutaDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.eliminar"));
         ps.setInt(1, ruta.getIdRuta());
         ps.executeUpdate();
         respuesta = ruta;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public ArrayList<RutaDTO> consultar(RutaDTO ruta) throws SQLException{
        ArrayList<RutaDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.consultar"));
         ps.setString(1, ruta.getCodigo());
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 RutaDTO rutar = new RutaDTO();
                 rutar.setIdRuta(rs.getInt("idRuta"));
                 rutar.setCodigo(rs.getString("codigo"));
                 rutar.setDescripcion(rs.getString("descripcion"));
                 CiudadDTO origen = new CiudadDTO();
                 origen.setIdCiudad(rs.getInt("idCiudadOrigen"));
                 origen.setNombre(rs.getString("ciudadOrigen"));
                 rutar.setOrigen(origen);
                 CiudadDTO destino = new CiudadDTO();
                 destino.setIdCiudad(rs.getInt("idCiudadDestino"));
                 destino.setNombre(rs.getString("ciudadDestino"));
                 rutar.setDestino(destino);
                 respuesta.add(rutar);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }
    
}
