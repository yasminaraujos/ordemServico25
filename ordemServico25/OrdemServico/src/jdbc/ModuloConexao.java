/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
/**
 *
 * @author GERAL
 */
public class ModuloConexao {
    public static Connection conectar() {
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbos2025?characterEncoding=utf-8"; //useTimezone=true&serverTimezone=UTC
        String user = "root";
        String senha = "IFROOcrxi18$";
        //estabelecer a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!!");
            return conexao;
        } catch (Exception e) {
            //a lihna abaixo server de apoio para esclarecer o erro
            JOptionPane.showMessageDialog(null, "Opss, algo deu errado: " + e);
            return null; 
        }
    }
}
