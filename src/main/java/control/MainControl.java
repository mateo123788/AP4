/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import model.UsersListModel;
import view.MainView;

/**
 *
 * @author m.sage
 */
public class MainControl implements PropertyChangeListener 
{

    MainView view;
    
    private UsersListModel usersListModel;

    public MainControl(MainView v) 
    {
        this.usersListModel = new UsersListModel();
        this.view = v;
        this.view.addPropertyChangeListener(this);
        this.view.setTableModel(usersListModel);

    }

    public void propertyChange(PropertyChangeEvent evt) 
    {
        switch (evt.getPropertyName()) 
        {
            case "validUser":
                JOptionPane.showMessageDialog(this.view, this.view.message("hola senior"));
                break;
            case "validNouveauUser":
                break;
        }
    }

}
