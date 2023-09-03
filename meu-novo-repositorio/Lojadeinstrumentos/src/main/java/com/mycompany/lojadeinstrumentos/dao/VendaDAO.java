/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.dao;

import com.mycompany.lojadeinstrumentos.model.ModeloCadastroCliente;
import com.mycompany.lojadeinstrumentos.model.ModeloItem;
import com.mycompany.lojadeinstrumentos.model.ModeloVenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.SpringLayout;

/**
 *
 * @author alexsandro
 */
public class VendaDAO {

    public static ModeloVenda verificarQtd(ModeloVenda obj) {

        ModeloVenda objVendaDAO = new ModeloVenda();

        Connection conexao = null;
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 5
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            // passo 3 preparar o comando SQL
            /* cria um objeto "PreparedStatement" que contém uma consulta SQL para buscar todos os registros da tabela "computador" */
            for (ModeloItem item : obj.getListaItens()) {
                PreparedStatement comandoVerificarQuantidade = conexao.prepareStatement("SELECT quantidade_produto FROM produto WHERE id_produto = ?");
                comandoVerificarQuantidade.setInt(1, item.getIdProduto());
                ResultSet resultadoQuantidade = comandoVerificarQuantidade.executeQuery();

                if (resultadoQuantidade.next()) {

                    int quantidadeAtual = resultadoQuantidade.getInt("quantidade_produto");

                    if (quantidadeAtual >= item.getQtdProduto()) {

                        PreparedStatement comandoAtualizarProduto = conexao.prepareStatement("UPDATE produto SET quantidade_produto = quantidade_produto - ? WHERE id_produto = ?");
                        comandoAtualizarProduto.setInt(1, item.getQtdProduto());
                        comandoAtualizarProduto.setInt(2, item.getIdProduto());
                        int linhasAfetadasProduto = comandoAtualizarProduto.executeUpdate();
                        if (linhasAfetadasProduto > 0) {

                        } else {

                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver !!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar a conexão !!");
                }
            }
        }

        return objVendaDAO;

    }

    public static boolean finalizarVenda(ModeloVenda obj) {
        boolean retorno = false;
        ModeloItem itemAlterarBanco = new ModeloItem();
        ModeloVenda objVenda = new ModeloVenda();
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 5
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO venda (id_cliente,valor_total, data_venda) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setInt(1, obj.idCliente());
            comandoSQL.setDouble(2, obj.getValortotal());
            comandoSQL.setDate(3, new java.sql.Date(obj.getDataVenda().getTime()));

            //passo 4 executar o comando SQL 
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet resultadoDaKey = comandoSQL.getGeneratedKeys();
                if (resultadoDaKey.next()) {

                    int idVenda = resultadoDaKey.getInt(1);
                    for (ModeloItem item : obj.getListaItens()) {
                        PreparedStatement comandoVerificarQuantidade = conexao.prepareStatement("SELECT quantidade_produto FROM produto WHERE id_produto = ?");
                        comandoVerificarQuantidade.setInt(1, item.getIdProduto());
                        ResultSet resultadoQuantidade = comandoVerificarQuantidade.executeQuery();

                        if (resultadoQuantidade.next()) {

                            int quantidadeAtual = resultadoQuantidade.getInt("quantidade_produto");

                            if (quantidadeAtual >= item.getQtdProduto()) {

                                PreparedStatement comandoAtualizarProduto = conexao.prepareStatement("UPDATE produto SET quantidade_produto = quantidade_produto - ? WHERE id_produto = ?");
                                comandoAtualizarProduto.setInt(1, item.getQtdProduto());
                                comandoAtualizarProduto.setInt(2, item.getIdProduto());
                                int linhasAfetadasProduto = comandoAtualizarProduto.executeUpdate();
                                if (linhasAfetadasProduto > 0) {

                                } else {

                                }
                            }
                        }
                    }

                    for (ModeloItem item : obj.getListaItens()) {

                        PreparedStatement salvarItens = conexao.prepareStatement("insert into itemvenda (id_produto,id_Venda,quantidade_produto,valor_produto) VALUES(?,?,?,?)");

                        salvarItens.setInt(1, item.getIdProduto());
                        salvarItens.setInt(2, idVenda);
                        salvarItens.setInt(3, item.getQtdProduto());
                        salvarItens.setDouble(4, item.getValorProduto());

                        int linhasAfetadasNoItem = salvarItens.executeUpdate();
                        if (linhasAfetadasNoItem > 0) {

                            retorno = true;
                        }
                    }
                } else {
                    retorno = false;
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver !!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar a conexão !!");
                }
            }
        }

        return retorno;
    }
}
