/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.view;

import colt.app.controller.VehiculoCtrl;
import colt.app.dto.VehiculoDTO;
import colt.app.utilities.ColtInvocationProcess;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ColtVehiculosView extends javax.swing.JInternalFrame {

    VehiculoCtrl vehiculoCtrl;
    VehiculoDTO selected;

    /**
     * Creates new form ColtVehiculosView
     */
    public ColtVehiculosView(JDesktopPane escritorio) {
        initComponents();
        java.awt.Dimension dimension = escritorio.size();
        java.awt.Dimension ventan = this.getSize();
        this.setLocation(new java.awt.Point((dimension.width - ventan.width) / 2, (dimension.height - ventan.height) / 2));
        vehiculoCtrl = new VehiculoCtrl();
        consultarVehiculos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        ckSeguro = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle(":.Vehículos.:");

        jPanel1.setBackground(new java.awt.Color(231, 158, 109));

        jPanel2.setBackground(new java.awt.Color(61, 72, 85));
        jPanel2.setPreferredSize(new java.awt.Dimension(572, 51));

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(231, 158, 109));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon-black-small.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorderPainted(false);
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(231, 158, 109));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-icon-black-small.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(231, 158, 109));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-icon-black-small.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.setBorderPainted(false);
        btnGrabar.setContentAreaFilled(false);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(231, 158, 109));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel-icon-black-small.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(61, 72, 85));

        tbResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Id", "Placa", "Modelo", "Capacidad", "Tiene seguro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResultados.setGridColor(new java.awt.Color(231, 158, 109));
        tbResultados.setOpaque(false);
        tbResultados.setSelectionBackground(new java.awt.Color(231, 158, 109));
        tbResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbResultados);
        if (tbResultados.getColumnModel().getColumnCount() > 0) {
            tbResultados.getColumnModel().getColumn(0).setMinWidth(0);
            tbResultados.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbResultados.getColumnModel().getColumn(0).setMaxWidth(0);
            tbResultados.getColumnModel().getColumn(1).setMinWidth(50);
            tbResultados.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbResultados.getColumnModel().getColumn(1).setMaxWidth(50);
            tbResultados.getColumnModel().getColumn(4).setMinWidth(60);
            tbResultados.getColumnModel().getColumn(4).setPreferredWidth(60);
            tbResultados.getColumnModel().getColumn(4).setMaxWidth(60);
            tbResultados.getColumnModel().getColumn(5).setMinWidth(80);
            tbResultados.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbResultados.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa: *");

        txtPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPlaca.setSelectionColor(new java.awt.Color(231, 158, 109));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Capacidad: *");

        txtCapacidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCapacidad.setSelectionColor(new java.awt.Color(231, 158, 109));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setLabelFor(txtModelo);
        jLabel3.setText("Modelo: *");

        txtModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtModelo.setSelectionColor(new java.awt.Color(231, 158, 109));

        ckSeguro.setForeground(new java.awt.Color(255, 255, 255));
        ckSeguro.setText("Tiene seguro");
        ckSeguro.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(ckSeguro))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckSeguro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultarVehiculos();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (selected != null) {
            int valor = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar la vehiculo", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                new ColtInvocationProcess(() -> {
                    try {
                        vehiculoCtrl.eliminar(selected);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error al eliminar la vehiculo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }, () -> {
                    limpiar();
                    consultarVehiculos();
                }).invoke();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el registro a eliminar", "Validación", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        final String placa = txtPlaca.getText();
        final String modelo = txtModelo.getText();
        int cap;
        try {
            cap = Integer.parseInt(txtCapacidad.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Ingrese la capacidad", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        final int capacidad = cap;
        final String seguro = ckSeguro.isSelected() ? "S" : "N";
        if (selected == null) {
            if ("".equals(placa)) {
                JOptionPane.showMessageDialog(this, "Ingrese la placa", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if ("".equals(modelo)) {
                JOptionPane.showMessageDialog(this, "Ingrese el modelo", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            new ColtInvocationProcess(() -> {
                VehiculoDTO vehiculo = new VehiculoDTO(placa, modelo, capacidad, seguro, "S");
                try {
                    vehiculo = vehiculoCtrl.grabarVehiculo(vehiculo);
                    if (vehiculo != null) {
                        JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al crear la vehiculo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }, () -> {
                limpiar();
                consultarVehiculos();
            }).invoke();
        } else {
            selected.setPlaca(placa);
            selected.setModelo(modelo);
            selected.setCapacidad(capacidad);
            selected.setSeguro(seguro);
            new ColtInvocationProcess(() -> {
                try {
                    VehiculoDTO vehiculo = vehiculoCtrl.actualizarVehiculo(selected);
                    if (vehiculo != null) {
                        JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el vehiculo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }, () -> {
                limpiar();
                consultarVehiculos();
            }).invoke();
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadosMouseClicked
        selected = (VehiculoDTO) tbResultados.getValueAt(tbResultados.getSelectedRow(), 0);
        txtPlaca.setText(selected.getPlaca());
        txtModelo.setText(selected.getModelo());
        txtCapacidad.setText(selected.getCapacidad() + "");
        ckSeguro.setSelected("S".equals(selected.getSeguro()));
    }//GEN-LAST:event_tbResultadosMouseClicked

    private void limpiar() {
        selected = null;
        txtPlaca.setText("");
        txtModelo.setText("");
        txtCapacidad.setText("");
        ckSeguro.setSelected(false);
    }

    private void consultarVehiculos() {
        final String placa = txtPlaca.getText();
        final String modelo = txtModelo.getText();
        int cap;
        try {
            cap = Integer.parseInt(txtCapacidad.getText());
        } catch (NumberFormatException nfe) {
            cap = 1;
        }
        final int capacidad = cap;
        final String seguro = ckSeguro.isSelected() ? "S" : "N";
        new ColtInvocationProcess(() -> {
            try {
                ArrayList<VehiculoDTO> vehiculoes = vehiculoCtrl.consultar(new VehiculoDTO(placa, modelo, capacidad, seguro, "S"));
                tbResultados.removeAll();
                tbResultados.repaint();
                DefaultTableModel model = (DefaultTableModel) tbResultados.getModel();
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                for (VehiculoDTO vehiculo : vehiculoes) {
                    model.addRow(vehiculo.showDataTable());
                }
                tbResultados.repaint();
            } catch (Throwable ex) {
                JOptionPane.showMessageDialog(this, "Error al consultar los vehiculos\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }).invoke();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox ckSeguro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultados;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
