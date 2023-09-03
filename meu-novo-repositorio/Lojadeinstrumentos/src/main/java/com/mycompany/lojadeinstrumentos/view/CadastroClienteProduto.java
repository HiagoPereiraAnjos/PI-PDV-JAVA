/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lojadeinstrumentos.view;

import com.mycompany.lojadeinstrumentos.dao.ClienteDAO;
import com.mycompany.lojadeinstrumentos.dao.ProdutoDAO;
import com.mycompany.lojadeinstrumentos.model.ModeloCadastroCliente;
import com.mycompany.lojadeinstrumentos.model.ModeloCadastroProduto;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hiago
 */
public class CadastroClienteProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    ModeloCadastroProduto produto = new ModeloCadastroProduto();
    ModeloCadastroCliente cliente = new ModeloCadastroCliente();
    ModeloCadastroCliente clientealterar = new ModeloCadastroCliente();

    ModeloCadastroCliente modeloAlterarParametros;
    ModeloCadastroProduto objProdutoAlterar;
    
    

    public CadastroClienteProduto(ModeloCadastroProduto obj) {
        initComponents();

        //Pegar os dados do obj e passar para o formulário
        txtNomeProdutoCadastroProduto.setText(obj.getNomeProdutoCadastroProduto());
        txtValorProdutoCadastroProduto.setText(String.valueOf((obj.getValorProdutoCadastroProduto())));
        txtQntdProdutoCadastroProduto.setText(String.valueOf(obj.getQntdProdutoCadastroProduto()));

        this.objProdutoAlterar = obj;
    }

    public CadastroClienteProduto(ModeloCadastroCliente obj) {
        initComponents();

        //Pegar os dados do obj e passar para o formulário
        txtNomeCadastroCliente.setText(obj.getNomeCadastroCliente());
        txtCPFCadastroCliente.setText(obj.getCpfCadastroCliente());
        dcDataNasc.setDate(obj.getDataNascimentoCadastroCliente());
        txtEnderecoCadastroCliente.setText(obj.getEnderecoCadastroCliente());
        txtNumeroEnderecoCadastroCliente.setText(String.valueOf(obj.getNumeroEnderecoCadastroCliente()));
        txtComplementoClienteCadastroCliente.setText(obj.getComplementoClienteCadastroCliente());
        txtBairroClienteCadastroCliente.setText(obj.getBairroClienteCadastroCliente());
        txtCelCadastroCliente.setText(obj.getCelCadastroCliente());
        txtEmailCadastroCliente.setText(obj.getEmailCadastroCliente());
        txtCEPClienteCadastroCliente.setText(obj.getCepClienteCadastroCliente());
        /**
         * criando uma String para ticar a opçao que vai vim do banco de dados,
         * se casso for true o radio bot ira ser ticado e nao, o outro será
         */
        String selecionaSexoRBO = "Masculino";
        if (obj.getSexo().equals(selecionaSexoRBO)) {
            rboMasculinoCadastroCliente.setSelected(true);
        } else {

            rboFemininoCadastroCliente.setSelected(true);

        }
        String selecionaEstadoRBOSolteiro = "Solteiro";

        String selecionaEstadoRBOcasado = "Casado";

        if (obj.getEstadoCivil().equals(selecionaEstadoRBOcasado)) {
            rboCasadoCadastroCliente.setSelected(true);
        } else if (obj.getEstadoCivil().equals(selecionaEstadoRBOSolteiro)) {
            rboSolteiroCadastroCliente.setSelected(true);

        } else {

            rboViuvoCadastroCliente.setSelected(true);
        }

        this.modeloAlterarParametros = obj;
    }

    public CadastroClienteProduto() {
        initComponents();
        this.setLocationRelativeTo(null);

        DefaultTableModel modeloProduto = (DefaultTableModel) tblProdutoCadastroProduto.getModel();
        tblProdutoCadastroProduto.setRowSorter(new TableRowSorter(modeloProduto));
        DefaultTableModel modeloCliente = (DefaultTableModel) tblClienteCadastroCliente.getModel();
        tblClienteCadastroCliente.setRowSorter(new TableRowSorter(modeloCliente));

    }

    public CadastroClienteProduto(ButtonGroup bgEstadoCivilCadastroCliente, ButtonGroup bgSexoCadastroCliente, JRadioButton rboCasadoCadastroCliente, JRadioButton rboFemininoCadastroCliente, JRadioButton rboMasculinoCadastroCliente, JRadioButton rboSolteiroCadastroCliente, JRadioButton rboViuvoCadastroCliente, JTextField txtBairroClienteCadastroCliente, JFormattedTextField txtCEPClienteCadastroCliente, JFormattedTextField txtCPFCadastroCliente, JFormattedTextField txtCelCadastroCliente, JTextField txtComplementoClienteCadastroCliente, JDateChooser txtDatadeNascimentoCadastroCliente, JTextField txtEmailCadastroCliente, JTextField txtEnderecoCadastroCliente, JTextField txtNomeCadastroCliente, JTextField txtNumeroEnderecoCadastroCliente) {
        this.bgEstadoCivilCadastroCliente = bgEstadoCivilCadastroCliente;
        this.bgSexoCadastroCliente = bgSexoCadastroCliente;
        this.rboCasadoCadastroCliente = rboCasadoCadastroCliente;
        this.rboFemininoCadastroCliente = rboFemininoCadastroCliente;
        this.rboMasculinoCadastroCliente = rboMasculinoCadastroCliente;
        this.rboSolteiroCadastroCliente = rboSolteiroCadastroCliente;
        this.rboViuvoCadastroCliente = rboViuvoCadastroCliente;
        this.txtBairroClienteCadastroCliente = txtBairroClienteCadastroCliente;
        this.txtCEPClienteCadastroCliente = txtCEPClienteCadastroCliente;
        this.txtCPFCadastroCliente = txtCPFCadastroCliente;
        this.txtCelCadastroCliente = txtCelCadastroCliente;
        this.txtComplementoClienteCadastroCliente = txtComplementoClienteCadastroCliente;
        this.dcDataNasc = txtDatadeNascimentoCadastroCliente;
        this.txtEmailCadastroCliente = txtEmailCadastroCliente;
        this.txtEnderecoCadastroCliente = txtEnderecoCadastroCliente;
        this.txtNomeCadastroCliente = txtNomeCadastroCliente;
        this.txtNumeroEnderecoCadastroCliente = txtNumeroEnderecoCadastroCliente;
    }

    public Object getTabelaCliente() {
        return tblClienteCadastroCliente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexoCadastroCliente = new javax.swing.ButtonGroup();
        bgEstadoCivilCadastroCliente = new javax.swing.ButtonGroup();
        pnlCadastroProduto = new javax.swing.JTabbedPane();
        pnlTelaCadastroProduto = new javax.swing.JPanel();
        lblNomeProdutoCadastroProduto = new javax.swing.JLabel();
        txtNomeProdutoCadastroProduto = new javax.swing.JTextField();
        lblValorProdutoCadastroProdutoProduto = new javax.swing.JLabel();
        btnConfirmarCadastroProduto = new javax.swing.JButton();
        btnSairCadastroProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutoCadastroProduto = new javax.swing.JTable();
        lblQntdProdutoCadastroProduto = new javax.swing.JLabel();
        txtQntdProdutoCadastroProduto = new javax.swing.JTextField();
        btnExcluirProdutoCadastroProduto = new javax.swing.JButton();
        btnAlterarProdutoCadastroProduto = new javax.swing.JButton();
        txtValorProdutoCadastroProduto = new javax.swing.JTextField();
        btnLimparProdutoCadastroProduto = new javax.swing.JButton();
        btnPesquisarProdutoCadastroProduto = new javax.swing.JButton();
        txtpesquisa = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        btnVerTodos = new javax.swing.JButton();
        pnlTelaCadastroCliente = new javax.swing.JPanel();
        lbNomeCadastroCliente = new javax.swing.JLabel();
        lblCPFCadastroCliente = new javax.swing.JLabel();
        lblEnderecoCadastroCliente = new javax.swing.JLabel();
        lblCelCadastroCliente = new javax.swing.JLabel();
        lblSexoCadastroCliente = new javax.swing.JLabel();
        lblEstadoCivilCadastroCliente = new javax.swing.JLabel();
        lblDatadeNascimentoCadastroCliente = new javax.swing.JLabel();
        lblEmailCadastroCliente = new javax.swing.JLabel();
        txtCPFCadastroCliente = new javax.swing.JFormattedTextField();
        txtNomeCadastroCliente = new javax.swing.JTextField();
        txtEnderecoCadastroCliente = new javax.swing.JTextField();
        txtNumeroEnderecoCadastroCliente = new javax.swing.JTextField();
        lblNumeroEnderecoCadastroCliente = new javax.swing.JLabel();
        txtCelCadastroCliente = new javax.swing.JFormattedTextField();
        txtEmailCadastroCliente = new javax.swing.JTextField();
        rboFemininoCadastroCliente = new javax.swing.JRadioButton();
        rboMasculinoCadastroCliente = new javax.swing.JRadioButton();
        rboSolteiroCadastroCliente = new javax.swing.JRadioButton();
        rboCasadoCadastroCliente = new javax.swing.JRadioButton();
        rboViuvoCadastroCliente = new javax.swing.JRadioButton();
        btnConfirmarCadastroCliente = new javax.swing.JButton();
        btnAlterarclienteCadastroCliente = new javax.swing.JButton();
        btnSairCadastroCliente = new javax.swing.JButton();
        lblComplementoClienteCadastroCliente = new javax.swing.JLabel();
        txtComplementoClienteCadastroCliente = new javax.swing.JTextField();
        lblBairroClienteCadastroCliente = new javax.swing.JLabel();
        txtBairroClienteCadastroCliente = new javax.swing.JTextField();
        lblCEPClienteCadastroCliente = new javax.swing.JLabel();
        txtCEPClienteCadastroCliente = new javax.swing.JFormattedTextField();
        btnExcluirClienteCadastroCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClienteCadastroCliente = new javax.swing.JTable();
        btnPesquisarClienteCadastroCliente = new javax.swing.JButton();
        btnLimparClienteCadastroCliente = new javax.swing.JButton();
        dcDataNasc = new com.toedter.calendar.JDateChooser();
        txtCPFPesquisar = new javax.swing.JFormattedTextField();
        ID = new java.awt.Label();
        lblidCliente = new javax.swing.JLabel();
        btnVerTodosCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MANUTENÇÃO");

        pnlCadastroProduto.setToolTipText("");

        pnlTelaCadastroProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTelaCadastroProduto.setPreferredSize(new java.awt.Dimension(600, 500));

        lblNomeProdutoCadastroProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNomeProdutoCadastroProduto.setText("Produto:");

        txtNomeProdutoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdutoCadastroProdutoActionPerformed(evt);
            }
        });
        txtNomeProdutoCadastroProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeProdutoCadastroProdutoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeProdutoCadastroProdutoKeyTyped(evt);
            }
        });

        lblValorProdutoCadastroProdutoProduto.setText("Valor produto:");

        btnConfirmarCadastroProduto.setText("Confirmar");
        btnConfirmarCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCadastroProdutoActionPerformed(evt);
            }
        });

        btnSairCadastroProduto.setText("Sair");
        btnSairCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCadastroProdutoActionPerformed(evt);
            }
        });

        tblProdutoCadastroProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblProdutoCadastroProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID:", "Qntd.:", "Produto:", "Valor produto:"
            }
        ));
        tblProdutoCadastroProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoCadastroProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutoCadastroProduto);

        lblQntdProdutoCadastroProduto.setText("Quantidade:");

        txtQntdProdutoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQntdProdutoCadastroProdutoActionPerformed(evt);
            }
        });
        txtQntdProdutoCadastroProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQntdProdutoCadastroProdutoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQntdProdutoCadastroProdutoKeyTyped(evt);
            }
        });

        btnExcluirProdutoCadastroProduto.setText("Excluir");
        btnExcluirProdutoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoCadastroProdutoActionPerformed(evt);
            }
        });

        btnAlterarProdutoCadastroProduto.setText("Alterar");
        btnAlterarProdutoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarProdutoCadastroProdutoActionPerformed(evt);
            }
        });

        txtValorProdutoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorProdutoCadastroProdutoActionPerformed(evt);
            }
        });
        txtValorProdutoCadastroProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorProdutoCadastroProdutoKeyTyped(evt);
            }
        });

        btnLimparProdutoCadastroProduto.setText("Limpar");
        btnLimparProdutoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparProdutoCadastroProdutoActionPerformed(evt);
            }
        });

        btnPesquisarProdutoCadastroProduto.setText("Pesquisar");
        btnPesquisarProdutoCadastroProduto.setPreferredSize(new java.awt.Dimension(72, 22));
        btnPesquisarProdutoCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoCadastroProdutoActionPerformed(evt);
            }
        });

        txtpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisaActionPerformed(evt);
            }
        });

        lblID.setText("\n");

        label1.setText("ID:");

        btnVerTodos.setText("Ver todos");
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTelaCadastroProdutoLayout = new javax.swing.GroupLayout(pnlTelaCadastroProduto);
        pnlTelaCadastroProduto.setLayout(pnlTelaCadastroProdutoLayout);
        pnlTelaCadastroProdutoLayout.setHorizontalGroup(
            pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblValorProdutoCadastroProdutoProduto)
                    .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNomeProdutoCadastroProduto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                        .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                                .addComponent(txtNomeProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lblQntdProdutoCadastroProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQntdProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtValorProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                        .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                                .addComponent(btnConfirmarCadastroProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarProdutoCadastroProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimparProdutoCadastroProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSairCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnVerTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(btnPesquisarProdutoCadastroProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(71, 392, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        pnlTelaCadastroProdutoLayout.setVerticalGroup(
            pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaCadastroProdutoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQntdProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQntdProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorProdutoCadastroProdutoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSairCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTelaCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisarProdutoCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerTodos)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pnlCadastroProduto.addTab("Cadastro de Produto", pnlTelaCadastroProduto);

        pnlTelaCadastroCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTelaCadastroCliente.setPreferredSize(new java.awt.Dimension(1096, 1096));

        lbNomeCadastroCliente.setText("Nome:");

        lblCPFCadastroCliente.setText("CPF:");

        lblEnderecoCadastroCliente.setText("Endereço:");

        lblCelCadastroCliente.setText("Cel:");

        lblSexoCadastroCliente.setText("Sexo:");

        lblEstadoCivilCadastroCliente.setText("Estado civil:");

        lblDatadeNascimentoCadastroCliente.setText("Data de Nascimento:");

        lblEmailCadastroCliente.setText("Email:");

        try {
            txtCPFCadastroCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFCadastroCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPFCadastroClienteFocusLost(evt);
            }
        });
        txtCPFCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFCadastroClienteActionPerformed(evt);
            }
        });
        txtCPFCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPFCadastroClienteKeyTyped(evt);
            }
        });

        txtNomeCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCadastroClienteActionPerformed(evt);
            }
        });
        txtNomeCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeCadastroClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeCadastroClienteKeyTyped(evt);
            }
        });

        txtEnderecoCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoCadastroClienteActionPerformed(evt);
            }
        });
        txtEnderecoCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEnderecoCadastroClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnderecoCadastroClienteKeyTyped(evt);
            }
        });

        txtNumeroEnderecoCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroEnderecoCadastroClienteActionPerformed(evt);
            }
        });
        txtNumeroEnderecoCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroEnderecoCadastroClienteKeyTyped(evt);
            }
        });

        lblNumeroEnderecoCadastroCliente.setText("N:º");

        try {
            txtCelCadastroCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelCadastroClienteActionPerformed(evt);
            }
        });
        txtCelCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelCadastroClienteKeyTyped(evt);
            }
        });

        txtEmailCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailCadastroClienteActionPerformed(evt);
            }
        });
        txtEmailCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailCadastroClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailCadastroClienteKeyTyped(evt);
            }
        });

        bgSexoCadastroCliente.add(rboFemininoCadastroCliente);
        rboFemininoCadastroCliente.setText("Feminino");
        rboFemininoCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboFemininoCadastroClienteActionPerformed(evt);
            }
        });

        bgSexoCadastroCliente.add(rboMasculinoCadastroCliente);
        rboMasculinoCadastroCliente.setText("Masculino");
        rboMasculinoCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboMasculinoCadastroClienteActionPerformed(evt);
            }
        });

        bgEstadoCivilCadastroCliente.add(rboSolteiroCadastroCliente);
        rboSolteiroCadastroCliente.setText("Solteiro");

        bgEstadoCivilCadastroCliente.add(rboCasadoCadastroCliente);
        rboCasadoCadastroCliente.setText("Casado");
        rboCasadoCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboCasadoCadastroClienteActionPerformed(evt);
            }
        });

        bgEstadoCivilCadastroCliente.add(rboViuvoCadastroCliente);
        rboViuvoCadastroCliente.setText("Viuvo");

        btnConfirmarCadastroCliente.setText("Confirmar");
        btnConfirmarCadastroCliente.setMaximumSize(new java.awt.Dimension(136, 55));
        btnConfirmarCadastroCliente.setMinimumSize(new java.awt.Dimension(136, 55));
        btnConfirmarCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCadastroClienteActionPerformed(evt);
            }
        });

        btnAlterarclienteCadastroCliente.setText("Alterar");
        btnAlterarclienteCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarclienteCadastroClienteActionPerformed(evt);
            }
        });

        btnSairCadastroCliente.setText("Fechar");
        btnSairCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCadastroClienteActionPerformed(evt);
            }
        });

        lblComplementoClienteCadastroCliente.setText("Complemento:");

        txtComplementoClienteCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoClienteCadastroClienteActionPerformed(evt);
            }
        });
        txtComplementoClienteCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComplementoClienteCadastroClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComplementoClienteCadastroClienteKeyTyped(evt);
            }
        });

        lblBairroClienteCadastroCliente.setText("Bairro:");

        txtBairroClienteCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroClienteCadastroClienteActionPerformed(evt);
            }
        });
        txtBairroClienteCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBairroClienteCadastroClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBairroClienteCadastroClienteKeyTyped(evt);
            }
        });

        lblCEPClienteCadastroCliente.setText("CEP:");

        try {
            txtCEPClienteCadastroCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEPClienteCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEPClienteCadastroClienteActionPerformed(evt);
            }
        });
        txtCEPClienteCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCEPClienteCadastroClienteKeyTyped(evt);
            }
        });

        btnExcluirClienteCadastroCliente.setText("Excluir");
        btnExcluirClienteCadastroCliente.setPreferredSize(new java.awt.Dimension(133, 71));
        btnExcluirClienteCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteCadastroClienteActionPerformed(evt);
            }
        });

        tblClienteCadastroCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Data nasc", "CEP", "Endereço", "numero", "Complemento", "Bairro", "Cel.", "Sexo", "Estado civil", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClienteCadastroCliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblClienteCadastroCliente);
        if (tblClienteCadastroCliente.getColumnModel().getColumnCount() > 0) {
            tblClienteCadastroCliente.getColumnModel().getColumn(1).setMinWidth(100);
            tblClienteCadastroCliente.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        btnPesquisarClienteCadastroCliente.setText("Pesquisar");
        btnPesquisarClienteCadastroCliente.setMaximumSize(new java.awt.Dimension(72, 22));
        btnPesquisarClienteCadastroCliente.setMinimumSize(new java.awt.Dimension(72, 22));
        btnPesquisarClienteCadastroCliente.setPreferredSize(new java.awt.Dimension(72, 22));
        btnPesquisarClienteCadastroCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnPesquisarClienteCadastroClienteFocusLost(evt);
            }
        });
        btnPesquisarClienteCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteCadastroClienteActionPerformed(evt);
            }
        });

        btnLimparClienteCadastroCliente.setText("Limpar");
        btnLimparClienteCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparClienteCadastroClienteActionPerformed(evt);
            }
        });

        dcDataNasc.setDateFormatString("dd/MM/YYYY");

        try {
            txtCPFPesquisar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFPesquisarActionPerformed(evt);
            }
        });
        txtCPFPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPFPesquisarKeyTyped(evt);
            }
        });

        ID.setText("ID:");

        btnVerTodosCliente.setText("VerTodos");
        btnVerTodosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTelaCadastroClienteLayout = new javax.swing.GroupLayout(pnlTelaCadastroCliente);
        pnlTelaCadastroCliente.setLayout(pnlTelaCadastroClienteLayout);
        pnlTelaCadastroClienteLayout.setHorizontalGroup(
            pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCEPClienteCadastroCliente)
                            .addComponent(lblEnderecoCadastroCliente)
                            .addComponent(lblComplementoClienteCadastroCliente)
                            .addComponent(lblCPFCadastroCliente)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelCadastroCliente)
                            .addComponent(lblEmailCadastroCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                                    .addComponent(txtCelCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(lblSexoCadastroCliente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rboFemininoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(rboMasculinoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                                .addComponent(txtEnderecoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumeroEnderecoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroEnderecoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                                .addComponent(txtComplementoClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBairroClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairroClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCEPClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                                .addComponent(txtCPFCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDatadeNascimentoCadastroCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dcDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                                .addComponent(lblidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNomeCadastroCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmailCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                                .addComponent(btnConfirmarCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarclienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTelaCadastroClienteLayout.createSequentialGroup()
                                .addComponent(txtCPFPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVerTodosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPesquisarClienteCadastroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimparClienteCadastroCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSairCadastroCliente)))
                .addContainerGap(174, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaCadastroClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEstadoCivilCadastroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rboSolteiroCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rboCasadoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rboViuvoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(297, 297, 297))
            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnlTelaCadastroClienteLayout.setVerticalGroup(
            pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNomeCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbNomeCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCPFCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPFCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatadeNascimentoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dcDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCEPClienteCadastroCliente)
                    .addComponent(txtCEPClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnderecoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnderecoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroEnderecoCadastroCliente)
                    .addComponent(txtNumeroEnderecoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplementoClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplementoClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairroClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairroClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                        .addComponent(rboSolteiroCadastroCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rboCasadoCadastroCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rboViuvoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTelaCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexoCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rboFemininoCadastroCliente)
                            .addComponent(lblEstadoCivilCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rboMasculinoCadastroCliente)
                        .addGap(39, 39, 39)
                        .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailCadastroCliente)
                            .addComponent(txtEmailCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarclienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSairCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlTelaCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPFPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarClienteCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerTodosCliente)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCadastroProduto.addTab("Cadastro de Cliente", pnlTelaCadastroCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCadastroProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCadastroProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeProdutoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdutoCadastroProdutoActionPerformed

        produto.setNomeProdutoCadastroProduto(txtNomeProdutoCadastroProduto.getText());
    }//GEN-LAST:event_txtNomeProdutoCadastroProdutoActionPerformed

    private void rboCasadoCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboCasadoCadastroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboCasadoCadastroClienteActionPerformed


    private void btnConfirmarCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCadastroProdutoActionPerformed

        if (objProdutoAlterar == null) {
            //Criando um objeto da tabela        
            DefaultTableModel dtmProdutos = (DefaultTableModel) tblProdutoCadastroProduto.getModel();

            //Criando um vetor de obetos para tabela
            /*  Object[] dados = {txtIDProdutoCadastroProduto.getText(), txtQntdProdutoCadastroProduto.getText(),
            txtNomeProdutoCadastroProduto.getText(), txtValorProdutoCadastroProduto.getText()};*/
            //Se existir algum campo vazio, os dados não serão inclusos na tabela
            if (/*txtIDProdutoCadastroProduto.getText().isEmpty() ||*/txtQntdProdutoCadastroProduto.getText().isEmpty()
                    || txtNomeProdutoCadastroProduto.getText().isEmpty() || txtValorProdutoCadastroProduto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Obrigatório preencher todos os campos!");


                //Armazenando o campo ID em uma String
                /* String novoId = txtIDProdutoCadastroProduto.getText();
            boolean idDuplicado = false;
            //Percorrendo a tabela para verificar se ja existe o ID digitado
            for (int i = 0; i < dtmProdutos.getRowCount(); i++) {
                // Assumindo que o ID está na segunda coluna da tabela
                String idExistente = dtmProdutos.getValueAt(i, 0).toString();
                // Se o CPF digitado for igual ao CPF procurado na tabela...
                //A mensagem de existente sera exibida na tela
                if (novoId.equals(idExistente)) {
                    idDuplicado = true;
                    break;
                }
            }
            if (idDuplicado = true) {
                JOptionPane.showMessageDialog(null, "ID ja cadastrado!");
            }
            //Caso nenhuma das validações acima sejam verdadeiras, os dados serão adicionadoa normalmente a tabela...
       //Adicionndo as linha à tabela*/ } else {

                /* FALTA VALIDAR */
                String nomeProduto = txtNomeProdutoCadastroProduto.getText();
                int quantidade = Integer.parseInt(txtQntdProdutoCadastroProduto.getText());
                double valorProduto = Double.parseDouble(txtValorProdutoCadastroProduto.getText());
                ModeloCadastroProduto modeloSalvarCadastroNormal = new ModeloCadastroProduto(quantidade, nomeProduto, valorProduto);
                boolean retorno = ProdutoDAO.salvar(modeloSalvarCadastroNormal);
                if (retorno) {
                    JOptionPane.showMessageDialog(rootPane, "sucesso no cadastro!");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Falha no cadastro!!");
                }
                //dtmProdutos.addRow(dados);

            }

            /**
             * se caso o obj vim do botao de alteraçao
             */
        }

    }//GEN-LAST:event_btnConfirmarCadastroProdutoActionPerformed

    private void txtNomeProdutoCadastroProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdutoCadastroProdutoKeyTyped
        //Impedindo de ter apenas numeros no nome do produto
        String texto = txtNomeProdutoCadastroProduto.getText();
        char c = evt.getKeyChar();

        // Verifica se o caractere digitado é um número
        if (Character.isDigit(c)) {
            // Se for um número, verifica se o texto já contém apenas números
            String novoTexto = texto + c;
            if (Pattern.matches("\\d+", novoTexto)) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "O nome do produto não pode conter apenas números!");
            }
        }

        // Verifica a quantidade de caracteres no nome do produto
        if (texto.length() >= 15) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 15 caracteres no campo produto!");
        }

    }//GEN-LAST:event_txtNomeProdutoCadastroProdutoKeyTyped

    private void txtNomeProdutoCadastroProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdutoCadastroProdutoKeyReleased
        //Deixando as letras em caixa alta(maiusculas)
        txtNomeProdutoCadastroProduto.setText(txtNomeProdutoCadastroProduto.getText().toUpperCase());
    }//GEN-LAST:event_txtNomeProdutoCadastroProdutoKeyReleased

    private void txtQntdProdutoCadastroProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQntdProdutoCadastroProdutoKeyTyped
        //apenas numeros no campo quantidade
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digite apenas numeros no campo quantidade!");

        }
        //Quantidade de caracteres no campo QNTD
        if (txtQntdProdutoCadastroProduto.getText().length() > 9) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 10 caracteres no campo quantidade!");
        }
    }//GEN-LAST:event_txtQntdProdutoCadastroProdutoKeyTyped

    private void txtQntdProdutoCadastroProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQntdProdutoCadastroProdutoKeyReleased
        //txtQntdProdutoCadastroProduto.setText(txtQntdProdutoCadastroProduto.getText().toUpperCase());
    }//GEN-LAST:event_txtQntdProdutoCadastroProdutoKeyReleased

    private void txtComplementoClienteCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoClienteCadastroClienteActionPerformed
        cliente.setComplementoClienteCadastroCliente(txtComplementoClienteCadastroCliente.getText());
    }//GEN-LAST:event_txtComplementoClienteCadastroClienteActionPerformed

    private void btnExcluirProdutoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoCadastroProdutoActionPerformed
        // quando nenhuma linha estiver selecionada automaticamrnto o valor -1 é retornado
        // assim que a linha é selecionada esse valor muda
        // portanto o codigo ocorrera quando o valor for diferente de -1
        if (tblProdutoCadastroProduto.getSelectedRow() != -1) {

            //Criando o objeto tabela      
            DefaultTableModel dtmProdutos = (DefaultTableModel) tblProdutoCadastroProduto.getModel();
            int linhaselecionadaExcluir = tblProdutoCadastroProduto.getSelectedRow();

            DefaultTableModel modeloExcluir = (DefaultTableModel) tblProdutoCadastroProduto.getModel();

            int id = Integer.parseInt(tblProdutoCadastroProduto.getValueAt(linhaselecionadaExcluir, 0).toString());
            boolean retorno = ProdutoDAO.excluir(id);
            if (retorno) {
                modeloExcluir.removeRow(linhaselecionadaExcluir);
                JOptionPane.showMessageDialog(rootPane, "Excluido!!");
            } else {

                JOptionPane.showMessageDialog(rootPane, "falha ao Excluir!");
            }

        } // Erro mostrado quando clica no botão exluir sem selecionar a linha
        else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        }

        //System.out.println("Linha selecionada " + tblProdutoCadastroProduto.getSelectedRow());
    }//GEN-LAST:event_btnExcluirProdutoCadastroProdutoActionPerformed

    private void tblProdutoCadastroProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoCadastroProdutoMouseClicked
        /*if(tblProdutoCadastroProduto.getSelectedRow() != -1){
            txtIDProdutoCadastroProduto.setText(tblProdutoCadastroProduto.getValueAt(tblProdutoCadastroProduto.getSelectedRow(), 0).toString());
            txtQntdProdutoCadastroProduto.setText(tblProdutoCadastroProduto.getValueAt(tblProdutoCadastroProduto.getSelectedRow(), 1).toString());
            txtNomeProdutoCadastroProduto.setText(tblProdutoCadastroProduto.getValueAt(tblProdutoCadastroProduto.getSelectedRow(), 2).toString());            
            txtValorProdutoCadastroProduto.setText(tblProdutoCadastroProduto.getValueAt(tblProdutoCadastroProduto.getSelectedRow(), 3).toString());
        }*/
    }//GEN-LAST:event_tblProdutoCadastroProdutoMouseClicked

    private void btnAlterarProdutoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarProdutoCadastroProdutoActionPerformed
        // quando nenhuma linha estiver selecionada automaticamrnto o valor -1 é retornado
        // assim que a linha é selecionada esse valor muda
        // portanto o codigo ocorrera quando o valor for diferente de -1
        /* if (tblProdutoCadastroProduto.getSelectedRow() != -1) {

            // utilizndo o setValueAt para alterar o valor dos campos
          // tblProdutoCadastroProduto.setValueAt(txtIDProdutoCadastroProduto.getText(), tblProdutoCadastroProduto.getSelectedRow(), 0);
            tblProdutoCadastroProduto.setValueAt(txtQntdProdutoCadastroProduto.getText(), tblProdutoCadastroProduto.getSelectedRow(), 1);
            tblProdutoCadastroProduto.setValueAt(txtNomeProdutoCadastroProduto.getText(), tblProdutoCadastroProduto.getSelectedRow(), 2);
            tblProdutoCadastroProduto.setValueAt(txtValorProdutoCadastroProduto.getText(), tblProdutoCadastroProduto.getSelectedRow(), 3);
        } //Caso nenhuma linha esteja selecionada, aparecera esta caixa de texto        
        else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para alterar!");
        }*/
        if (txtQntdProdutoCadastroProduto.getText().isEmpty()
                || txtNomeProdutoCadastroProduto.getText().isEmpty() || txtValorProdutoCadastroProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Obrigatório preencher todos os campos!");
        } else {

            int id = Integer.parseInt(lblID.getText());
            int quantidade = Integer.parseInt(txtQntdProdutoCadastroProduto.getText());
            String produtoAlterar = (txtNomeProdutoCadastroProduto.getText());
            double valor = (Double.parseDouble(txtValorProdutoCadastroProduto.getText()));
            //Passo os valores das variáveis para um objeto
            //NotaFiscal obj = new NotaFiscal(id, numero, valor);

            ModeloCadastroProduto objProdutoParaAlterar = new ModeloCadastroProduto(id, quantidade, produtoAlterar, valor);

            boolean retorno = ProdutoDAO.alterar(objProdutoParaAlterar);
            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Sucesso na alteração!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha na alteração!");
            }
        }

        /*CadastroClienteProduto telaAlterar = new CadastroClienteProduto(objProdutoParaAlterar);
            telaAlterar.setVisible(true);*/
        // telaAlterar.setVisible(true);

    }//GEN-LAST:event_btnAlterarProdutoCadastroProdutoActionPerformed

    private void btnSairCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCadastroProdutoActionPerformed
        Menu novoMenu = new Menu();
        novoMenu.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnSairCadastroProdutoActionPerformed

    private void txtNomeCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeCadastroClienteKeyTyped
        //Impedindo de ter apenas numeros no nome do produto
        String texto = txtNomeCadastroCliente.getText();
        char c = evt.getKeyChar();

        // Verifica se o caractere digitado é um número
        if (Character.isDigit(c)) {
            // Se for um número, verifica se o texto já contém apenas números
            String novoTexto = texto + c;
            if (Pattern.matches("\\d+", novoTexto)) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "O nome do cliente não pode conter apenas números!");
            }
        }

        // Verifica a quantidade de caracteres no nome do produto
        if (texto.length() >= 50) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 50 caracteres no campo nome!");
        }
    }//GEN-LAST:event_txtNomeCadastroClienteKeyTyped

    private void txtNomeCadastroClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeCadastroClienteKeyReleased
        //Deixando as letras em caixa alta(maiusculas)

        txtNomeCadastroCliente.setText(txtNomeCadastroCliente.getText().toUpperCase());
    }//GEN-LAST:event_txtNomeCadastroClienteKeyReleased

    private void txtCPFCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFCadastroClienteKeyTyped
        //Apenas numeros no campo cpf
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digite apenas números no campo CPF!");

        }

        if (txtCPFCadastroCliente.getText().length() == 11) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "O campo CPF deve conter 11 caracteres númericos!");
        }
    }//GEN-LAST:event_txtCPFCadastroClienteKeyTyped

    private void txtCEPClienteCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCEPClienteCadastroClienteKeyTyped
        //Apenas numeros no campo cep

        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digite apenas números no campo CEP!");
        }

        if (txtCEPClienteCadastroCliente.getText().length() == 8) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "O campo CEP deve conter no 8 caracteres númericos!");

        }

    }//GEN-LAST:event_txtCEPClienteCadastroClienteKeyTyped

    private void txtEnderecoCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoCadastroClienteKeyTyped
        //Impedindo de ter apenas numeros no nome do produto
        String texto = txtEnderecoCadastroCliente.getText();
        char c = evt.getKeyChar();

        // Verifica se o caractere digitado é um número
        if (Character.isDigit(c)) {
            // Se for um número, verifica se o texto já contém apenas números
            String novoTexto = texto + c;
            if (Pattern.matches("\\d+", novoTexto)) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "O endereço não pode conter apenas números!");
            }
        }

        // Verifica a quantidade de caracteres no nome do produto
        if (texto.length() >= 49) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 50 caracteres no campo endereço!");
        }
    }//GEN-LAST:event_txtEnderecoCadastroClienteKeyTyped

    private void txtEnderecoCadastroClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoCadastroClienteKeyReleased
        //Deixando as letras em caixa alta(maiusculas)

        txtEnderecoCadastroCliente.setText(txtEnderecoCadastroCliente.getText().toUpperCase());
    }//GEN-LAST:event_txtEnderecoCadastroClienteKeyReleased

    private void txtNumeroEnderecoCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroEnderecoCadastroClienteKeyTyped
        //apenas numeros no campo Nº

        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digite apenas número no campo Nº!");
        }

        if (txtNumeroEnderecoCadastroCliente.getText().length() > 4) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 5 caracteres no campo Nº!");
        }
    }//GEN-LAST:event_txtNumeroEnderecoCadastroClienteKeyTyped

    private void txtComplementoClienteCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComplementoClienteCadastroClienteKeyTyped
        //Impedindo de ter apenas numeros no nome do produto
        String texto = txtComplementoClienteCadastroCliente.getText();
        char c = evt.getKeyChar();

        // Verifica se o caractere digitado é um número
        if (Character.isDigit(c)) {
            // Se for um número, verifica se o texto já contém apenas números
            String novoTexto = texto + c;
            if (Pattern.matches("\\d+", novoTexto)) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "O complemento não pode conter apenas números!");
            }
        }

        // Verifica a quantidade de caracteres no nome do produto
        if (texto.length() >= 15) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 15 caracteres no campo complemento!");
        }
    }//GEN-LAST:event_txtComplementoClienteCadastroClienteKeyTyped

    private void txtComplementoClienteCadastroClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComplementoClienteCadastroClienteKeyReleased
        //Deixando as letras em caixa alta(maiusculas)

        txtComplementoClienteCadastroCliente.setText(txtComplementoClienteCadastroCliente.getText().toUpperCase());
    }//GEN-LAST:event_txtComplementoClienteCadastroClienteKeyReleased

    private void txtBairroClienteCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroClienteCadastroClienteKeyTyped
        //Impedindo de ter apenas numeros no nome do produto
        String texto = txtBairroClienteCadastroCliente.getText();
        char c = evt.getKeyChar();

        // Verifica se o caractere digitado é um número
        if (Character.isDigit(c)) {
            // Se for um número, verifica se o texto já contém apenas números
            String novoTexto = texto + c;
            if (Pattern.matches("\\d+", novoTexto)) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "O bairro não pode conter apenas números!");
            }
        }

        // Verifica a quantidade de caracteres no nome do produto
        if (texto.length() >= 15) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 15 caracteres no campo bairro!");
        }
    }//GEN-LAST:event_txtBairroClienteCadastroClienteKeyTyped

    private void txtBairroClienteCadastroClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroClienteCadastroClienteKeyReleased
        //Deixando as letras em caixa alta(maiusculas)

        txtBairroClienteCadastroCliente.setText(txtBairroClienteCadastroCliente.getText().toUpperCase());
    }//GEN-LAST:event_txtBairroClienteCadastroClienteKeyReleased

    private void txtCelCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelCadastroClienteKeyTyped
        // apenas numeros no campo Cel

        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digite apenas numeros no campo Cel!");
        }

        if (txtCelCadastroCliente.getText().length() == 11) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "O campo cel deve conter 11 caracteres númericos!");
        }
    }//GEN-LAST:event_txtCelCadastroClienteKeyTyped
    /**
     *
     * @param evt
     */
    private void btnConfirmarCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCadastroClienteActionPerformed

        String nome = txtNomeCadastroCliente.getText();
        String cpf = (txtCPFCadastroCliente.getText());
        Date dataNascimento = (dcDataNasc.getDate());
        String cep = (txtCEPClienteCadastroCliente.getText());
        String endereco = txtEnderecoCadastroCliente.getText();
        int numero = 0;// iniciando com 0 para nao tentar converter uma String vazia pra um numero inteiro, oq iria da um erro no cod
        // se caso o numero não for vazio esse if ira amazenar oque foi digitado na variavel numero 
        if (!txtNumeroEnderecoCadastroCliente.getText().isEmpty()) {
            numero = Integer.parseInt(txtNumeroEnderecoCadastroCliente.getText());
        }
        String complemento = txtComplementoClienteCadastroCliente.getText();
        String bairro = txtBairroClienteCadastroCliente.getText();
        String celular = (txtCelCadastroCliente.getText());
        String email = txtEmailCadastroCliente.getText();
        String genero = "";
        String estadoCivil = "";
        //Se botao feminino for selecionado então sera retornado na string genero o valor feminino
        if (rboFemininoCadastroCliente.isSelected()) {
            genero = rboMasculinoCadastroCliente.getText();

        } else if (rboMasculinoCadastroCliente.isSelected()) {
            genero = rboMasculinoCadastroCliente.getText();
        }
        //Se botao solteiro selecionado então sera retornado na string genero o valor solteiro
        if (rboSolteiroCadastroCliente.isSelected()) {
            estadoCivil = rboSolteiroCadastroCliente.getText();
            //Se botao casado selecionado então sera retornado na string genero o valor casado    
        } else if (rboCasadoCadastroCliente.isSelected()) {
            estadoCivil = rboCasadoCadastroCliente.getText();
            //Se botao viuvo selecionado então sera retornado na string genero o valor viuvo    
        } else if (rboViuvoCadastroCliente.isSelected()) {
            estadoCivil = rboViuvoCadastroCliente.getText();
        }
        //criando objeto tabela
        DefaultTableModel dtmClientes = (DefaultTableModel) tblClienteCadastroCliente.getModel();
        //Se existir algum campo vazio, os dados não serão inclusos na tabela
        String novoCPF = txtCPFCadastroCliente.getText();
        boolean cpfDuplicado = false;
        //Percorrendo a tabela para verificar se ja existe o CPF digitado
        for (int i = 0; i < dtmClientes.getRowCount(); i++) {
            // Assumindo que o CPF está na segunda coluna da tabela
            String cpfExistente = dtmClientes.getValueAt(i, 1).toString();
            // Se o CPF digitado for igual ao CPF procurado na tabela...
            //A mensagem de existente sera exibida na tela
            if (novoCPF.equals(cpfExistente)) {
                cpfDuplicado = true;
                break;
            }
        }
        if (cpfDuplicado) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
        }

        /*Caso nenhuma das validações acima executem, os dados serão adicionadoa normalmente a tabela...*/
        if (txtNomeCadastroCliente.getText().isEmpty() || txtCPFCadastroCliente.getValue() == null
                || dcDataNasc.getDate() == null || txtCEPClienteCadastroCliente.getValue() == null
                || txtEnderecoCadastroCliente.getText().isEmpty() || txtNumeroEnderecoCadastroCliente.getText().isEmpty()
                || txtComplementoClienteCadastroCliente.getText().isEmpty() || txtBairroClienteCadastroCliente.getText().isEmpty()
                || txtCelCadastroCliente.getValue() == null || genero.isEmpty() || estadoCivil.isEmpty() || txtEmailCadastroCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Obrigatório preencher todos os campos!");

            //Armazenando o campo cpf em uma String
        } else {
            ModeloCadastroCliente clienteParametro = new ModeloCadastroCliente(nome, cpf, dataNascimento, cep, endereco, numero, complemento, bairro, celular, email, genero, estadoCivil);
            //adicionando os dados à tabela
            // dtmClientes.addRow(clienteParametro);
            boolean retorno = ClienteDAO.salvar(clienteParametro);
            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "sucesso no cadastro!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha no cadastro!!");
            }

        }


    }//GEN-LAST:event_btnConfirmarCadastroClienteActionPerformed
    /**
     *
     * @param evt
     */
    private void btnAlterarclienteCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarclienteCadastroClienteActionPerformed
        if (tblClienteCadastroCliente.getSelectedRow() >= 0) {
        }
        if (txtNomeCadastroCliente.getText().isEmpty()
                || dcDataNasc.getDate() == null
                || txtEnderecoCadastroCliente.getText().isEmpty() || txtNumeroEnderecoCadastroCliente.getText().isEmpty()
                || txtComplementoClienteCadastroCliente.getText().isEmpty() || txtBairroClienteCadastroCliente.getText().isEmpty()
                || txtEmailCadastroCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Obrigatório preencher todos os campos!");
            //Armazenando o campo cpf em uma String
        } else {
            String genero = "";
            String estadoCivil = "";
            //Se botao feminino for selecionado então sera retornado na string genero o valor feminino
            if (rboFemininoCadastroCliente.isSelected()) {
                genero = rboFemininoCadastroCliente.getText();
                //Se botao masculino for selecionado então sera retornado na string genero o valor masculino
            } else if (rboMasculinoCadastroCliente.isSelected()) {
                genero = rboMasculinoCadastroCliente.getText();
            }
            //Se botao solteiro selecionado então sera retornado na string genero o valor solteiro
            if (rboSolteiroCadastroCliente.isSelected()) {
                estadoCivil = rboSolteiroCadastroCliente.getText();
                //Se botao casado selecionado então sera retornado na string genero o valor casado    
            } else if (rboCasadoCadastroCliente.isSelected()) {
                estadoCivil = rboCasadoCadastroCliente.getText();
                //Se botao viuvo selecionado então sera retornado na string genero o valor viuvo    
            } else if (rboViuvoCadastroCliente.isSelected()) {
                estadoCivil = rboViuvoCadastroCliente.getText();
            }
            String nome = txtNomeCadastroCliente.getText();
            String cpf = (txtCPFCadastroCliente.getText());
            Date dataNascimento = (dcDataNasc.getDate());
            String cep = (txtCEPClienteCadastroCliente.getText());
            String endereco = txtEnderecoCadastroCliente.getText();
            int numero = Integer.parseInt(txtNumeroEnderecoCadastroCliente.getText());
            String complemento = txtComplementoClienteCadastroCliente.getText();
            String bairro = txtBairroClienteCadastroCliente.getText();
            String celular = (txtCelCadastroCliente.getText());
            String email = txtEmailCadastroCliente.getText();
            int idCliente = Integer.parseInt(lblidCliente.getText());

            ModeloCadastroCliente modeloParementroAlterar = new ModeloCadastroCliente(idCliente, nome, cpf, dataNascimento, cep, endereco, numero, complemento, bairro, celular, email, genero, estadoCivil);
            boolean retorno = ClienteDAO.alterar(modeloParementroAlterar);
            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Sucesso na alteração!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha na alteração!");
            }
        }

    }//GEN-LAST:event_btnAlterarclienteCadastroClienteActionPerformed

    private void btnExcluirClienteCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteCadastroClienteActionPerformed
        // quando nenhuma linha estiver selecionada automaticamrnto o valor -1 é retornado
        // assim que a linha é selecionada esse valor muda
        // portanto o codigo ocorrera quando o valor for diferente de -1
        /*  if (tblClienteCadastroCliente.getSelectedRow() != -1) {

            //criando objeto tabela
            DefaultTableModel dtmClientes = (DefaultTableModel) tblClienteCadastroCliente.getModel();

            //Removendo linha da tabela
            dtmClientes.removeRow(tblClienteCadastroCliente.getSelectedRow());

            // caso nenhuma linha seja selecionada
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        }*/
        if (tblClienteCadastroCliente.getSelectedRow() != -1) {

            int linhaSelecionada = tblClienteCadastroCliente.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) tblClienteCadastroCliente.getModel();
            // excluir do banco 
            String linhaSelecionadaparaExcluir = (tblClienteCadastroCliente.getValueAt(linhaSelecionada, 1).toString());
            boolean retorno = ClienteDAO.excluir(linhaSelecionadaparaExcluir);
            if (retorno) {
                modelo.removeRow(linhaSelecionada);
                JOptionPane.showMessageDialog(rootPane, "sucesso");

            } else {
                JOptionPane.showMessageDialog(rootPane, "falha!");
            }

