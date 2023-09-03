/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.dao;

import com.mycompany.lojadeinstrumentos.model.ModeloCadastroProduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexsandro
 */
public class ProdutoDAO {

    /**
     *
     * @param obj
     * @return
     */
    public static boolean salvar(ModeloCadastroProduto obj) {

        boolean retorno = false;
        Connection conexao = null;
        try {
            // passo 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produto " + "(quantidade_produto,produto,valor_produto)VALUES (?,?,?)");

            comandoSQL.setInt(1, obj.getQntdProdutoCadastroProduto());

            comandoSQL.setString(2, obj.getNomeProdutoCadastroProduto());

            comandoSQL.setDouble(3, obj.getValorProdutoCadastroProduto());

            //passo 4 excutar
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver !!");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexão !!");
        }

        return retorno;

    }
    /**
     * 
     * @param obj
     * @return 
     */

    public static boolean alterar(ModeloCadastroProduto obj) {

        boolean retorno = false;
        Connection conexao = null;

        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");

            //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produto SET quantidade_produto = ?, produto = ?, valor_produto=? WHERE id_produto = ?");
            
            
            comandoSQL.setInt(1, obj.getQntdProdutoCadastroProduto());
            comandoSQL.setString(2, obj.getNomeProdutoCadastroProduto());
            comandoSQL.setDouble(3, obj.getValorProdutoCadastroProduto());
            comandoSQL.setInt(4, obj.getIdProdutoCadastroProduto());

            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao");
        }

        return retorno;

    }
    
    public static ModeloCadastroProduto consultarPorID(ModeloCadastroProduto obj) {
        ModeloCadastroProduto produtoRetorno = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            Connection conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Produto WHERE id_produto = ?");
            comandoSQL.setInt(1,obj.getIdProdutoCadastroProduto() );
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                if (rs .next()) {
                    produtoRetorno = new ModeloCadastroProduto();
                    produtoRetorno.setNomeProdutoCadastroProduto(rs.getString("produto"));
                    produtoRetorno.setQntdProdutoCadastroProduto(rs.getInt("quantidade_produto"));
                    produtoRetorno.setValorProdutoCadastroProduto(rs.getDouble("valor_produto"));
                }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return produtoRetorno;
        
    }
    
    
    public static ArrayList<ModeloCadastroProduto/*o tipo de objeto que o ArrayList irá armazenar*/> filtrarTodos( ) {

        ArrayList<ModeloCadastroProduto> listaRetorno = new ArrayList<>();
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            // passo 3 preparar o comando SQL
            /* cria um objeto "PreparedStatement" que contém uma consulta SQL para buscar todos os registros da tabela "computador" */
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto ");
            

            //passo 4 executar o comando SQL 
            ResultSet amazenarConsulta = comandoSQL.executeQuery();
            if (amazenarConsulta != null) {
                //percorro o resultset e passo os valores a um objeto 

                while (amazenarConsulta.next()) {
                    ModeloCadastroProduto objProdutoDAO = new ModeloCadastroProduto();

                    objProdutoDAO.setIdProdutoCadastroProduto(amazenarConsulta.getInt("id_produto"));
                    objProdutoDAO.setNomeProdutoCadastroProduto(amazenarConsulta.getString("produto"));
                    objProdutoDAO.setQntdProdutoCadastroProduto(amazenarConsulta.getInt("quantidade_produto"));
                    objProdutoDAO.setValorProdutoCadastroProduto(amazenarConsulta.getDouble("valor_produto"));
                    listaRetorno.add(objProdutoDAO);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        return listaRetorno;

    }
    
    
    public static ArrayList<ModeloCadastroProduto/*o tipo de objeto que o ArrayList irá armazenar*/> filtro(ModeloCadastroProduto obj) {

        ArrayList<ModeloCadastroProduto> listaRetorno = new ArrayList<>();
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            // passo 3 preparar o comando SQL
            /* cria um objeto "PreparedStatement" que contém uma consulta SQL para buscar todos os registros da tabela "computador" */
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto where produto = ?");
            comandoSQL.setString(1, obj.getNomeProdutoCadastroProduto());

            //passo 4 executar o comando SQL 
            ResultSet amazenarConsulta = comandoSQL.executeQuery();
            if (amazenarConsulta != null) {
                //percorro o resultset e passo os valores a um objeto 

                while (amazenarConsulta.next()) {
                    ModeloCadastroProduto objProdutoDAO = new ModeloCadastroProduto();

                    objProdutoDAO.setIdProdutoCadastroProduto(amazenarConsulta.getInt("id_produto"));
                    objProdutoDAO.setNomeProdutoCadastroProduto(amazenarConsulta.getString("produto"));
                    objProdutoDAO.setQntdProdutoCadastroProduto(amazenarConsulta.getInt("quantidade_produto"));
                    objProdutoDAO.setValorProdutoCadastroProduto(amazenarConsulta.getDouble("valor_produto"));
                    listaRetorno.add(objProdutoDAO);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        return listaRetorno;

    }
    /**
     * 
     * @param id
     * @return 
     */
    
    public static boolean excluir(int id) {

        boolean retorno = false;
        Connection conexao = null;
        try {
            // passo 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM produto WHERE id_produto =?");

            comandoSQL.setInt(1, id);

            //passo 4 excutar
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver !!");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexão !!");
        }
        return retorno;

    }
}
