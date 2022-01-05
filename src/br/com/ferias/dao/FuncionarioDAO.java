
package br.com.ferias.dao;

import br.com.ferias.jdbc.ConnectionFactory;
import br.com.ferias.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    
    private Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void salvarFuncionario(Funcionario fun) {
        try {
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fun.getNome());
            stmt.setString(2, fun.getRg());
            stmt.setString(3, fun.getCpf());
            stmt.setString(4, fun.getEmail());
            
            stmt.setString(5, fun.getSenha());
            stmt.setString(6, fun.getCargo());
            stmt.setString(7, fun.getNivelAcesso());
            
            
            stmt.setString(8, fun.getTelefone());
            stmt.setString(9, fun.getCelular());
            stmt.setString(10, fun.getCep());
            stmt.setString(11, fun.getEndereco());
            stmt.setInt(12, fun.getNumero());
            stmt.setString(13, fun.getComplemento());
            stmt.setString(14, fun.getBairro());
            stmt.setString(15, fun.getCidade());
            stmt.setString(16, fun.getEstado());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo aconteceu: \n" + e);
        }
    }public List<Funcionario> listarFuncionarios(){
        try {
            List<Funcionario> funcionarios = new ArrayList<>();
            
            String sql = "SELECT * FROM tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario fun = new Funcionario();
                fun.setId(rs.getInt("id"));
                fun.setNome(rs.getString("nome"));
                fun.setRg(rs.getString("rg"));
                fun.setCpf(rs.getString("cpf"));
                fun.setEmail(rs.getString("email"));
                
                fun.setSenha(rs.getString("senha"));
                fun.setCargo(rs.getString("cargo"));
                fun.setNivelAcesso(rs.getString("nivel_acesso"));
                
                fun.setTelefone(rs.getString("telefone"));
                fun.setCelular(rs.getString("celular"));
                fun.setCep(rs.getString("cep"));
                fun.setEndereco(rs.getString("endereco"));
                fun.setNumero(rs.getInt("numero"));
                fun.setComplemento(rs.getString("complemento"));
                fun.setBairro(rs.getString("bairro"));
                fun.setCidade(rs.getString("cidade"));
                fun.setEstado(rs.getString("estado"));
                
                funcionarios.add(fun);
            }
            
            return funcionarios;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta: \n"+e);
            return null;
        }
        
    }

}
