/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgs.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gick2
 */
public class ConnectionFactory {
    
        private String url;
    private String usr;
    private String pass;
    
    public ConnectionFactory() {     
        url="jdbc:postgresql://localhost:5432/sgs";
        usr="admin_bd";
        pass="12345";
    }
    
    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
           
            Connection con = DriverManager.getConnection(url, usr, pass);
            return con;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "O driver não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas com a conexão\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}