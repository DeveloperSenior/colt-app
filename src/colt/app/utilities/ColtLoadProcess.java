/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.utilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *
 * @author <h1>Andres Felipe Escobar Lopez - andresfescobar92@gmail.com</h1>
 */
public class ColtLoadProcess extends JWindow {

    BorderLayout smartBorder = new BorderLayout();
    JLabel lblSmart = new JLabel();
    JPanel southPanel = new JPanel();
    FlowLayout southPanelFlowLayout = new FlowLayout();
    JProgressBar progressBar = new JProgressBar();
    ImageIcon imageIcon;

    public ColtLoadProcess(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        print();
    }

    private void print() {
        if(imageIcon!= null)lblSmart.setIcon(imageIcon);
        lblSmart.setOpaque(true);
        this.getContentPane().setLayout(smartBorder);
        southPanel.setLayout(southPanelFlowLayout);
        southPanel.setBackground(Color.WHITE);
        this.getContentPane().add(lblSmart, BorderLayout.CENTER);
        this.getContentPane().add(southPanel, BorderLayout.SOUTH);
        southPanel.add(progressBar, null);
        this.setFocusableWindowState(true);
        this.pack();
    }

    public void setProgresoMax(int maxProgress) {
        progressBar.setMaximum(maxProgress);
    }

    public void setProgreso(int progress,boolean indeterminate) {
        final int progreso = progress;
        progressBar.setValue(progreso);
        progressBar.setIndeterminate(indeterminate);
    }

    public void setProgreso(int progress) {
        final int progreso = progress;
        progressBar.setValue(progreso);
    }

    public void setProgreso(String message, int progress) {
        final int progreso = progress;
        final String theMessage = message;
        setProgreso(progress);
        progressBar.setValue(progreso);
        setMessage(theMessage);
    }

    private void setMessage(String message) {
        if (message == null) {
            message = "";
            progressBar.setStringPainted(false);
        } else {
            progressBar.setStringPainted(true);
        }

        progressBar.setString(message);
    }

    public void run(long velocidad) {
        for (int i = 0; i <= 100; i++) {
            for (long j = 0; j < velocidad; ++j) {
                String poop = " " + (j + i);
            }
            setProgreso("%" + i, i);
        }
        dispose();
    }
}
