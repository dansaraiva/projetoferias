
package br.com.ferias.jdbc;

import javax.swing.JOptionPane;

public class TestaConexao {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: \n"+e);
        }
    }
}
