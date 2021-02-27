/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.view;

import br.uefs.ecomp.RoadTrips.exceptions.EstradaNaoEncontradaException;
import br.uefs.ecomp.RoadTrips.exceptions.UsuarioNaoEncontradoException;
import br.uefs.ecomp.RoadTrips.facade.RoadTripsFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Natalia
 */
public class RoadTrips_ADM_RemoverUsuario extends javax.swing.JInternalFrame {
    private RoadTripsFacade facade;
    /**
     * Creates new form RoadTrips_ADM_CadastrarCidade
     */
    public RoadTrips_ADM_RemoverUsuario(RoadTripsFacade facade) {
        initComponents();
        this.facade = facade;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jTextFieldLoginUsuario = new javax.swing.JTextField();
        jButtonRemoverUsuario = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Remover Usu�rio");
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLogin.setText("Login do Usu�rio:");
        jPanel2.add(jLabelLogin);
        jLabelLogin.setBounds(140, 120, 110, 14);
        jPanel2.add(jTextFieldLoginUsuario);
        jTextFieldLoginUsuario.setBounds(140, 140, 160, 20);

        jButtonRemoverUsuario.setText("Remover ");
        jButtonRemoverUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRemoverUsuario);
        jButtonRemoverUsuario.setBounds(183, 180, 120, 23);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/fundo2.jpg"))); // NOI18N
        jPanel2.add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 470, 410);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 470, 410);

        setBounds(175, 200, 470, 439);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRemoverUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverUsuarioActionPerformed
        String login = jTextFieldLoginUsuario.getText().trim();
        try {
            facade.removerUsuario(login);
            JOptionPane.showMessageDialog(rootPane, "Usu�rio removido com sucesso!");
            this.doDefaultCloseAction();
        } catch (UsuarioNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMensagem());
        }
    }//GEN-LAST:event_jButtonRemoverUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRemoverUsuario;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldLoginUsuario;
    // End of variables declaration//GEN-END:variables
}
