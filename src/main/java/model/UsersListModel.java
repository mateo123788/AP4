/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author m.sage
 */
public class UsersListModel extends AbstractTableModel 
{

    
    private final String[] user = {"id","Nom", "Prenom", "Email", "Initial"};
    private ArrayList<User> users = new ArrayList<User>();
    
    public UsersListModel()
    {
        this.users.add(new User(1,"Zimmermann","Ethane","zimmermann@gmail.com","EZ"));
        this.users.add(new User(2,"Perot","Mathis","perot@gmail.com","MP"));
        this.users.add(new User(3,"Xiong","Teddy","xiong@gmail.com","TX"));
        this.users.add(new User(4,"Merguez","Paul","merguez@gmail.com","PM"));
        this.users.add(new User(5,"Pina","Ronald","pina@gmail.com","RP"));
        this.users.add(new User(6,"Duke","Prof1","duke@gmail.com","PD"));
        this.users.add(new User(7,"Ktm","Prof2","ktm@gmail.com","PK"));
    }

    public String getColumnName(int column) 
    {
        return this.user[column];
    }

    public int getRowCount() 
    {
        return this.users.size();
    }

    public int getColumnCount() 
    {
        return this.user.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        User i = users.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return i.getId();
            case 1:
                return i.getNom();
            case 2:
                return i.getPrenom();
            case 3:
                return i.getEmail();
            case 4:
                return i.getInitial();
            default:
                return null;
        }
    }
}
