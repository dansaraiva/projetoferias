
package br.com.ferias.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BDFERIAS",
                    "ferias","123");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
