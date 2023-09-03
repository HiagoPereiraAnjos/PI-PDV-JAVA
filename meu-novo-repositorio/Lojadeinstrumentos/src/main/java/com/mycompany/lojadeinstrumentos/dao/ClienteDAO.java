/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.dao;

import com.mycompany.lojadeinstrumentos.model.ModeloCadastroCliente;
import com.mycompany.lojadeinstrumentos.model.ModeloCadastroProduto;
import com.mycompany.lojadeinstrumentos.view.CadastroClienteProduto;
import com.mycompany.lojadeinstrumentos.view.TelaVendas;
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
/**
 *
 * @author alexsandro metodo salvar no banco
 *
 */
public class ClienteDAO {

    /**
     *
     * @param objASerSalvoNoBanco
     * @return
     */
    public static boolean salvar(ModeloCadastroCliente objASerSalvoNoBanco) {
        /* boolean para apanas retonar se salvou no banco ou nao */
        boolean retorno = false;
        Connection conexao = null;
        try {
            // passo 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            /* aqui passo qual vai ser o comando mas nao passo os valores na mesma linha, coloco os "?" e logo em seguida nas linhas abaixo preencho os valores */
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO cliente " + "(nome,cpf,dataNasc,cep,endereco,numero,complemento,bairro,celular,sexo,estadocivil,email)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            /* passando os valores para ser salvo, na ordem em que foi escrita, OS NOMES NO PARETESES TEM QUE SER IGUAL AO QUE ESTA NA TABLE DO BANCO */
            comandoSQL.setString(1, objASerSalvoNoBanco.getNomeCadastroCliente());
            comandoSQL.setString(2, objASerSalvoNoBanco.getCpfCadastroCliente());
            /* O DATE java é diferente do DATE sql, aqui passo o atributo do obj que esta em java para o sql usando o new.sql.Date, como se fosse um interger.parseInt*/
            comandoSQL.setDate(3, new java.sql.Date(objASerSalvoNoBanco.getDataNascimentoCadastroCliente().getTime()));
            comandoSQL.setString(4, objASerSalvoNoBanco.getCepClienteCadastroCliente());
            comandoSQL.setString(5, objASerSalvoNoBanco.getEnderecoCadastroCliente());
            comandoSQL.setInt(6, objASerSalvoNoBanco.getNumeroEnderecoCadastroCliente());
            comandoSQL.setString(7, objASerSalvoNoBanco.getComplementoClienteCadastroCliente());
            comandoSQL.setString(8, objASerSalvoNoBanco.getBairroClienteCadastroCliente());
            comandoSQL.setString(9, objASerSalvoNoBanco.getCelCadastroCliente());
            comandoSQL.setString(10, objASerSalvoNoBanco.getSexo());
            comandoSQL.setString(11, objASerSalvoNoBanco.getEstadoCivil());
            comandoSQL.setString(12, objASerSalvoNoBanco.getEmailCadastroCliente());

            //passo 4 excutar
            /* aqui é criado uma variavel int que ira amazenar o resultado do ComandoSQL.executeUpdate, que é oq vai fazer a alteraçao no banco, se for o valor 1 é pq foi concluido o
            comando que soliciatamos em cima */
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                /*aqui se o if valida se a variavel que criei para amazenar o retorno do comandoSQL.excuteupadate for maior que 0 e retorna o true, la e na tela de cadastro o true vai mostrar a mensagem de 
de cocluida 
                 */
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
     * Metodo que lista todos os clientes cadastrados
     *
     * @param filtrarTodos
     * @return ArrayList - listaRetorno
     */
    public static ArrayList<ModeloCadastroCliente> filtratTodos() {
        ArrayList<ModeloCadastroCliente> listaRetorno = new ArrayList<>();
        /* Esse metodo vai receber um objeto da classe ModeloCadastroCliente e vai retornar um obj da msm */

 /* O ( objModelo) esta sendo criado aqui para ser alocado os atributos que vou puxar do banco de dados */
        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
           
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente ");
          

            //passo 4 executar o comando SQL 
            ResultSet amazenarConsulta = comandoSQL.executeQuery();
            /* o resultSet esta com os valores, dai crio um obj dele  com o nome de amazenarConsulta e  dentro do loop while vou pegando os valores da tabela do banco de daods
            os nomes tem que ser igual ao do banco*/
            if (amazenarConsulta != null) {
                //percorro o resultset e passo os valores a um objeto 

                while (amazenarConsulta.next()) {
                    ModeloCadastroCliente objModelo = new ModeloCadastroCliente();
                    /* passando os valores das colunas do banco para o objModelo que criei no inicio do metodo e que irá retonar para a tela de cadastro*/
                    objModelo.setNomeCadastroCliente(amazenarConsulta.getString("nome"));
                    objModelo.setEmailCadastroCliente(amazenarConsulta.getString("email"));
                    objModelo.setCpfCadastroCliente(amazenarConsulta.getString("cpf"));
                    objModelo.setCepClienteCadastroCliente(amazenarConsulta.getString("CEP"));
                    objModelo.setEnderecoCadastroCliente(amazenarConsulta.getString("Endereco"));
                    objModelo.setNumeroEnderecoCadastroCliente(amazenarConsulta.getInt("numero"));
                    objModelo.setComplementoClienteCadastroCliente(amazenarConsulta.getString("complemento"));
                    objModelo.setBairroClienteCadastroCliente(amazenarConsulta.getString("bairro"));
                    objModelo.setCelCadastroCliente(amazenarConsulta.getString("celular"));
                    objModelo.setSexo(amazenarConsulta.getString("sexo"));
                    objModelo.setEstadoCivil(amazenarConsulta.getString("estadocivil"));
                    objModelo.setDataNascimentoCadastroCliente(amazenarConsulta.getDate("datanasc"));
                    objModelo.setIdCliente(amazenarConsulta.getInt("id_cliente"));
                    listaRetorno.add(objModelo);
                }
            } 
              
           
        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        /*e aqui finalmente retorno o objModelo com os atributos do banco*/
        return listaRetorno;

    }//fim filtro

    public static ModeloCadastroCliente filtro(ModeloCadastroCliente obj) {
        /* Esse metodo vai receber um objeto da classe ModeloCadastroCliente e vai retornar um obj da msm */
        ModeloCadastroCliente objModelo = new ModeloCadastroCliente();
        /* O ( objModelo) esta sendo criado aqui para ser alocado os atributos que vou puxar do banco de dados */

        Connection conexao = null;// conexao representa uma conexão ativa com um banco de dados.
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";
            conexao = DriverManager.getConnection(url, "root", ""); //estabelecendo a conexao para os receber resultados.
            // passo 3 preparar o comando SQL
            /* cria um objeto de  "PreparedStatement" comandoSQL, para buscar todos os registros da tabela "cliente" dai passo o comando vai vai ser excultado no banco  */
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente where cpf = ?");/* o interrogação vai servi para mandar o valor la linha de baixo*/
            comandoSQL.setString(1, obj.getCpfCadastroCliente());/* o (obj) é o objeto que vem de paramentro quando na tela de consultar digita o cpf e amazena em uma String depois 
            amazena no obj e manda para o esse metodo DAO, (O 1, obj.getCpfCadastroCliente() ) */

            //passo 4 executar o comando SQL 
            ResultSet amazenarConsulta = comandoSQL.executeQuery();
            /* o resultSet esta com os valores, dai crio um obj dele  com o nome de amazenarConsulta e  dentro do loop while vou pegando os valores da tabela do banco de daods
            os nomes tem que ser igual ao do banco*/
            if (amazenarConsulta != null) {
                //percorro o resultset e passo os valores a um objeto 

                while (amazenarConsulta.next()) {
                    /* passando os valores das colunas do banco para o objModelo que criei no inicio do metodo e que irá retonar para a tela de cadastro*/
                    objModelo.setNomeCadastroCliente(amazenarConsulta.getString("nome"));
                    objModelo.setEmailCadastroCliente(amazenarConsulta.getString("email"));
                    objModelo.setCpfCadastroCliente(amazenarConsulta.getString("cpf"));
                    objModelo.setCepClienteCadastroCliente(amazenarConsulta.getString("CEP"));
                    objModelo.setEnderecoCadastroCliente(amazenarConsulta.getString("Endereco"));
                    objModelo.setNumeroEnderecoCadastroCliente(amazenarConsulta.getInt("numero"));
                    objModelo.setComplementoClienteCadastroCliente(amazenarConsulta.getString("complemento"));
                    objModelo.setBairroClienteCadastroCliente(amazenarConsulta.getString("bairro"));
                    objModelo.setCelCadastroCliente(amazenarConsulta.getString("celular"));
                    objModelo.setSexo(amazenarConsulta.getString("sexo"));
                    objModelo.setEstadoCivil(amazenarConsulta.getString("estadocivil"));
                    objModelo.setDataNascimentoCadastroCliente(amazenarConsulta.getDate("datanasc"));
                    objModelo.setIdCliente(amazenarConsulta.getInt("id_cliente"));

                }
            } else {
                objModelo = null;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("erro ao carrregar o drive !!");
        } catch (SQLException ex) {
            System.out.println(" Erro ao abrir conexão !!");

        }
        /*e aqui finalmente retorno o objModelo com os atributos do banco*/
        return objModelo;

    }//fim filtro

    /**
     *
     * @param objASerSalvoNoBanco
     * @return
     */
    public static boolean alterar(ModeloCadastroCliente objASerSalvoNoBanco) {
        /* esse metodo so ira retornar true ou falso por ser uma ateraçao e nao precisar preencher algum obj ou lista e enviar a tela, assim o retorno sera validado na tela */

        boolean retorno = false;
        Connection conexao = null;

        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");

            //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, cpf = ? ,datanasc = ?, cep = ?, endereco = ? ,numero = ?, complemento = ?, bairro = ?,celular = ?,sexo = ?,estadocivil = ?,email = ? WHERE id_cliente= ?");
            /* aqui o ComandoSQL ira fazer o comando de alteraçao no banco, passando os nomes das colunas que vou precisar alterar e por ultimo a condiçao para a alteraçao 
            ser concretizada apenas com quando o id do cliente for o que o obj ira trazer, assim sendo possivel a troca do CPF tbm*/
            comandoSQL.setString(1, objASerSalvoNoBanco.getNomeCadastroCliente());
            comandoSQL.setString(2, objASerSalvoNoBanco.getCpfCadastroCliente());
            comandoSQL.setDate(3, new java.sql.Date(objASerSalvoNoBanco.getDataNascimentoCadastroCliente().getTime()));
            comandoSQL.setString(4, objASerSalvoNoBanco.getCepClienteCadastroCliente());
            comandoSQL.setString(5, objASerSalvoNoBanco.getEnderecoCadastroCliente());
            comandoSQL.setInt(6, objASerSalvoNoBanco.getNumeroEnderecoCadastroCliente());
            comandoSQL.setString(7, objASerSalvoNoBanco.getComplementoClienteCadastroCliente());
            comandoSQL.setString(8, objASerSalvoNoBanco.getBairroClienteCadastroCliente());
            comandoSQL.setString(9, objASerSalvoNoBanco.getCelCadastroCliente());
            comandoSQL.setString(10, objASerSalvoNoBanco.getSexo());
            comandoSQL.setString(11, objASerSalvoNoBanco.getEstadoCivil());
            comandoSQL.setString(12, objASerSalvoNoBanco.getEmailCadastroCliente());
            comandoSQL.setInt(13, objASerSalvoNoBanco.getIdCliente());

            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                /* aqui como se fosse o salvar, se foir afetado a linha no banco a variavel de linhasAfetadas ira ficar 1 e dai o retorno sera true */
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao");
        }

        return retorno;
    }//fim alterar

    public static boolean excluir(String id) {

        boolean retorno = false;
        Connection conexao = null;
        try {
            // passo 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojadeinstrumentos";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpf =?");

            comandoSQL.setString(1, id);

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
