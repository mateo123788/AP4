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
import view.UpdateUserDialog;

/**
 *
 * @author m.sage
 */
public class MainControl implements PropertyChangeListener {

    // atribue
    MainView view;
    private UsersListModel usersListModel;
    private UpdateUserDialog updateUserDialog;
    private AddUserDialog addUserDialog;

    // Constructeur
    public MainControl(MainView v) {
        this.usersListModel = new UsersListModel();

        this.view = v;
        this.view.addPropertyChangeListener(this);
        this.view.setTableModel(usersListModel);

        this.updateUserDialog = new UpdateUserDialog(this.view, true);
        this.updateUserDialog.addPropertyChangeListener(this);

        this.addUserDialog = new AddUserDialog(this.view, true);
        this.addUserDialog.addPropertyChangeListener(this);

    }

    private boolean valideEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }

    // Méthode qui va vérifié si les champs ne sont pas remplis
    private boolean valideChamp(String prenom, String nom, String identifiant, String motDePasse, String email) {
        return prenom != null && !prenom.trim().isEmpty()
                && nom != null && !nom.trim().isEmpty()
                && identifiant != null && !identifiant.trim().isEmpty()
                && motDePasse != null && !motDePasse.trim().isEmpty()
                && email != null && !email.trim().isEmpty();
    }

    private boolean nomEgalNomPrenom(String prenom, String nom) {
        return prenom != null && nom != null && !prenom.trim().equalsIgnoreCase(nom.trim());
    }

    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {

            case "MainViewNewUser":
                this.addUserDialog.setDefaultData();
                this.addUserDialog.setVisible(true);
                break;

            case "MainViewDeleteUser":
                int confirm = JOptionPane.showConfirmDialog(
                        this.view,
                        this.view.message("Voulez-vous supprimer cet utilisateur ?"),
                        "Confirmation de suppression",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int selectedUserId = this.view.getSelectID();
                        this.usersListModel.delete(selectedUserId);

                        JOptionPane.showMessageDialog(this.view, "Utilisateur supprimé avec succès.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this.view, "Aucun utilisateur sélectionné.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.view, "Suppression annulée.");
                }
                break;

            // Permet d'afficher les messages de confirmation pour modifier un utilisateur
            case "MainViewUpdateUser":
                int retour = JOptionPane.showConfirmDialog(
                        this.view,
                        this.view.message("Voulez-vous modifier cet utilisateur ?"),
                        "Confirmation de modification",
                        JOptionPane.YES_NO_OPTION);
                if (retour == JOptionPane.YES_OPTION) {
                    try {
                        // Récuperation des informations de l'utilisateur selectionné
                        this.updateUserDialog.setID(this.view.getSelectID());
                        this.updateUserDialog.setPrenom(this.view.getSelectPrenom());
                        this.updateUserDialog.setNom(this.view.getSelectNom());
                        this.updateUserDialog.setIdentifiant(this.view.getSelectIdentifiant());
                        this.updateUserDialog.setMotDePasse(this.view.getSelectMotDePasse());
                        this.updateUserDialog.setAdresseEmail(this.view.getSelectAdresseEmail());

                        // Affiche la View updateUserDialog
                        this.updateUserDialog.setVisible(true);

                        JOptionPane.showMessageDialog(this.view, "Utilisateur modifié avec succès.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this.view, "Aucun utilisateur sélectionné.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.view, "Modification annulée.");
                }
                break;
            // Permet de verifier
            case "validModif":
                String prenom = updateUserDialog.getPrenom();
                String nom = updateUserDialog.getNom();
                String identifiant = updateUserDialog.getIdentifiant();
                String motDePasse = updateUserDialog.getMotDePasse();
                String email = updateUserDialog.getAdresseEmail();
                // Vérifie que tous les champs sont remplis
                if (!valideChamp(prenom, nom, identifiant, motDePasse, email)) {
                    JOptionPane.showMessageDialog(
                            this.view,
                            "Tous les champs doivent être remplis.",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break;
                }

                // Vérifie la validité de l'email
                if (!valideEmail(email)) {
                    JOptionPane.showMessageDialog(
                            this.view,
                            "Adresse email invalide !",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break;
                }

                // Vérifie que Prénom et Nom sont différents
                if (!nomEgalNomPrenom(prenom, nom)) {
                    JOptionPane.showMessageDialog(
                            this.view,
                            "Le prénom et le nom ne peuvent pas être identiques.",
                            "Attention",
                            JOptionPane.WARNING_MESSAGE
                    );
                    break;
                }
                usersListModel.update(
                        updateUserDialog.getId(),
                        updateUserDialog.getPrenom(),
                        updateUserDialog.getNom(),
                        updateUserDialog.getIdentifiant(),
                        updateUserDialog.getMotDePasse(),
                        updateUserDialog.getAdresseEmail());
                updateUserDialog.setVisible(false);
                break;

            case "ValideAjoutUser":
                prenom = addUserDialog.getPrenom();
                nom = addUserDialog.getNom();
                identifiant = addUserDialog.getIdentifiant();
                motDePasse = addUserDialog.getMotDePasse();
                email = addUserDialog.getAdresseEmail();

                // Vérifie les champs
                if (!valideChamp(prenom, nom, identifiant, motDePasse, email)) {
                    JOptionPane.showMessageDialog(
                            this.view,
                            "Tous les champs doivent être remplis.",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                }
                // Vérifie la validité de l'email
                if (!valideEmail(email)) {
                    JOptionPane.showMessageDialog(
                            this.view,
                            "Adresse email invalide !",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                }
                // Vérifie que Prénom et Nom sont différents
                if (!nomEgalNomPrenom(prenom, nom)) {
                    JOptionPane.showMessageDialog(
                            this.view,
                            "Le prénom et le nom ne peuvent pas être identiques.",
                            "Erreur",
                            JOptionPane.WARNING_MESSAGE);
                    break;
                }
                usersListModel.create(
                        addUserDialog.getPrenom(),
                        addUserDialog.getNom(),
                        addUserDialog.getIdentifiant(),
                        addUserDialog.getMotDePasse(),
                        addUserDialog.getAdresseEmail());
                addUserDialog.setVisible(false);
                break;
        }
    }
}
