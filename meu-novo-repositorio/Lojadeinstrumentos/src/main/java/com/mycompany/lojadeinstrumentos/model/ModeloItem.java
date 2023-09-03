/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.model;

/**
 *
 * @author alexsandro
 */
public class ModeloItem {
    
    private int idItem;
    private int idVenda;
    private int idProduto;
    private String nomeProduto;
    private double valorProduto;
    private int qtdProduto;

    public ModeloItem() {
    }
    

    public ModeloItem(int idItem, int idVenda, int idProduto, String nomeProduto, double valorProduto, int qtdProduto) {
        this.idItem = idItem;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtdProduto = qtdProduto;
    }

    public ModeloItem(int idItem, String nomeProduto, double valorProduto, int qtdProduto) {
        this.idItem = idItem;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtdProduto = qtdProduto;
    }
        
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
    
}
