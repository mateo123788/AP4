/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import model.UsersListModel;
import view.AddUserDialog;
import view.MainView;

/**
 *
 * @author m.sage
 */
public class MainControl implements PropertyChangeListener {

    //atribue
    MainView view;
    private UsersListModel usersListModel;
    private AddUserDialog addUserDialog;

    //constructeur
    public MainControl(MainView v) {
        this.usersListModel = new UsersListModel();
        this.view = v;
        this.view.addPropertyChangeListener(this);
        this.view.setTableModel(usersListModel);
        this.addUserDialog = new AddUserDialog(this.view, true);
        this.addUserDialog.addPropertyChangeListener(this);

    }

    //methodes
    //methodes pour afficher le message sur un bouton quand on click dessus
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "NewUser":
                // JOptionPane.showMessageDialog(this.view, this.view.message("page ajout un user"));
                this.addUserDialog.setVisible(true);
                break;
            case "DeleteUser":
                JOptionPane.showMessageDialog(this.view, this.view.message("voulez-vous supprimer un user ?"));
                break;
            case "UpdateUser":
                JOptionPane.showMessageDialog(this.view, this.view.message("page Modifier user"));
                break;
        }
    }

}
