package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectFactory;
import br.com.projeto.modal.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

            //Conectando ao Banco de Dados
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
    public void alterarCliente(Clientes obj){
        
        try {
            //Comando SQL
            String sql = "update set tb_clientes (nome=?, rg=?, email=?, cpf=?, telefone=?, celular=?, cep=?,"
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?)";
                    

            //Conectando ao Banco de Dados
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
            
            stmt.setInt(1, obj.getId());

            //Executando e fechando comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente" + erro);
        }
    
    }
    
    
    //Método excluiCliente
    public void excluirCliente(Clientes obj){
        
        try {
            //Comando SQL
            String sql = "delete from tb_clientes where id=?";

            //Conectando ao Banco de Dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());


            //Executando e fechando comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente excluído com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente" + erro);
        }
        
    }
    
    
    //Método Listando todos os clientes
    public List<Clientes> listarClientes() {

        try {
            //Criando lista de Clientes

            List<Clientes> lista = new ArrayList<>();

            //Criando SQL consulta
            String sql = "select *from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
}
