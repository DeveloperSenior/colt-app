/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.model;

import colt.app.dto.DummyDTO;
import colt.app.properties.ColtProperties;
import com.mysql.jdbc.Connection;
import coll.app.net.ColtConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 
 */
public class DummyMdl extends ColtConnection {

    /**
     * Definicion de propiedades SQL en archivo ColtProperties.propeties
     */
    ColtProperties propiedades;

    public DummyMdl() {
        super();
        propiedades = new ColtProperties();
    }

    public DefaultComboBoxModel consultarDummy() throws SQLException {

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = (Connection) getConnection();
            ps = connection.prepareStatement(propiedades.getString("DummyMdl.consultardummy"));
            rs = ps.executeQuery();
            while (rs.next()) {
                DummyDTO dummy = new DummyDTO();
                dummy.setId(rs.getInt("id"));
                dummy.setDescripcion(rs.getString("descripcion"));
                modelo.addElement(dummy);
            }
        } finally {
            /**
             * Se cierran las conexiones, los resultset y los preparadores de consultas SQL
             * con el fin de no saturar la piscina del motor de base de datos
             */
            closeResources(connection, ps, rs);
        }
        return modelo;
    }

}
