/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.dao;

/**
 *
 * @author alexsandro
 */
import com.mycompany.lojadeinstrumentos.model.ModeloRelatorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioDAO {

    public static ModeloRelatorio gerarRelatorioSintetico(ModeloRelatorio obj) {

        /* O ( objModelo) esta sendo criado aqui para ser alocado os atributos que vou puxar do banco de dados */
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT v.id_venda, v.data_venda, v.valor_total, c.id_cliente, c.nome AS nome, "
           + "(SELECT COUNT(*) FROM itemvenda WHERE id_Venda = v.id_venda) AS quantidade_produto "
           + "FROM venda v "
           + "INNER JOIN cliente c ON v.id_cliente = c.id_cliente "
           + "WHERE v.data_venda BETWEEN ? AND ?"
            );

            comandoSQL.setDate(1, new java.sql.Date(obj.getDataInicial().getTime()));
            comandoSQL.setDate(2, new java.sql.Date(obj.getDataFinal().getTime()));
            ResultSet resultSet = comandoSQL.executeQuery();
            if (resultSet != null) {
                obj.setListaRelatorio(new ArrayList<>());
                List<ModeloRelatorio> listaRelatorio = obj.getListaRelatorio();

                while (resultSet.next()) {
                    
                    int idVenda = resultSet.getInt("id_venda");
                    int quantidade = resultSet.getInt("quantidade_produto");
                    Double valorTotal = resultSet.getDouble("valor_total");
                    Date dataVenda = resultSet.getDate("data_venda");
                    

                    ModeloRelatorio item = new ModeloRelatorio();
                    item.setIdVenda(idVenda);
                    item.setQuantidadeProduto(quantidade);
                    item.setValorTotal(valorTotal);
                   
                    item.setDataVenda(dataVenda);

                    listaRelatorio.add(item);
                }

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        /*e aqui finalmente retorno o objModelo com os atributos do banco*/
        return obj;

    }//fim filtro

    public static ModeloRelatorio gerarRelatorioAnalitico(ModeloRelatorio obj) {

        /* O ( objModelo) esta sendo criado aqui para ser alocado os atributos que vou puxar do banco de dados */
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "SELECT iv.id_ItemVenda, iv.quantidade_produto, iv.valor_produto, "
                    + "p.produto AS nome_produto, v.id_venda, v.data_venda, v.valor_total, "
                    + "c.id_cliente, c.nome AS nome_cliente "
                    + "FROM itemvenda iv "
                    + "INNER JOIN produto p ON iv.id_produto = p.id_produto "
                    + "INNER JOIN venda v ON iv.id_Venda = v.id_venda "
                    + "INNER JOIN cliente c ON v.id_cliente = c.id_cliente "
                    + "WHERE v.data_venda BETWEEN ? AND ? ORDER BY iv.id_ItemVenda");

            comandoSQL.setDate(1, new java.sql.Date(obj.getDataInicial().getTime()));
            comandoSQL.setDate(2, new java.sql.Date(obj.getDataFinal().getTime()));
            ResultSet rs = comandoSQL.executeQuery();
            if (rs != null) {
                obj.setListaRelatorio(new ArrayList<>());
                List<ModeloRelatorio> listaRelatorio = obj.getListaRelatorio();

                while (rs.next()) {
                    int idItemVenda = rs.getInt("id_ItemVenda");
                    int quantidadeProduto = rs.getInt("quantidade_produto");
                    double valorProduto = rs.getDouble("valor_produto");
                    String nomeProduto = rs.getString("nome_produto");
                    int idVenda = rs.getInt("id_venda");
                    Date dataVenda = rs.getDate("data_venda");
                    double valorTotal = rs.getDouble("valor_total");
                    int idCliente = rs.getInt("id_cliente");
                    String nomeCliente = rs.getString("nome_cliente");

                    // Crie um objeto ModeloRelatorio com os dados obtidos do banco de dados
                    ModeloRelatorio item = new ModeloRelatorio();
                    item.setIdItemVenda(idItemVenda);
                    item.setQuantidadeProduto(quantidadeProduto);
                    item.setValorProduto(valorProduto);
                    item.setProduto(nomeProduto);
                    item.setIdVenda(idVenda);
                    item.setDataVenda(dataVenda);
                    item.setValorTotal(valorTotal);
                    item.setIdCliente(idCliente);
                    item.setCliente(nomeCliente);

                    listaRelatorio.add(item);
                }

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        /*e aqui finalmente retorno o objModelo com os atributos do banco*/
        return obj;

    }


    /* public List<ModeloRelatorio> gerarRelatorioSintetico(Date dataInicial, Date dataFinal) {
        List<ModeloRelatorio> vendas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM venda WHERE data_venda BETWEEN ? AND ?");
        ) {
            statement.setDate(1, new java.sql.Date(dataInicial.getTime()));
            statement.setDate(2, new java.sql.Date(dataFinal.getTime()));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ModeloRelatorio venda = new ModeloRelatorio();
                ModeloRelatorio.setIdVenda(resultSet.getInt("id_venda"));
                ModeloRelatorio.setIdCliente(resultSet.getInt("id_cliente"));
                ModeloRelatorio.setValorTotal(resultSet.getDouble("valor_total"));
                ModeloRelatorio.setDataVenda(resultSet.getDate("data_venda"));

                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }

    public List<ModeloRelatorio> gerarRelatorioAnalitico(Date dataInicial, Date dataFinal) {
        List<ModeloRelatorio> itensVenda = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT iv.* FROM itemvenda iv " +
                             "JOIN venda v ON iv.id_Venda = v.id_venda " +
                             "WHERE v.data_venda BETWEEN ? AND ?");
        ) {
            statement.setDate(1, new java.sql.Date(dataInicial.getTime()));
            statement.setDate(2, new java.sql.Date(dataFinal.getTime()));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ModeloRelatorio itemVenda = new ModeloRelatorio();
                itemVenda.setIdItemVenda(resultSet.getInt("id_ItemVenda"));
                itemVenda.setIdProduto(resultSet.getInt("id_produto"));
                itemVenda.setIdVenda(resultSet.getInt("id_Venda"));
                itemVenda.setQuantietValorProdadeProduto(resultSet.getInt("quantidade_produto"));
                itemVenda.sduto(resultSet.getDouble("valor_produto"));

                itensVenda.add(itemVenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itensVenda;
    }*/
}
