/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.model;

/**
 *
 * @author alexsandro.lsipelli
 */
public class ModeloCadastroProduto {

    //Cadastro Produto
    private int idProdutoCadastroProduto;
    private int qntdProdutoCadastroProduto;
    private String nomeProdutoCadastroProduto;
    private double valorProdutoCadastroProduto;

    //Construtor vazio
   public ModeloCadastroProduto() {

    }

    public ModeloCadastroProduto(int idProdutoCadastroProduto, int qntdProdutoCadastroProduto, String nomeProdutoCadastroProduto, double valorProdutoCadastroProduto) {
        this.idProdutoCadastroProduto = idProdutoCadastroProduto;
        this.qntdProdutoCadastroProduto = qntdProdutoCadastroProduto;
        this.nomeProdutoCadastroProduto = nomeProdutoCadastroProduto;
        this.valorProdutoCadastroProduto = valorProdutoCadastroProduto;
    }

    public ModeloCadastroProduto( int qntdProdutoCadastroProduto, String nomeProdutoCadastroProduto, double valorProdutoCadastroProduto) {
        
        this.qntdProdutoCadastroProduto = qntdProdutoCadastroProduto;
        this.nomeProdutoCadastroProduto = nomeProdutoCadastroProduto;
        this.valorProdutoCadastroProduto = valorProdutoCadastroProduto;
    }
   

    //Getters e Setters Produto
    public int getIdProdutoCadastroProduto() {
        return idProdutoCadastroProduto;
    }

    public void setIdProdutoCadastroProduto(int idProdutoCadastroProduto) {
        this.idProdutoCadastroProduto = idProdutoCadastroProduto;
    }

    public int getQntdProdutoCadastroProduto() {
        return qntdProdutoCadastroProduto;
    }

    public void setQntdProdutoCadastroProduto(int qntdProdutoCadastroProduto) {
        this.qntdProdutoCadastroProduto = qntdProdutoCadastroProduto;
    }

    public String getNomeProdutoCadastroProduto() {
        return nomeProdutoCadastroProduto;
    }

    public void setNomeProdutoCadastroProduto(String nomeProdutoCadastroProduto) {
        this.nomeProdutoCadastroProduto = nomeProdutoCadastroProduto;
    }

    public double getValorProdutoCadastroProduto() {
        return valorProdutoCadastroProduto;
    }

    public void setValorProdutoCadastroProduto(double valorProdutoCadastroProduto) {
        this.valorProdutoCadastroProduto = valorProdutoCadastroProduto;
    }

}
