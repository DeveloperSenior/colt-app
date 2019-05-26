/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.model;

import colt.app.dto.PerfilDTO;
import colt.app.dto.UsuarioDTO;
import colt.app.net.ColtConnection;
import colt.app.properties.ColtProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author
 */
public class UsuarioMdl extends ColtConnection {

    final private ColtProperties propiedades;

    public UsuarioMdl() {
        super();
        propiedades = new ColtProperties();
    }

    public UsuarioDTO grabarUsuario(UsuarioDTO usuario) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        UsuarioDTO respuesta = null;
        try {

            con = getConnection();
            ps = con.prepareStatement(propiedades.getString("UsuarioMdl.crear"));
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getClave());
            ps.setString(3, "S");
            ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(5, usuario.getCedula());
            ps.setString(6, usuario.getNombre());
            ps.setString(7, usuario.getApellido());
            ps.setString(8, usuario.getTelefono());
            ps.setString(9, usuario.getSexo());
            ps.setDate(10, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.executeUpdate();
            respuesta = consultar(usuario).get(0);
            grabarUsuarioxPerfil(respuesta);
        } finally {
            closeResources(con, ps);
        }
        return respuesta;
    }

    private void grabarUsuarioxPerfil(UsuarioDTO usuario) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(propiedades.getString("UsuarioMdl.crearUsuarioPerfil"));
            ps.setInt(1, usuario.getIdUsuario());
            ps.setInt(2, usuario.getPerfil().getIdPerfil());
            ps.executeUpdate();
        } finally {
            closeResources(con, ps);
        }
    }

    public ArrayList<UsuarioDTO> consultar(UsuarioDTO usuario) throws SQLException {
        ArrayList<UsuarioDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = getConnection();
            ps = con.prepareStatement(propiedades.getString("UsuarioMdl.consultar"));
            ps.setString(1, "S");
            ps.setString(2, usuario.getCedula());
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    UsuarioDTO usuarior = new UsuarioDTO();
                    usuarior.setIdUsuario(rs.getInt("idUsuario"));
                    usuarior.setCedula(rs.getString("cedula"));
                    usuarior.setNombre(rs.getString("nombre"));
                    usuarior.setApellido(rs.getString("apellido"));
                    usuarior.setLogin(rs.getString("login"));
                    usuarior.setTelefono(rs.getString("telefono"));
                    usuarior.setSexo(rs.getString("sexo"));
                    PerfilDTO perfil = new PerfilDTO();
                    perfil.setIdPerfil(rs.getInt("idPerfil"));
                    usuarior.setPerfil(perfil);
                    Date fechaN = rs.getDate("fechaNacimiento");
                    if (fechaN != null) {
                        usuarior.setFechaNacimiento(new Date(fechaN.getTime()));
                    }
                    respuesta.add(usuarior);
                }
            }

        } finally {
            closeResources(con, ps, rs);
        }

        return respuesta;
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO selected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminarUsuario(UsuarioDTO selected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
