/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.view;

import colt.app.controller.PerfilCtrl;
import colt.app.dto.PerfilDTO;
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
public class ColtPerfilesView extends javax.swing.JInternalFrame {

    PerfilDTO selected;
    PerfilCtrl perfilCtrl;

    /**
     * Creates new form ColtPerfilesView
     * @param escritorio
     */
    public ColtPerfilesView(JDesktopPane escritorio) {
        initComponents();
        java.awt.Dimension dimension = escritorio.size();
        java.awt.Dimension ventan = this.getSize();
        this.setLocation(new java.awt.Point((dimension.width - ventan.width) / 2, (dimension.height - ventan.height) / 2));
        perfilCtrl = new PerfilCtrl();
        consultarPerfiles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombrePerfil = new javax.swing.JTextField();
        ckActivo = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setClosable(true);
        setIconifiable(true);
        setTitle(":.Perfiles.:");
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(231, 158, 109));

        jPanel2.setBackground(new java.awt.Color(61, 72, 85));
        jPanel2.setPreferredSize(new java.awt.Dimension(572, 51));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Grabar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(61, 72, 85));

        tbResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Id", "Nombre", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tbResultados.getColumnModel().getColumn(3).setMinWidth(50);
            tbResultados.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbResultados.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setLabelFor(txtNombrePerfil);
        jLabel1.setText("Nombre: *");

        txtNombrePerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombrePerfil.setSelectionColor(new java.awt.Color(231, 158, 109));

        ckActivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ckActivo.setForeground(new java.awt.Color(255, 255, 255));
        ckActivo.setText("Activo");
        ckActivo.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombrePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(ckActivo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckActivo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        final String nombre = txtNombrePerfil.getText();
        String activo = ckActivo.isSelected() ? "S" : "N";

        if (selected == null) {
            if ("".equals(nombre)) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            new ColtInvocationProcess(() -> {
                PerfilDTO perfil = new PerfilDTO(nombre, activo);
                try {
                    perfil = perfilCtrl.grabarPerfil(perfil);
                    if (perfil != null) {
                        JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al crear el perfil\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }, () -> {
                limpiar();
                consultarPerfiles();
            }).invoke();
        } else {
            selected.setNombre(nombre);
            selected.setActivo(activo);
            new ColtInvocationProcess(() -> {
                try {
                    PerfilDTO perfil = perfilCtrl.actualizarPerfil(selected);
                    if (perfil != null) {
                        JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el perfil\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }, () -> {
                limpiar();
                consultarPerfiles();
            }).invoke();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (selected != null) {
            int valor = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el perfil", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                new ColtInvocationProcess(() -> {
                    try {
                        perfilCtrl.eliminar(selected);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el perfil\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }, () -> {
                    limpiar();
                    consultarPerfiles();
                }).invoke();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el registro a eliminar", "Validación", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadosMouseClicked
        selected = (PerfilDTO) tbResultados.getValueAt(tbResultados.getSelectedRow(), 0);
        txtNombrePerfil.setText(selected.getNombre());
        ckActivo.setSelected("S".equals(selected.getActivo()));
    }//GEN-LAST:event_tbResultadosMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultarPerfiles();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void limpiar() {
        selected = null;
        txtNombrePerfil.setText("");
        ckActivo.setSelected(false);
    }

    private void consultarPerfiles() {
        final String nombre = txtNombrePerfil.getText();
        String activo = ckActivo.isSelected() ? "S" : "N";
        new ColtInvocationProcess(() -> {
            try {
                ArrayList<PerfilDTO> perfiles = perfilCtrl.consultar(new PerfilDTO(nombre, activo));
                tbResultados.removeAll();
                tbResultados.repaint();
                DefaultTableModel model = (DefaultTableModel) tbResultados.getModel();
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                for (PerfilDTO perfil : perfiles) {
                    model.addRow(perfil.showDataTable());
                }
                tbResultados.repaint();
            } catch (Throwable ex) {
                JOptionPane.showMessageDialog(this, "Error al consultar los perfiles\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }).invoke();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JCheckBox ckActivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultados;
    private javax.swing.JTextField txtNombrePerfil;
    // End of variables declaration//GEN-END:variables
}
