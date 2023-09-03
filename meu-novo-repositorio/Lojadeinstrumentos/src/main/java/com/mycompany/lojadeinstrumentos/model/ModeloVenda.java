/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alexs
 */
public class ModeloVenda {

    /* declarando as variaveis */
    private int idVenda;
    private Date dataVenda;
    private Double valortotal;
    private int idProduto;
    private int idCliente;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    private ArrayList<ModeloItem> listaItens = null;

    /*Construtor vazio*/
    public ModeloVenda() {

    }

    public ModeloVenda(int idCliente, int idVenda, Date dataVenda, Double valortotal) {
        this.idCliente = idCliente;
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valortotal = valortotal;
    }

    public int idCliente() {
        return idCliente;
    }

    public void setidCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public ArrayList<ModeloItem> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<ModeloItem> listaItens) {
        this.listaItens = listaItens;
    }

}
