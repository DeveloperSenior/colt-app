/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.model;

import colt.app.dto.VehiculoDTO;
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
public class VehiculoMdl extends ColtConnection{
    final private ColtProperties propiedades;
    
    public VehiculoMdl() {
      super();
      propiedades = new ColtProperties();
    }

    public VehiculoDTO grabarVehiculo(VehiculoDTO vehiculo) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        VehiculoDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.crear"));
         ps.setString(1, vehiculo.getPlaca());
         ps.setString(2, vehiculo.getModelo());
         ps.setInt(3, vehiculo.getCapacidad());
         ps.setString(4, vehiculo.getSeguro());
         ps.setString(5, vehiculo.getActivo());
         ps.setDate(6, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = vehiculo;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public VehiculoDTO actualizarVehiculo(VehiculoDTO vehiculo) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        VehiculoDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.actualizar"));
         ps.setString(1, vehiculo.getPlaca());
         ps.setString(2, vehiculo.getModelo());
         ps.setInt(3, vehiculo.getCapacidad());
         ps.setString(4, vehiculo.getSeguro());
         ps.setString(5, vehiculo.getActivo());
         ps.setInt(6, vehiculo.getIdVehiculo());
         ps.executeUpdate();
         respuesta = vehiculo;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
        public VehiculoDTO eliminarVehiculo(VehiculoDTO vehiculo) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        VehiculoDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.eliminar"));
         ps.setInt(1, vehiculo.getIdVehiculo());
         ps.executeUpdate();
         respuesta = vehiculo;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public ArrayList<VehiculoDTO> consultar(VehiculoDTO vehiculo) throws SQLException{
        ArrayList<VehiculoDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.consultar"));
         ps.setString(1, vehiculo.getPlaca());
         ps.setString(2, vehiculo.getModelo());
         ps.setInt(3, vehiculo.getCapacidad());
         ps.setString(4, vehiculo.getSeguro());
         ps.setString(5, "S");
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 VehiculoDTO vehiculor = new VehiculoDTO();
                 vehiculor.setIdVehiculo(rs.getInt("idVehiculo"));
                 vehiculor.setPlaca(rs.getString("placa"));
                 vehiculor.setModelo(rs.getString("modelo"));
                 vehiculor.setCapacidad(rs.getInt("capacidad"));
                 vehiculor.setSeguro(rs.getString("seguro"));
                 vehiculor.setActivo(rs.getString("activo"));
                 respuesta.add(vehiculor);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }
    
}
