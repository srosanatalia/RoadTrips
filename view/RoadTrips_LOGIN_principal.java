/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.view;

import br.uefs.ecomp.RoadTrips.exceptions.UsuarioNaoEncontradoException;
import br.uefs.ecomp.RoadTrips.facade.RoadTripsFacade;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Natalia
 */
public class RoadTrips_LOGIN_principal extends javax.swing.JFrame {
    private RoadTripsFacade facade;
    /**
     * Creates new form RoadTrips_ADM_principal
     */
    public RoadTrips_LOGIN_principal() {
        initComponents();
    }
    public RoadTrips_LOGIN_principal( RoadTripsFacade facade) {
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

        jDialogUsuarioNaoEncontrado = new javax.swing.JDialog();
        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelIcnMapaRoadTrips = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jLabelFundo3 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();
        jLabelFundo1 = new javax.swing.JLabel();
        jLabelFundo2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastrarse = new javax.swing.JMenu();
        jMenuItemCadastrarUsuario = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Road Trips - Administrador");
        setIconImages(null);
        getContentPane().setLayout(null);

        jDesktopPanePrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/logo.gif"))); // NOI18N
        jDesktopPanePrincipal.add(jLabel1);
        jLabel1.setBounds(240, 10, 430, 130);

        jLabelIcnMapaRoadTrips.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/icnMapa2.gif"))); // NOI18N
        jDesktopPanePrincipal.add(jLabelIcnMapaRoadTrips);
        jLabelIcnMapaRoadTrips.setBounds(240, 10, 210, 160);

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLogin.setText("Login:");
        jDesktopPanePrincipal.add(jLabelLogin);
        jLabelLogin.setBounds(320, 290, 60, 14);

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelSenha.setText("Senha:");
        jDesktopPanePrincipal.add(jLabelSenha);
        jLabelSenha.setBounds(320, 340, 60, 14);
        jDesktopPanePrincipal.add(jTextFieldLogin);
        jTextFieldLogin.setBounds(320, 310, 160, 20);
        jDesktopPanePrincipal.add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(320, 360, 160, 20);

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        jDesktopPanePrincipal.add(jButtonEntrar);
        jButtonEntrar.setBounds(383, 400, 90, 23);

        jLabelFundo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/fundo.jpg"))); // NOI18N
        jDesktopPanePrincipal.add(jLabelFundo3);
        jLabelFundo3.setBounds(0, 0, 626, 390);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/fundo.jpg"))); // NOI18N
        jDesktopPanePrincipal.add(jLabelFundo);
        jLabelFundo.setBounds(620, 0, 626, 390);

        jLabelFundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/fundo.jpg"))); // NOI18N
        jDesktopPanePrincipal.add(jLabelFundo1);
        jLabelFundo1.setBounds(630, 340, 626, 390);

        jLabelFundo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/fundo.jpg"))); // NOI18N
        jDesktopPanePrincipal.add(jLabelFundo2);
        jLabelFundo2.setBounds(0, 390, 620, 290);

        getContentPane().add(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setBounds(0, 0, 860, 670);

        jMenuCadastrarse.setText("Cadastrar-se");
        jMenuCadastrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuCadastrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastrarseActionPerformed(evt);
            }
        });

        jMenuItemCadastrarUsuario.setText("Cadastrar Usu�rio");
        jMenuItemCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastrarse.add(jMenuItemCadastrarUsuario);

        jMenuBar1.add(jMenuCadastrarse);

        jMenuSair.setText("Sair");

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItemSair);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 868, 728);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastrarseActionPerformed
        
    }//GEN-LAST:event_jMenuCadastrarseActionPerformed

    private void jMenuItemCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarUsuarioActionPerformed
        RoadTrips_LOGIN_CadastrarUsuario cadastrarUsuario = new RoadTrips_LOGIN_CadastrarUsuario(facade);
        jDesktopPanePrincipal.add(cadastrarUsuario);
        cadastrarUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarUsuarioActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        String login = jTextFieldLogin.getText();
        String senha = jPasswordFieldSenha.getText();
       
        try {
            if (facade.verificaUsuario(login, senha)){
                if(login.equals("JamylleS")){
                    RoadTrips_ADM_principal adm = new RoadTrips_ADM_principal(this.facade);
                    adm.setVisible(true);
                    this.setVisible(false);
                } else{
                    RoadTrips_USUARIO_principal usu = new RoadTrips_USUARIO_principal(this.facade, login);
                    usu.setVisible(true);
                    this.setVisible(false);
                }
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RoadTrips_LOGIN_principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RoadTrips_LOGIN_principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsuarioNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMensagem());
        }
  
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoadTrips_LOGIN_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoadTrips_LOGIN_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoadTrips_LOGIN_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoadTrips_LOGIN_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoadTrips_LOGIN_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JDialog jDialogUsuarioNaoEncontrado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelFundo1;
    private javax.swing.JLabel jLabelFundo2;
    private javax.swing.JLabel jLabelFundo3;
    private javax.swing.JLabel jLabelIcnMapaRoadTrips;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastrarse;
    private javax.swing.JMenuItem jMenuItemCadastrarUsuario;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables
}
