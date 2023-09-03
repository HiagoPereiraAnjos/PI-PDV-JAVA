/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alexsandro
 */
public class ModeloRelatorio {
    
    
    private Date data;
    private Date dataInicial;
    private Date dataFinal;
    private int IdVenda;
    private int IdCliente;
    private String cliente;
    private String produto;
    private double  ValorTotal;
    private Date dataVenda;
    private int IdItemVenda;
    private int IdProduto;
    private int QuantidadeProduto;
    private double ValorProduto;
            
     private ArrayList<ModeloRelatorio> listaRelatorio = null;

    public ArrayList<ModeloRelatorio> getListaRelatorio() {
        return listaRelatorio;
    }

    public void setListaRelatorio(ArrayList<ModeloRelatorio> listaRelatorio) {
        this.listaRelatorio = listaRelatorio;
    }

    public ModeloRelatorio() {
    }

    public ModeloRelatorio(Date dataInicial, Date dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(int IdVenda) {
        this.IdVenda = IdVenda;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Date getdataVenda() {
        return dataVenda;
    }

    public void setdataVenda(Date DataVenda) {
        this.dataVenda = DataVenda;
    }

    public int getIdItemVenda() {
        return IdItemVenda;
    }

    public void setIdItemVenda(int IdItemVenda) {
        this.IdItemVenda = IdItemVenda;
    }

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int IdProduto) {
        this.IdProduto = IdProduto;
    }

    public int getQuantidadeProduto() {
        return QuantidadeProduto;
    }

    public void setQuantidadeProduto(int QuantidadeProduto) {
        this.QuantidadeProduto = QuantidadeProduto;
    }

    public double getValorProduto() {
        return ValorProduto;
    }

    public void setValorProduto(double ValorProduto) {
        this.ValorProduto = ValorProduto;
    }
    
    
}
