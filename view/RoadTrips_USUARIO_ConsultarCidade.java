/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.view;

import br.uefs.ecomp.RoadTrips.controller.RoadTripsController;
import br.uefs.ecomp.RoadTrips.exceptions.CidadeNaoEncontradaException;
import br.uefs.ecomp.RoadTrips.exceptions.DataNotFoundException;
import br.uefs.ecomp.RoadTrips.exceptions.EstradaDuplicadaException;
import br.uefs.ecomp.RoadTrips.facade.RoadTripsFacade;
import br.uefs.ecomp.RoadTrips.model.Cidade;
import br.uefs.ecomp.RoadTrips.model.Interseccao;
import br.uefs.ecomp.RoadTrips.model.Ponto;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Natalia
 */
public class RoadTrips_USUARIO_ConsultarCidade extends javax.swing.JInternalFrame {
    private RoadTripsFacade facade;
    
    /**
     * Creates new form RoadTrips_ADM_CadastrarCidade
     */
    public RoadTrips_USUARIO_ConsultarCidade(RoadTripsFacade facade) {
        initComponents();
        this.facade = facade;
        preencheCidades();
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
        jLabelCidade = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox<>();
        jButtonConsultar = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Consultar Cidade");
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabelCidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCidade.setText("Cidade:");
        jPanel2.add(jLabelCidade);
        jLabelCidade.setBounds(30, 20, 120, 14);

        jComboBoxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCidadeActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCidade);
        jComboBoxCidade.setBounds(30, 40, 400, 20);

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonConsultar);
        jButtonConsultar.setBounds(293, 340, 130, 23);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uefs/ecomp/RoadTrips/imagens/fundo2.jpg"))); // NOI18N
        jPanel2.add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 470, 410);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 470, 410);

        setBounds(175, 200, 470, 439);
    }// </editor-fold>//GEN-END:initComponents

    public void preencheCidades(){
        jComboBoxCidade.removeAllItems();
        jComboBoxCidade.addItem("<Selecionar Op��o>");
        
        Iterator itr = facade.iteratorTodasCidade();
        while(itr.hasNext()){
            Object o = itr.next();
            if(o  instanceof Cidade){
                Cidade cidade = (Cidade)o;
                jComboBoxCidade.addItem(cidade.getNome());
            }
        }
    }
    
    
    private void jComboBoxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCidadeActionPerformed
        
    }//GEN-LAST:event_jComboBoxCidadeActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        Iterator itr = facade.iteratorTodasCidade();
        while(itr.hasNext()){
            Object o = itr.next();
            if(o  instanceof Cidade){
                Cidade cidade = (Cidade)o;
                if(jComboBoxCidade.getSelectedItem().equals(cidade.getNome())){
                    JOptionPane.showMessageDialog(rootPane, "Nome: "+cidade.getNome()+"\n"
                                                           +"Codigo: "+cidade.getCodigo()+"\n"
                                                           +"�rea: "+cidade.getArea()+"\n"
                                                           +"Popula��o: "+cidade.getPopulacao()+"\n"
                                                           +"Descri��o: "+cidade.getDescricao()+"\n"
                                                           +"Latitude: "+cidade.getLatitude()+"\n"
                                                           +"Longitude: "+cidade.getLongitude()+"\n"
                            
                    );
                }
            }
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JComboBox<String> jComboBoxCidade;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
