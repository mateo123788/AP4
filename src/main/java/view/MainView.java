/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author m.sage
 */
public class MainView extends javax.swing.JFrame {

    //atribue
    private PropertyChangeSupport listeners = new PropertyChangeSupport(this);

    //methodes
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.addPropertyChangeListener(listener);
    }

    public String message(String message) {
        return message;
    }

    // Va sélectionner l'id de l'utilisateur dans la JTable lors d'un clique.
    public int getSelectedId() {
        return (Integer) this.usersList.getModel().getValueAt(this.usersList.getSelectedRow(), 0);
    }

    public void setTableModel(AbstractTableModel tableModel) {
        this.usersList.setModel(tableModel);

        this.usersList.removeColumn(this.usersList.getColumn("ID"));
    }

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonNewUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JTable();
        buttonDeleteUser = new javax.swing.JButton();
        buttonUpdateUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonNewUser.setText("Ajouter");
        buttonNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewUserActionPerformed(evt);
            }
        });

        usersList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(usersList);

        buttonDeleteUser.setText("Supprimer");
        buttonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteUserActionPerformed(evt);
            }
        });

        buttonUpdateUser.setText("Modifier");
        buttonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonNewUser)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonUpdateUser)
                        .addGap(407, 407, 407)
                        .addComponent(buttonDeleteUser)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(buttonNewUser)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeleteUser)
                    .addComponent(buttonUpdateUser))
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewUserActionPerformed
        listeners.firePropertyChange("NewUser", null, null);
    }//GEN-LAST:event_buttonNewUserActionPerformed

    private void buttonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteUserActionPerformed
        listeners.firePropertyChange("DeleteUser", null, null);
    }//GEN-LAST:event_buttonDeleteUserActionPerformed

    private void buttonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateUserActionPerformed
        listeners.firePropertyChange("UpdateUser", null, null);
    }//GEN-LAST:event_buttonUpdateUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeleteUser;
    private javax.swing.JButton buttonNewUser;
    private javax.swing.JButton buttonUpdateUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable usersList;
    // End of variables declaration//GEN-END:variables
}
