/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.model;

import java.util.Date;

/**
 *
 * @author hiago
 */
public class ModeloCadastroCliente {

    //Cadastro Cliente
    private int idCliente;
    private String nomeCadastroCliente;
    private String cpfCadastroCliente;
    private Date dataNascimentoCadastroCliente;
    private String cepClienteCadastroCliente;
    private String enderecoCadastroCliente;
    private int numeroEnderecoCadastroCliente;
    private String complementoClienteCadastroCliente;
    private String bairroClienteCadastroCliente;
    private String celCadastroCliente;
    private String emailCadastroCliente;
    private String sexo;
    private String estadoCivil;

    //Construtor vazio
    public ModeloCadastroCliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ModeloCadastroCliente( String nomeCadastroCliente, String cpfCadastroCliente, Date dataNascimentoCadastroCliente, String cepClienteCadastroCliente, String enderecoCadastroCliente, int numeroEnderecoCadastroCliente, String complementoClienteCadastroCliente, String bairroClienteCadastroCliente, String celCadastroCliente, String emailCadastroCliente, String sexo, String estadoCivil) {
       
        this.nomeCadastroCliente = nomeCadastroCliente;
        this.cpfCadastroCliente = cpfCadastroCliente;
        this.dataNascimentoCadastroCliente = dataNascimentoCadastroCliente;
        this.cepClienteCadastroCliente = cepClienteCadastroCliente;
        this.enderecoCadastroCliente = enderecoCadastroCliente;
        this.numeroEnderecoCadastroCliente = numeroEnderecoCadastroCliente;
        this.complementoClienteCadastroCliente = complementoClienteCadastroCliente;
        this.bairroClienteCadastroCliente = bairroClienteCadastroCliente;
        this.celCadastroCliente = celCadastroCliente;
        this.emailCadastroCliente = emailCadastroCliente;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public ModeloCadastroCliente(int idCliente, String nomeCadastroCliente, String cpfCadastroCliente, Date dataNascimentoCadastroCliente, String cepClienteCadastroCliente, String enderecoCadastroCliente, int numeroEnderecoCadastroCliente, String complementoClienteCadastroCliente, String bairroClienteCadastroCliente, String celCadastroCliente, String emailCadastroCliente, String sexo, String estadoCivil) {
        this.idCliente = idCliente;
        this.nomeCadastroCliente = nomeCadastroCliente;
        this.cpfCadastroCliente = cpfCadastroCliente;
        this.dataNascimentoCadastroCliente = dataNascimentoCadastroCliente;
        this.cepClienteCadastroCliente = cepClienteCadastroCliente;
        this.enderecoCadastroCliente = enderecoCadastroCliente;
        this.numeroEnderecoCadastroCliente = numeroEnderecoCadastroCliente;
        this.complementoClienteCadastroCliente = complementoClienteCadastroCliente;
        this.bairroClienteCadastroCliente = bairroClienteCadastroCliente;
        this.celCadastroCliente = celCadastroCliente;
        this.emailCadastroCliente = emailCadastroCliente;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

   
    
   

    public String getNomeCadastroCliente() {
        return nomeCadastroCliente;
    }

    public void setNomeCadastroCliente(String nomeCadastroCliente) {
        this.nomeCadastroCliente = nomeCadastroCliente;
    }

    public String getCpfCadastroCliente() {
        return cpfCadastroCliente;
    }

    public void setCpfCadastroCliente(String cpfCadastroCliente) {
        this.cpfCadastroCliente = cpfCadastroCliente;
    }

    public Date getDataNascimentoCadastroCliente() {
        return dataNascimentoCadastroCliente;
    }

    public void setDataNascimentoCadastroCliente(Date dataNascimentoCadastroCliente) {
        this.dataNascimentoCadastroCliente = dataNascimentoCadastroCliente;
    }

    public String getCepClienteCadastroCliente() {
        return cepClienteCadastroCliente;
    }

    public void setCepClienteCadastroCliente(String cepClienteCadastroCliente) {
        this.cepClienteCadastroCliente = cepClienteCadastroCliente;
    }

    public String getEnderecoCadastroCliente() {
        return enderecoCadastroCliente;
    }

    public void setEnderecoCadastroCliente(String enderecoCadastroCliente) {
        this.enderecoCadastroCliente = enderecoCadastroCliente;
    }

    public int getNumeroEnderecoCadastroCliente() {
        return numeroEnderecoCadastroCliente;
    }

    public void setNumeroEnderecoCadastroCliente(int numeroEnderecoCadastroCliente) {
        this.numeroEnderecoCadastroCliente = numeroEnderecoCadastroCliente;
    }

    public String getComplementoClienteCadastroCliente() {
        return complementoClienteCadastroCliente;
    }

    public void setComplementoClienteCadastroCliente(String complementoClienteCadastroCliente) {
        this.complementoClienteCadastroCliente = complementoClienteCadastroCliente;
    }

    public String getBairroClienteCadastroCliente() {
        return bairroClienteCadastroCliente;
    }

    public void setBairroClienteCadastroCliente(String bairroClienteCadastroCliente) {
        this.bairroClienteCadastroCliente = bairroClienteCadastroCliente;
    }

    public String getCelCadastroCliente() {
        return celCadastroCliente;
    }

    public void setCelCadastroCliente(String celCadastroCliente) {
        this.celCadastroCliente = celCadastroCliente;
    }

    public String getEmailCadastroCliente() {
        return emailCadastroCliente;
    }

    public void setEmailCadastroCliente(String emailCadastroCliente) {
        this.emailCadastroCliente = emailCadastroCliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}
