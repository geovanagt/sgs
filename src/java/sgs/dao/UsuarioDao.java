/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sgs.Servlets.controller.Usuarios;
///import sgs.factory.ConnectionFactory;

/**
 *
 * @author gick2
 */
public class UsuarioDao {
    
    private Connection connection;

public UsuarioDao() {
	//	this.connection = new ConnectionFactory().getConnection();
        String url="jdbc:postgresql://localhost:5432/sgs";
        String usr="admin_bd";
        String pass="12345";
        try {
            Class.forName("org.postgresql.Driver");
           
            connection = DriverManager.getConnection(url, usr, pass);
//            return con;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "O driver não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
//            return null;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas com a conexão\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//            return null;
        }
}

public boolean verificaUsuario (Usuarios usuarios) {

String sql = "select * from usuarios where nome=? and senha=?";
PreparedStatement ps;
try {
	ps = connection.prepareStatement(sql);
	ps.setString(1, usuarios.getUsuario());
	ps.setString(2, usuarios.getSenha());
	ResultSet resultSet = ps.executeQuery();
	if (resultSet.next()) {
		return true;
	}
} catch (SQLException ex) {
	Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
}
return false;
}

	

    
}
