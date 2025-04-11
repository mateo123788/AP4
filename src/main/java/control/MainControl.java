/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.UserDAO;
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

    // Constructeur
    public MainControl(MainView v) {
        this.usersListModel = new UsersListModel();
        this.view = v;
        this.view.addPropertyChangeListener(this);
        this.view.setTableModel(usersListModel);
        this.addUserDialog = new AddUserDialog(this.view, true);
        this.addUserDialog.addPropertyChangeListener(this);

    }

    // Methodes
    // Methodes qui affichera le message sur un bouton quand on cliquera dessus.
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "NewUser":
                // JOptionPane.showMessageDialog(this.view, this.view.message("page ajout un user"));
                this.addUserDialog.setVisible(true);
                break;
            case "DeleteUser":
                int confirm = JOptionPane.showConfirmDialog(
                        this.view,
                        this.view.message("Voulez-vous supprimer cet utilisateur ?"),
                        "Confirmation de suppression",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int selectedUserId = this.view.getSelectedId(); 

                        UserDAO userDao = new UserDAO();
                        userDao.delete(selectedUserId); 

                        this.view.setTableModel(new UsersListModel()); 

                        JOptionPane.showMessageDialog(this.view, "Utilisateur supprimé avec succès.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(this.view, "Aucun utilisateur sélectionné.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this.view, "");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.view, "Suppression annulée.");
                }
                break;
            case "UpdateUser":
                JOptionPane.showMessageDialog(this.view, this.view.message("page Modifier user"));
                break;
        }
    }

}
