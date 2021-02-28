package br.com.projeto.jdbc;

import javax.swing.JOptionPane;

public class TestaConexao {

    public static void main(String[] args) {

        try {
            new ConectFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com Sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Falha na conexão!" + erro);
        }
    }

}
