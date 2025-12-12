/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import jdbc.ModuloConexao;
import model.OrdemServico;
/**
 *
 * @author Usuario
 */
public class OrdemServicoDAO {
     Connection conexao;

    public OrdemServicoDAO() {
        this.conexao = ModuloConexao.conectar();
    }

     /**
     * método responsável por adicionar Ordem de Serviço na base de dados
     *
     * @param obj
     */
    public void adicionarOrdemServico(OrdemServico obj) {

        try {
            //1 passo - criar o sql
            String sql = "insert into tbos(tipo, situacao,equipamento, defeito, servico, tecnico, valor, idcli) values(?,?,?,?,?,?,?,?)";
            //2 passo o conectar o banco de dados e organizar o comando sql
            conexao = ModuloConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getTipo());
            stmt.setString(2, obj.getSituacao());
            stmt.setString(3, obj.getEquipamento());
            stmt.setString(4, obj.getDefeito());
            stmt.setString(5, obj.getServico());
            stmt.setString(6, obj.getTecnico());
            stmt.setDouble(7, obj.getValor());
            stmt.setInt(8, obj.getCliente().getId());

            //3 passo - executar o comando sql
            stmt.execute();
            //  System.out.println(stmt);
            stmt.close();
            JOptionPane.showMessageDialog(null, "Ordem de Serviço cadastrada com sucesso!!");

        } catch (SQLIntegrityConstraintViolationException e1) {
            JOptionPane.showMessageDialog(null, "Cliente não pode ser nulo.\nSelecione um cliente na tabela.");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
