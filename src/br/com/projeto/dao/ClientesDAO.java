package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectFactory;
import br.com.projeto.modal.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //Método cadastraCliente
    public void cadastraCliente(Clientes obj) {

        try {
            //Comando SQL
            String sql = "insert into tb_clientes (nome, rg, email, cpf, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //Conecgtando ao Banco de Dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getCpf());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            
            //Executando e fechando comando SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente" + erro);
        }

    }

    //Método alteraCliente
    //Método excluiCliente
}
