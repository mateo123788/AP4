/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.MySQLConnexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author m.sage
 */
public class UserDAO {

    private Connection connexion;

    // Constructeur USERDAO
    public UserDAO() {
        this.connexion = MySQLConnexion.getConnexion();
    }

    // Méthode récupérant tout les utilisateurs dans la base donnée.
    public ArrayList<User> findAll() {
        try {
            String query = "SELECT * FROM USER";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ResultSet res = ps.executeQuery();

            ArrayList<User> users = new ArrayList<User>();

            while (res.next()) {
                int id_user = res.getInt("ID_USER");
                String prenom_user = res.getString("PRENOM_USER");
                String nom_user = res.getString("NOM_USER");
                String identifiant_user = res.getString("IDENTIFIANT_USER");
                String mot_de_passe_user = res.getString("MOT_DE_PASSE_USER");
                String adresse_mail_user = res.getString("ADRESSE_MAIL_USER");

                users.add(new User(id_user, prenom_user, nom_user, identifiant_user, mot_de_passe_user, adresse_mail_user
                ));
            }
            return users;
        } catch (SQLException ex) {
            return null;
        }
    }

    public User create(User utilisateur) {
        try {
            String query = " INSERT INTO user ( ID_USER, `PRENOM_USER`, `NOM_USER`, `IDENTIFIANT_USER`, `MOT_DE_PASSE_USER`, `ADRESSE_MAIL_USER`) VALUES (?,?,?,?,?,?)";
             PreparedStatement ps = this.connexion.prepareStatement(query);
             System.out.println(query);
             ps.setString(1,null);
             ps.setString(2, utilisateur.getPrenom());
             ps.setString(3, utilisateur.getNom() );
             ps.setString(4, utilisateur.getIdentifiant());
             ps.setString(5, utilisateur.getPassword());
             ps.setString(6, utilisateur.getEmail());
             ps.executeUpdate();

          return utilisateur;    
        }catch (Exception e)  {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null," DB: Erreur lors de la création de l'utilisateur");
    return utilisateur;
    
    // Methode delete supprime un utilisateur dans la base de donnée.
    public void delete(int IdUser) {
        try {
            String query = "DELETE FROM USER WHERE ID_USER = ? ";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setInt(1, IdUser);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
