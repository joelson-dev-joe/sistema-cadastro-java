package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectFactory {
    
    public Connection getConnection(){
        
        try {
            
            return DriverManager.getConnection("jdbc:mysql://localhost/bdvendas", "root", "joemarvi2009@cdj36");
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
}