// remove da tabela 
        }


    }//GEN-LAST:event_btnExcluirClienteCadastroClienteActionPerformed

    private void btnSairCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCadastroClienteActionPerformed
        Menu novoMenu = new Menu();
        novoMenu.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnSairCadastroClienteActionPerformed

    private void btnPesquisarClienteCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteCadastroClienteActionPerformed

        if (txtCPFPesquisar.getValue() == null) {
            JOptionPane.showMessageDialog(null, "DIGITE O CPF !!");

        } else {

            String pesquisarCpf = txtCPFPesquisar.getText();
            ModeloCadastroCliente objFiltroCPF = new ModeloCadastroCliente();
            objFiltroCPF.setCpfCadastroCliente(pesquisarCpf);
            ModeloCadastroCliente objCliente = ClienteDAO.filtro(objFiltroCPF);
            //convertendo o modelo de tabela da tabela "tblConsulta" em um objeto "DefaultTableModel".

            // atualiza a tabela "tblConsulta" com os dados da lista de objetos "lojainformatica" obtida do banco de dados.
            if (objCliente.getIdCliente() > 0) {

                DefaultTableModel modelo = (DefaultTableModel) tblClienteCadastroCliente.getModel();

                modelo.setRowCount(0);
                modelo.addRow(new String[]{
                    String.valueOf(objCliente.getNomeCadastroCliente()),
                    (objCliente.getCpfCadastroCliente()),
                    String.valueOf(objCliente.getDataNascimentoCadastroCliente()),
                    String.valueOf(objCliente.getCepClienteCadastroCliente()),
                    String.valueOf(objCliente.getEnderecoCadastroCliente()),
                    String.valueOf(objCliente.getNumeroEnderecoCadastroCliente()),
                    String.valueOf(objCliente.getComplementoClienteCadastroCliente()),
                    String.valueOf(objCliente.getBairroClienteCadastroCliente()),
                    String.valueOf(objCliente.getCelCadastroCliente()),
                    String.valueOf(objCliente.getSexo()),
                    String.valueOf(objCliente.getEstadoCivil()),
                    String.valueOf(objCliente.getEmailCadastroCliente()),});
                txtNomeCadastroCliente.setText(objCliente.getNomeCadastroCliente());
                txtCPFCadastroCliente.setText(objCliente.getCpfCadastroCliente());
                dcDataNasc.setDate(objCliente.getDataNascimentoCadastroCliente());
                txtEnderecoCadastroCliente.setText(objCliente.getEnderecoCadastroCliente());
                lblidCliente.setText(String.valueOf(objCliente.getIdCliente()));
                txtNumeroEnderecoCadastroCliente.setText(String.valueOf(objCliente.getNumeroEnderecoCadastroCliente()));
                txtComplementoClienteCadastroCliente.setText(objCliente.getComplementoClienteCadastroCliente());
                txtBairroClienteCadastroCliente.setText(objCliente.getBairroClienteCadastroCliente());
                txtCelCadastroCliente.setText(objCliente.getCelCadastroCliente());
                txtEmailCadastroCliente.setText(objCliente.getEmailCadastroCliente());
                txtCEPClienteCadastroCliente.setText(objCliente.getCepClienteCadastroCliente());
                /**
                 * criando uma String para ticar a opçao que vai vim do banco de
                 * dados, se casso for true o radio bot ira ser ticado e nao, o
                 * outro será
                 */
                String selecionaSexoRBOMasculino = "Masculino";
                String selecionaSexoRBOFeminino = "Feminino";

                if (objCliente.getSexo().equals(selecionaSexoRBOMasculino)) {
                    rboMasculinoCadastroCliente.setSelected(true);
                } else if (objCliente.getSexo().equals(selecionaSexoRBOFeminino)) {
                    rboFemininoCadastroCliente.setSelected(true);
                }
                String selecionaEstadoRBOSolteiro = "Solteiro";
                String selecionaEstadoRBOcasado = "Casado";
                String selecionaEstadoRBOViuvo = "Viuvo";
                if (objCliente.getEstadoCivil().equals(selecionaEstadoRBOcasado)) {
                    rboCasadoCadastroCliente.setSelected(true);
                } else if (objCliente.getEstadoCivil().equals(selecionaEstadoRBOSolteiro)) {
                    rboSolteiroCadastroCliente.setSelected(true);
                } else if (objCliente.getEstadoCivil().equals(selecionaEstadoRBOViuvo)) {
                    rboViuvoCadastroCliente.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "NAO POSSUI ESSE CPF CADASTRADO !!");
            }
        }
    }//GEN-LAST:event_btnPesquisarClienteCadastroClienteActionPerformed

    private void btnLimparProdutoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparProdutoCadastroProdutoActionPerformed
        // ao clicar no botão limpar o texto dos campos sera alterado para: ""
        txtQntdProdutoCadastroProduto.setText("");
        txtNomeProdutoCadastroProduto.setText("");
        txtValorProdutoCadastroProduto.setText("");
    }//GEN-LAST:event_btnLimparProdutoCadastroProdutoActionPerformed

    private void btnLimparClienteCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparClienteCadastroClienteActionPerformed
        // ao clicar no botão limpar o texto dos campos sera alterado para: ""    
        txtNomeCadastroCliente.setText("");
        bgEstadoCivilCadastroCliente.clearSelection();
        bgSexoCadastroCliente.clearSelection();
        lblidCliente.setText("");
        txtCPFPesquisar.setText("");
        txtCPFCadastroCliente.setText("");
        dcDataNasc.cleanup();
        txtCEPClienteCadastroCliente.setText("");
        txtEnderecoCadastroCliente.setText("");
        txtNumeroEnderecoCadastroCliente.setText("");
        txtComplementoClienteCadastroCliente.setText("");
        txtBairroClienteCadastroCliente.setText("");
        txtCelCadastroCliente.setText("");
        txtEmailCadastroCliente.setText("");

    }//GEN-LAST:event_btnLimparClienteCadastroClienteActionPerformed

    private void btnPesquisarProdutoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoCadastroProdutoActionPerformed

        if (txtpesquisa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, " Digite um PRODUTO!!");

        } else {

            ModeloCadastroProduto objParapesquisar = new ModeloCadastroProduto();
            // String produtoSelecionado = cmbPesquisar.getSelectedItem().toString();
            String produtoSelecionado = txtpesquisa.getText();

            objParapesquisar.setNomeProdutoCadastroProduto(produtoSelecionado);

            ArrayList<ModeloCadastroProduto> lista = ProdutoDAO.filtro(objParapesquisar);
            if (lista.size() == 0) {
                JOptionPane.showMessageDialog(rootPane, " Não possui esse produto no banco de dados!");
            }
            //convertendo o modelo de tabela da tabela "tblConsulta" em um objeto "DefaultTableModel".
            DefaultTableModel modelo = (DefaultTableModel) tblProdutoCadastroProduto.getModel();
            // atualiza a tabela "tblConsulta" com os dados da lista de objetos "lojainformatica" obtida do banco de dados.

            modelo.setRowCount(0);
            for (ModeloCadastroProduto item : lista) {

                int id = item.getIdProdutoCadastroProduto();
                int qtd = item.getQntdProdutoCadastroProduto();
                String nome = item.getNomeProdutoCadastroProduto();
                double valor = item.getValorProdutoCadastroProduto();

                modelo.addRow(new Object[]{id, qtd, nome, valor});
                lblID.setText(String.valueOf(id));
                txtQntdProdutoCadastroProduto.setText(String.valueOf(qtd));
                txtNomeProdutoCadastroProduto.setText(nome);
                txtValorProdutoCadastroProduto.setText(String.valueOf(valor));
            }
        }
    }//GEN-LAST:event_btnPesquisarProdutoCadastroProdutoActionPerformed

    private void txtValorProdutoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorProdutoCadastroProdutoActionPerformed

    }//GEN-LAST:event_txtValorProdutoCadastroProdutoActionPerformed

    private void txtValorProdutoCadastroProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorProdutoCadastroProdutoKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digite apenas números no campo Valor!");
        }
        if (txtValorProdutoCadastroProduto.getText().length() > 9) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo de 10 caracteres no campo Valor!");
        }
    }//GEN-LAST:event_txtValorProdutoCadastroProdutoKeyTyped

    private void txtNomeCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCadastroClienteActionPerformed

    }//GEN-LAST:event_txtNomeCadastroClienteActionPerformed

    private void txtCPFCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFCadastroClienteActionPerformed

    }//GEN-LAST:event_txtCPFCadastroClienteActionPerformed

    private void txtEnderecoCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoCadastroClienteActionPerformed
    }//GEN-LAST:event_txtEnderecoCadastroClienteActionPerformed

    private void txtEmailCadastroClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailCadastroClienteKeyTyped
        if (txtEmailCadastroCliente.getText().length() > 59) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Máximo de 60 caracteres no campo email!");
        }
    }//GEN-LAST:event_txtEmailCadastroClienteKeyTyped

    private void txtEmailCadastroClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailCadastroClienteKeyReleased
    }//GEN-LAST:event_txtEmailCadastroClienteKeyReleased

    private void txtQntdProdutoCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQntdProdutoCadastroProdutoActionPerformed
    }//GEN-LAST:event_txtQntdProdutoCadastroProdutoActionPerformed

    private void txtCEPClienteCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEPClienteCadastroClienteActionPerformed
    }//GEN-LAST:event_txtCEPClienteCadastroClienteActionPerformed

    private void txtNumeroEnderecoCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroEnderecoCadastroClienteActionPerformed
    }//GEN-LAST:event_txtNumeroEnderecoCadastroClienteActionPerformed

    private void txtBairroClienteCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroClienteCadastroClienteActionPerformed
    }//GEN-LAST:event_txtBairroClienteCadastroClienteActionPerformed

    private void txtCelCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelCadastroClienteActionPerformed
    }//GEN-LAST:event_txtCelCadastroClienteActionPerformed

    private void txtEmailCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailCadastroClienteActionPerformed
        cliente.setEmailCadastroCliente(txtEmailCadastroCliente.getText());
    }//GEN-LAST:event_txtEmailCadastroClienteActionPerformed

    private void txtpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesquisaActionPerformed

    private void txtCPFPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFPesquisarActionPerformed

    private void txtCPFPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFPesquisarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFPesquisarKeyTyped

    private void rboFemininoCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboFemininoCadastroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboFemininoCadastroClienteActionPerformed

    private void rboMasculinoCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboMasculinoCadastroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboMasculinoCadastroClienteActionPerformed

    private void txtCPFCadastroClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFCadastroClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFCadastroClienteFocusLost

    private void btnPesquisarClienteCadastroClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPesquisarClienteCadastroClienteFocusLost

    }//GEN-LAST:event_btnPesquisarClienteCadastroClienteFocusLost

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        ModeloCadastroProduto obj = new ModeloCadastroProduto();

        ArrayList<ModeloCadastroProduto> lista = ProdutoDAO.filtrarTodos();
        DefaultTableModel modelo = (DefaultTableModel) tblProdutoCadastroProduto.getModel();

        modelo.setRowCount(0);
        for (ModeloCadastroProduto item : lista) {

            int id = item.getIdProdutoCadastroProduto();
            int qtd = item.getQntdProdutoCadastroProduto();
            String nome = item.getNomeProdutoCadastroProduto();
            double valor = item.getValorProdutoCadastroProduto();

            modelo.addRow(new Object[]{id, qtd, nome, valor});

            lblID.setText(String.valueOf(id));
            txtQntdProdutoCadastroProduto.setText(String.valueOf(qtd));
            txtNomeProdutoCadastroProduto.setText(nome);
            txtValorProdutoCadastroProduto.setText(String.valueOf(valor));
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnVerTodosActionPerformed

    private void btnVerTodosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosClienteActionPerformed
        ModeloCadastroCliente obj = new ModeloCadastroCliente();

        ArrayList<ModeloCadastroCliente> lista = ClienteDAO.filtratTodos();
        DefaultTableModel modelo = (DefaultTableModel) tblClienteCadastroCliente.getModel();

        modelo.setRowCount(0);

        for (ModeloCadastroCliente item : lista) {

            String nome = item.getNomeCadastroCliente();
            String cpf = item.getCpfCadastroCliente();
            Date dataNascimento = item.getDataNascimentoCadastroCliente();
            String cep = item.getCepClienteCadastroCliente();
            String endereco = item.getEnderecoCadastroCliente();
            int numero = item.getNumeroEnderecoCadastroCliente();
            String complemento = item.getComplementoClienteCadastroCliente();
            String bairro = item.getBairroClienteCadastroCliente();
            String cel = item.getCelCadastroCliente();
            String sexo = item.getSexo();
            String estadoCivil = item.getEstadoCivil();
            String email = item.getEmailCadastroCliente();

            modelo.addRow(new Object[]{nome, cpf, dataNascimento, cep, endereco, numero, complemento, bairro, cel, sexo, estadoCivil, email});

            txtNomeCadastroCliente.setText(nome);
            txtCPFCadastroCliente.setText(cpf);
            dcDataNasc.setDate(dataNascimento);
            txtCEPClienteCadastroCliente.setText(cep);
            txtEnderecoCadastroCliente.setText(endereco);
            txtNumeroEnderecoCadastroCliente.setText(String.valueOf(numero));
            txtComplementoClienteCadastroCliente.setText(complemento);
            txtBairroClienteCadastroCliente.setText(bairro);
            txtCelCadastroCliente.setText(cel);
            if (rboFemininoCadastroCliente.isSelected()) {
                rboMasculinoCadastroCliente.setText(sexo);

            } else if (rboMasculinoCadastroCliente.isSelected()) {
                rboMasculinoCadastroCliente.setText(sexo);
            }
            //Se botao solteiro selecionado então sera retornado na string genero o valor solteiro
            if (rboSolteiroCadastroCliente.isSelected()) {
                rboSolteiroCadastroCliente.setText(estadoCivil);
                //Se botao casado selecionado então sera retornado na string genero o valor casado    
            } else if (rboCasadoCadastroCliente.isSelected()) {
                rboCasadoCadastroCliente.setText(estadoCivil);
                //Se botao viuvo selecionado então sera retornado na string genero o valor viuvo    
            } else if (rboViuvoCadastroCliente.isSelected()) {
                rboViuvoCadastroCliente.setText(estadoCivil);
            }
            txtEmailCadastroCliente.setText(email);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerTodosClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClienteProduto().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label ID;
    private javax.swing.ButtonGroup bgEstadoCivilCadastroCliente;
    private javax.swing.ButtonGroup bgSexoCadastroCliente;
    private javax.swing.JButton btnAlterarProdutoCadastroProduto;
    private javax.swing.JButton btnAlterarclienteCadastroCliente;
    private javax.swing.JButton btnConfirmarCadastroCliente;
    private javax.swing.JButton btnConfirmarCadastroProduto;
    private javax.swing.JButton btnExcluirClienteCadastroCliente;
    private javax.swing.JButton btnExcluirProdutoCadastroProduto;
    private javax.swing.JButton btnLimparClienteCadastroCliente;
    private javax.swing.JButton btnLimparProdutoCadastroProduto;
    private javax.swing.JButton btnPesquisarClienteCadastroCliente;
    private javax.swing.JButton btnPesquisarProdutoCadastroProduto;
    private javax.swing.JButton btnSairCadastroCliente;
    private javax.swing.JButton btnSairCadastroProduto;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JButton btnVerTodosCliente;
    private com.toedter.calendar.JDateChooser dcDataNasc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JLabel lbNomeCadastroCliente;
    private javax.swing.JLabel lblBairroClienteCadastroCliente;
    private javax.swing.JLabel lblCEPClienteCadastroCliente;
    private javax.swing.JLabel lblCPFCadastroCliente;
    private javax.swing.JLabel lblCelCadastroCliente;
    private javax.swing.JLabel lblComplementoClienteCadastroCliente;
    private javax.swing.JLabel lblDatadeNascimentoCadastroCliente;
    private javax.swing.JLabel lblEmailCadastroCliente;
    private javax.swing.JLabel lblEnderecoCadastroCliente;
    private javax.swing.JLabel lblEstadoCivilCadastroCliente;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNomeProdutoCadastroProduto;
    private javax.swing.JLabel lblNumeroEnderecoCadastroCliente;
    private javax.swing.JLabel lblQntdProdutoCadastroProduto;
    private javax.swing.JLabel lblSexoCadastroCliente;
    private javax.swing.JLabel lblValorProdutoCadastroProdutoProduto;
    private javax.swing.JLabel lblidCliente;
    private javax.swing.JTabbedPane pnlCadastroProduto;
    private javax.swing.JPanel pnlTelaCadastroCliente;
    private javax.swing.JPanel pnlTelaCadastroProduto;
    private javax.swing.JRadioButton rboCasadoCadastroCliente;
    private javax.swing.JRadioButton rboFemininoCadastroCliente;
    private javax.swing.JRadioButton rboMasculinoCadastroCliente;
    private javax.swing.JRadioButton rboSolteiroCadastroCliente;
    private javax.swing.JRadioButton rboViuvoCadastroCliente;
    private javax.swing.JTable tblClienteCadastroCliente;
    private javax.swing.JTable tblProdutoCadastroProduto;
    private javax.swing.JTextField txtBairroClienteCadastroCliente;
    private javax.swing.JFormattedTextField txtCEPClienteCadastroCliente;
    private javax.swing.JFormattedTextField txtCPFCadastroCliente;
    private javax.swing.JFormattedTextField txtCPFPesquisar;
    private javax.swing.JFormattedTextField txtCelCadastroCliente;
    private javax.swing.JTextField txtComplementoClienteCadastroCliente;
    private javax.swing.JTextField txtEmailCadastroCliente;
    private javax.swing.JTextField txtEnderecoCadastroCliente;
    private javax.swing.JTextField txtNomeCadastroCliente;
    private javax.swing.JTextField txtNomeProdutoCadastroProduto;
    private javax.swing.JTextField txtNumeroEnderecoCadastroCliente;
    private javax.swing.JTextField txtQntdProdutoCadastroProduto;
    private javax.swing.JTextField txtValorProdutoCadastroProduto;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables

    public JTable getTblClienteCadastroCliente() {
        return tblClienteCadastroCliente;
    }

    public void setTblClienteCadastroCliente(JTable tblClienteCadastroCliente) {
        this.tblClienteCadastroCliente = tblClienteCadastroCliente;
    }
}
