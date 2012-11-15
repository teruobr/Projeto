/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bean.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author 31010296
 */
public class Aplicacao extends javax.swing.JFrame {

    /**
     * Creates new form Aplicacao
     */
    private DetalheVaga detalhe = new DetalheVaga();
    private AlterarStatusExperiencia status = new AlterarStatusExperiencia();
    private DetalheUsuario usuario = new DetalheUsuario();
    private Empresa empresa;
    private List<Usuario> listaUsuarioDetalhe;
    private List<Vagas> listaVagas;
    private List<VagasUsuario> listaUsuariosVaga;
    private List<List<VagasUsuario>> listaUsuario;
    private List<Experiencias> experienciasEmpresa;
    private List<Experiencias> experienciasTotais;
    private List<List<Experiencias>> experienciasUsuario;
    private List<Usuario> usuarioExperiencia;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Aplicacao() {
        listaUsuario = new ArrayList<List<VagasUsuario>>();
        experienciasUsuario = new ArrayList<List<Experiencias>>();
        empresa = new Empresa();
        initComponents();
        centralizar();
        setResizable(false);
        consultarVaga();
        consultaStatusExp();
        consultaUsuario();
        setTitle("Projeto Interdisciplinar II");
        //vagasTabela.setEnabled(false);
        try {
            MaskFormatter maskCNPJ = new MaskFormatter("##.###.###/####-##");
            maskCNPJ.install(txtCNPJ);
            MaskFormatter maskDDD = new MaskFormatter("##");
            maskDDD.install(txtDDD);
            MaskFormatter maskTel = new MaskFormatter("####-####");
            maskTel.install(txtTel);
        } catch (ParseException ex) {
        }

        InitialContext ctx = null;
        List<AreaAtuacao> areas = null;
        try {
            ctx = new InitialContext();
            RAreaAtuacaoRemote areasremote = (RAreaAtuacaoRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RAreaAtuacao");

            areas = areasremote.consultar();
            if (areas != null) {

                for (int i = 0; i < areas.size(); i++) {
                    cbAreaVaga.addItem(areas.get(i).getNome());
                    cbAreaCandidato.addItem(areas.get(i).getNome());
                }
            }

        } catch (NamingException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Aplicacao(Empresa empresa, List<Experiencias> experiencias, List<Usuario> usuario) {
        initComponents();
        centralizar();
        setResizable(false);
        setEmpresa(empresa);
        setUsuarioExperiencia(usuario);
        setExperienciasEmpresa(experiencias);
        this.empresa = getEmpresa();
        listaUsuario = new ArrayList<List<VagasUsuario>>();
        experienciasUsuario = new ArrayList<List<Experiencias>>();
        consultarVaga();
        consultaStatusExp();
        consultaUsuario();
        pegarDados();

        InitialContext ctx = null;
        List<AreaAtuacao> areas = null;
        try {
            ctx = new InitialContext();
            RAreaAtuacaoRemote areasremote = (RAreaAtuacaoRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RAreaAtuacao");

            areas = areasremote.consultar();
            if (areas != null) {
                for (int i = 0; i < areas.size(); i++) {
                    cbAreaVaga.addItem(areas.get(i).getNome());
                    cbAreaCandidato.addItem(areas.get(i).getNome());
                }
            }

        } catch (NamingException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pegarDados() {
        setTxtBairro(this.empresa.getBairro());
        setTxtCNPJ(this.empresa.getCnpj());
        setCbCidade(String.valueOf(this.empresa.getCidade()));
        setTxtCNPJ(this.empresa.getCnpj());
        setTxtDDD(this.empresa.getDDD());
        setTxtEndereco(this.empresa.getEndereco());
        setCbEstado(String.valueOf(this.empresa.getEstado()));
        setTxtResponsavel(this.empresa.getResponsavelRH());
        setTxtTel(this.empresa.getTelefone());
        setTxtEmpresa(this.empresa.getNome());
        setTxtID(String.valueOf(this.empresa.getId()));
        setCbArea(String.valueOf(this.empresa.getAreaatuacao()));
        setSenha(this.empresa.getSenha());
        setEmpresa(empresa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVagas = new javax.swing.JTabbedPane();
        Principal = new javax.swing.JPanel();
        txtEndereco = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtResponsavel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnManutencao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox();
        cbCidade = new javax.swing.JComboBox();
        cbArea = new javax.swing.JComboBox();
        txtCNPJ = new javax.swing.JFormattedTextField();
        txtDDD = new javax.swing.JFormattedTextField();
        txtTel = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        vagasTabela = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtVaga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbEstadoVaga = new javax.swing.JComboBox();
        cbAreaVaga = new javax.swing.JComboBox();
        cbNivelAtuacaoVaga = new javax.swing.JComboBox();
        cbCidadeVaga = new javax.swing.JComboBox();
        btnCriaVaga = new javax.swing.JButton();
        pnlCandidatos = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        candidatoTabela = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        cbEstadoCandidato = new javax.swing.JComboBox();
        cbCidadeCandidato = new javax.swing.JComboBox();
        cbNivelCandidato = new javax.swing.JComboBox();
        cbAreaCandidato = new javax.swing.JComboBox();
        cbEscolaridadeCandidato = new javax.swing.JComboBox();
        cbCursoCandidato = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableExperiencias = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        labelAprovacoesVazio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlVagas.setPreferredSize(new java.awt.Dimension(900, 900));

        Principal.setPreferredSize(new java.awt.Dimension(750, 750));

        txtEndereco.setEnabled(false);
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        txtEmpresa.setEditable(false);
        txtEmpresa.setEnabled(false);
        txtEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaActionPerformed(evt);
            }
        });

        txtResponsavel.setEnabled(false);

        jLabel4.setText("Estado:");

        jLabel5.setText("Cidade:");

        jLabel3.setText("CNPJ:");

        jLabel8.setText("Responsável RH:");

        jLabel6.setText("Bairro:");

        jLabel7.setText("Telefone:");

        jLabel2.setText("Nome da Empresa:");

        jLabel10.setText("Ramo de Atuação:");

        jLabel9.setText("Endereço:");

        txtBairro.setEnabled(false);
        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnManutencao.setText("Alterar");
        btnManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManutencaoActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        txtID.setEditable(false);
        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "SP" }));
        cbEstado.setEnabled(false);

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "São Paulo", "Santo André", "São Bernardo do Campo", "São Caetano do Sul" }));
        cbCidade.setEnabled(false);

        cbArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Tecnologia da Informação", "Bancos", "Indústrias", "Finanças", "Outros" }));
        cbArea.setEnabled(false);
        cbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAreaActionPerformed(evt);
            }
        });

        txtCNPJ.setEnabled(false);

        txtDDD.setEnabled(false);
        txtDDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDDDActionPerformed(evt);
            }
        });

        txtTel.setEnabled(false);

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PrincipalLayout.createSequentialGroup()
                                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addGap(75, 75, 75)
                                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResponsavel)
                                    .addComponent(cbArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PrincipalLayout.createSequentialGroup()
                                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(70, 70, 70)
                                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtEndereco)
                                    .addComponent(txtEmpresa)
                                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCNPJ)
                                    .addGroup(PrincipalLayout.createSequentialGroup()
                                        .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                        .addGap(73, 73, 73)
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAtualizar)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))))
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar))
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                        .addGap(80, 80, 80))
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManutencao))
                        .addContainerGap())))
        );

        pnlVagas.addTab("Visualizar Dados", Principal);

        vagasTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome da vaga", "Nível Atuação", "Área Atuação", "Ver Detalhe"
            }
        ));
        jScrollPane3.setViewportView(vagasTabela);

        jLabel11.setText("Título da vaga:");

        jLabel12.setText("Área de Atuação:");

        jLabel13.setText("Estado:");

        jLabel16.setText("Cidade:");

        jLabel17.setText("Nível de Atuação:");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbEstadoVaga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "SP" }));

        cbAreaVaga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Analise", "Docência e Pesquisa", "Empresário", "Gerencia", "Programação", "Redes" }));
        cbAreaVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAreaVagaActionPerformed(evt);
            }
        });

        cbNivelAtuacaoVaga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Técnico", "Estagiário", "Junior", "Pleno", "Senior", "Gerente" }));

        cbCidadeVaga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "São Paulo", "Santo André", "São Bernardo do Campo", "São Caetano do Sul" }));

        btnCriaVaga.setText("Criar Vaga");
        btnCriaVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaVagaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(cbEstadoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel16)
                                                        .addGap(81, 81, 81)
                                                        .addComponent(cbCidadeVaga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                        .addComponent(cbNivelAtuacaoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(txtVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbAreaVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 9, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCriaVaga)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButton1))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(553, 553, 553))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbAreaVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(cbNivelAtuacaoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbEstadoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cbCidadeVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriaVaga)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlVagas.addTab("Vagas", jPanel2);

        jLabel18.setText("Cidade:");

        jLabel19.setText("Nível de Atuação:");

        jLabel14.setText("Área de Atuação:");

        jLabel15.setText("Estado:");

        jLabel20.setText("Curso:");

        jLabel21.setText("Grau de Escolaridade:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        candidatoTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "E-mail", "Área de Atuação", "Nível de Atuação", "Grau de Escolaridade", "Curso", "Ver Detalhe"
            }
        ));
        jScrollPane15.setViewportView(candidatoTabela);

        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbEstadoCandidato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "SP" }));
        cbEstadoCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoCandidatoActionPerformed(evt);
            }
        });

        cbCidadeCandidato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "São Paulo", "Santo André", "São Bernardo do Campo", "São Caetano do Sul" }));

        cbNivelCandidato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Técnico", "Estagiário", "Júnior", "Pleno", "Senior", "Gerente" }));
        cbNivelCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNivelCandidatoActionPerformed(evt);
            }
        });

        cbAreaCandidato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Analise", "Docência e Pesquisa", "Empresário", "Gerência", "Programação", "Redes" }));
        cbAreaCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAreaCandidatoActionPerformed(evt);
            }
        });

        cbEscolaridadeCandidato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Técnico", "Superior Incompleto", "Superior Completo", "Pós-Graduado" }));

        cbCursoCandidato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Sistemas de Informação", "Ciência da Computação", "ADS" }));

        javax.swing.GroupLayout pnlCandidatosLayout = new javax.swing.GroupLayout(pnlCandidatos);
        pnlCandidatos.setLayout(pnlCandidatosLayout);
        pnlCandidatosLayout.setHorizontalGroup(
            pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCandidatosLayout.createSequentialGroup()
                .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCandidatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane15))
                    .addGroup(pnlCandidatosLayout.createSequentialGroup()
                        .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCandidatosLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbNivelCandidato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbEscolaridadeCandidato, 0, 174, Short.MAX_VALUE)
                                    .addComponent(cbEstadoCandidato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(49, 49, 49)
                                .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCandidatosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(27, 27, 27)))
                        .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCandidatosLayout.createSequentialGroup()
                                    .addComponent(btnPesquisar)
                                    .addGap(53, 53, 53))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCandidatosLayout.createSequentialGroup()
                                    .addComponent(cbCursoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(111, 111, 111)))
                            .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbCidadeCandidato, javax.swing.GroupLayout.Alignment.LEADING, 0, 202, Short.MAX_VALUE)
                                .addComponent(cbAreaCandidato, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCandidatosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(24, 24, 24))
        );
        pnlCandidatosLayout.setVerticalGroup(
            pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCandidatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(5, 5, 5)
                .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(cbNivelCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCidadeCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbAreaCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cbEscolaridadeCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCursoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cbEstadoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlVagas.addTab("Candidatos", pnlCandidatos);

        jButton5.setText("Sair");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tableExperiencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome do Candidato", "Experiência Profissional", "Status", "Alterar"
            }
        ));
        jScrollPane1.setViewportView(tableExperiencias);

        jButton6.setText("Atualizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel22.setText("Aprovação de Experiências Profissionais");

        labelAprovacoesVazio.setForeground(new java.awt.Color(255, 0, 0));
        labelAprovacoesVazio.setText("Não existem aprovações de experiências profissionais!");
        labelAprovacoesVazio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                labelAprovacoesVazioFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(286, 286, 286)
                            .addComponent(jLabel22))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelAprovacoesVazio)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(42, 42, 42)
                .addComponent(jLabel22)
                .addGap(22, 22, 22)
                .addComponent(labelAprovacoesVazio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addComponent(jButton6)
                .addGap(42, 42, 42))
        );

        pnlVagas.addTab("Aprovação de Experiências Profissionais", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVagas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InitialContext ctx = null;
        DefaultTableModel modelo = (DefaultTableModel) vagasTabela.getModel();
        modelo.setNumRows(0);

        try {
            ctx = new InitialContext();
            RVagasRemote vagas = (RVagasRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RVagas");
            Vagas busca = new Vagas();
            busca.setTitulo(txtVaga.getText());
            busca.setAreaAtuacao(String.valueOf(cbAreaVaga.getSelectedItem()));
            busca.setNivelAtuacao(String.valueOf(cbNivelAtuacaoVaga.getSelectedItem()));
            busca.setEstado(String.valueOf(cbEstadoVaga.getSelectedItem()));
            busca.setCidade(String.valueOf(cbCidadeVaga.getSelectedItem()));
            busca.setIdEmpresa(getEmpresa().getId());

            CorLabel corLabel = new CorLabel();
            corLabel.setForeground(Color.BLUE);
            vagasTabela.getColumnModel().getColumn(3).setCellRenderer(corLabel);

            listaVagas = vagas.consultar(busca);

            RVagasUsuarioRemote usuariosVaga = (RVagasUsuarioRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RVagasUsuario");


            if (listaVagas != null && !listaVagas.isEmpty()) {
                for (int i = 0; i < listaVagas.size(); i++) {
                    listaUsuariosVaga = new ArrayList<VagasUsuario>();
                    listaUsuariosVaga = usuariosVaga.buscarUsuariosVaga(listaVagas.get(i).getId());
                    listaUsuario.add(listaUsuariosVaga);
                    JLabel label = new JLabel("Clique Aqui");
                    label.setForeground(Color.BLUE);
                    Object[] row = {String.valueOf(listaVagas.get(i).getTitulo()), String.valueOf(listaVagas.get(i).getNivelAtuacao()), String.valueOf(listaVagas.get(i).getAreaAtuacao()), label.getText()};
                    modelo.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vaga não encontrada");
            }
        } catch (NamingException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManutencaoActionPerformed
        btnAtualizar.setEnabled(true);
        btnManutencao.setEnabled(false);
        cbArea.setEnabled(true);
        txtBairro.setEnabled(true);
        cbCidade.setEnabled(true);
        txtDDD.setEnabled(true);
        txtEndereco.setEnabled(true);
        cbEstado.setEnabled(true);
        txtResponsavel.setEnabled(true);
        txtTel.setEnabled(true);
        txtVaga.setEnabled(true);
    }//GEN-LAST:event_btnManutencaoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        if (validar()) {
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja atualizar?", "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                Empresa company = new Empresa();
                company.setBairro(txtBairro.getText());
                company.setCidade(String.valueOf(cbCidade.getSelectedItem()));
                company.setCnpj(txtCNPJ.getText());
                company.setDDD(txtDDD.getText());
                company.setEndereco(txtEndereco.getText());
                company.setEstado(String.valueOf(cbEstado.getSelectedItem()));
                company.setResponsavelRH(txtResponsavel.getText());
                company.setTelefone(txtTel.getText());
                company.setNome(txtEmpresa.getText());
                company.setId(Long.parseLong(txtID.getText()));
                company.setAreaatuacao(String.valueOf(cbArea.getSelectedItem()));
                company.setSenha(senha);
                setEmpresa(company);

                try {
                    InitialContext ctx = new InitialContext();
                    REmpresaRemote empresa = (REmpresaRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/REmpresa");
                    empresa.alterar(company);
                    JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");

                    btnAtualizar.setEnabled(false);
                    btnManutencao.setEnabled(true);
                    cbArea.setEnabled(false);
                    txtBairro.setEnabled(false);
                    txtCNPJ.setEnabled(false);
                    cbCidade.setEnabled(false);
                    txtDDD.setEnabled(false);
                    txtEmpresa.setEnabled(false);
                    txtEndereco.setEnabled(false);
                    cbEstado.setEnabled(false);
                    txtResponsavel.setEnabled(false);
                    txtTel.setEnabled(false);
                    txtVaga.setEnabled(false);

                } catch (NamingException ex) {
                    Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Erro na atualização!");
                }
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnCriaVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaVagaActionPerformed
        CadastraVaga cv = new CadastraVaga();
        cv.setTitle("Projeto Interdisciplinar II");
        cv.setEmpresa(getEmpresa());
        cv.setExp(experienciasEmpresa);
        cv.setUsuario(usuarioExperiencia);
        cv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCriaVagaActionPerformed

    private void cbAreaVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAreaVagaActionPerformed
    }//GEN-LAST:event_cbAreaVagaActionPerformed

    private void cbEstadoCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoCandidatoActionPerformed

    private void cbNivelCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNivelCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNivelCandidatoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        InitialContext ctx = null;
        DefaultTableModel modelo = (DefaultTableModel) candidatoTabela.getModel();
        modelo.setNumRows(0);

        try {
            ctx = new InitialContext();
            RUsuarioRemote usuario = (RUsuarioRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RUsuario");
            RExperienciasRemote experiencias = (RExperienciasRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RExperiencias");
            Usuario busca = new Usuario();
            busca.setArea(String.valueOf(cbAreaCandidato.getSelectedItem()));
            busca.setNivel(String.valueOf(cbNivelCandidato.getSelectedItem()));
            busca.setEstado(String.valueOf(cbEstadoCandidato.getSelectedItem()));
            busca.setEscolaridade(String.valueOf(cbEscolaridadeCandidato.getSelectedItem()));
            busca.setCidade(String.valueOf(cbCidadeCandidato.getSelectedItem()));
            busca.setCurso(String.valueOf(cbCursoCandidato.getSelectedItem()));

            CorLabel corLabel = new CorLabel();
            corLabel.setForeground(Color.BLUE);
            candidatoTabela.getColumnModel().getColumn(6).setCellRenderer(corLabel);

            listaUsuarioDetalhe = usuario.consultarUsuario(busca);

            if (listaUsuarioDetalhe != null && !listaUsuarioDetalhe.isEmpty()) {
                for (int i = 0; i < listaUsuarioDetalhe.size(); i++) {
                    experienciasTotais = new ArrayList<Experiencias>();
                    Experiencias experience = new Experiencias();
                    experience.setIdUsuario(listaUsuarioDetalhe.get(i).getId());
                    experienciasTotais = experiencias.consultar(experience);
                    experienciasUsuario.add(experienciasTotais);
                    JLabel label = new JLabel("Clique Aqui");
                    label.setForeground(Color.BLUE);
                    Object[] row = {String.valueOf(listaUsuarioDetalhe.get(i).getNome()), String.valueOf(listaUsuarioDetalhe.get(i).getEmail()), String.valueOf(listaUsuarioDetalhe.get(i).getArea()), String.valueOf(listaUsuarioDetalhe.get(i).getNivel()), String.valueOf(listaUsuarioDetalhe.get(i).getEscolaridade()), String.valueOf(listaUsuarioDetalhe.get(i).getCurso()), label.getText()};
                    modelo.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Candidato não encontrado");
            }
        } catch (NamingException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtDDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDDDActionPerformed

    private void cbAreaCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAreaCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAreaCandidatoActionPerformed

    private void cbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAreaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Login login = new Login();
        login.setTitle("Projeto Interdisciplinar II");
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            RExperienciasRemote exp = (RExperienciasRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RExperiencias");
            RUsuarioRemote userExp = (RUsuarioRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RUsuario");

            Experiencias experience = new Experiencias();
            experience.setCNPJ(String.valueOf(txtCNPJ.getText()));
            experienciasEmpresa = exp.consultarCnpjEmpresa(experience);

            usuarioExperiencia = new ArrayList<Usuario>();

            for (int i = 0; i < experienciasEmpresa.size(); i++) {
                Usuario usuario = userExp.consultaUsuario(experienciasEmpresa.get(i).getIdUsuario());
                usuarioExperiencia.add(usuario);
            }

            DefaultTableModel modelo = (DefaultTableModel) tableExperiencias.getModel();
            modelo.setNumRows(0);
            CorLabel corLabel = new CorLabel();
            corLabel.setForeground(Color.BLUE);
            tableExperiencias.getColumnModel().getColumn(3).setCellRenderer(corLabel);
            if (experienciasEmpresa != null && !experienciasEmpresa.isEmpty()) {
                for (int i = 0; i < experienciasEmpresa.size(); i++) {
                    JLabel label = new JLabel("Clique Aqui");
                    label.setForeground(Color.BLUE);
                    Object[] row = {String.valueOf(usuarioExperiencia.get(i).getNome()), String.valueOf(experienciasEmpresa.get(i).getDescricaoExperiencia()), String.valueOf(experienciasEmpresa.get(i).getStatus()), label.getText()};
                    modelo.addRow(row);
                    labelAprovacoesVazioFocusLost(null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Neste momento, não existem experiências profissionais para serem aprovadas!");                
                labelAprovacoesVazioFocusLost(null);
            }
        } catch (NamingException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Erro ao Atualizar!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void labelAprovacoesVazioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelAprovacoesVazioFocusLost
        labelAprovacoesVazio.setVisible(experienciasEmpresa.isEmpty());
    }//GEN-LAST:event_labelAprovacoesVazioFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Aplicacao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Principal;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCriaVaga;
    private javax.swing.JButton btnManutencao;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JTable candidatoTabela;
    private javax.swing.JComboBox cbArea;
    private javax.swing.JComboBox cbAreaCandidato;
    private javax.swing.JComboBox cbAreaVaga;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbCidadeCandidato;
    private javax.swing.JComboBox cbCidadeVaga;
    private javax.swing.JComboBox cbCursoCandidato;
    private javax.swing.JComboBox cbEscolaridadeCandidato;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbEstadoCandidato;
    private javax.swing.JComboBox cbEstadoVaga;
    private javax.swing.JComboBox cbNivelAtuacaoVaga;
    private javax.swing.JComboBox cbNivelCandidato;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAprovacoesVazio;
    private javax.swing.JPanel pnlCandidatos;
    private javax.swing.JTabbedPane pnlVagas;
    private javax.swing.JTable tableExperiencias;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtDDD;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtVaga;
    private javax.swing.JTable vagasTabela;
    // End of variables declaration//GEN-END:variables
    public String senha;

    public JComboBox getCbArea() {
        return cbArea;
    }

    public void setCbArea(String cbArea) {
        this.cbArea.setSelectedItem(cbArea);
    }

    public JComboBox getCbCidade() {
        return cbCidade;
    }

    public void setCbCidade(String cbCidade) {
        this.cbCidade.setSelectedItem(cbCidade);
    }

    public JComboBox getCbEstado() {
        return cbEstado;
    }

    public void setCbEstado(String cbEstado) {
        this.cbEstado.setSelectedItem(cbEstado);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(String txtID) {
        this.txtID.setText(txtID);
    }

    public JTextField getTxtBairro() {
        return txtBairro;
    }

    public void setTxtBairro(String txtBairro) {
        this.txtBairro.setText(txtBairro);
    }

    public JTextField getTxtCNPJ() {
        return txtCNPJ;
    }

    public void setTxtCNPJ(String txtCNPJ) {
        this.txtCNPJ.setText(txtCNPJ);
    }

    public JTextField getTxtDDD() {
        return txtDDD;
    }

    public void setTxtDDD(String txtDDD) {
        this.txtDDD.setText(txtDDD);
    }

    public JTextField getTxtEmpresa() {
        return txtEmpresa;
    }

    public void setTxtEmpresa(String txtEmpresa) {
        this.txtEmpresa.setText(txtEmpresa);
    }

    public JTextField getTxtEndereco() {
        return txtEndereco;
    }

    public void setTxtEndereco(String txtEndereco) {
        this.txtEndereco.setText(txtEndereco);
    }

    public JTextField getTxtResponsavel() {
        return txtResponsavel;
    }

    public void setTxtResponsavel(String txtResponsavel) {
        this.txtResponsavel.setText(txtResponsavel);
    }

    public JTextField getTxtTel() {
        return txtTel;
    }

    public void setTxtTel(String txtTel) {
        this.txtTel.setText(txtTel);
    }

    public JTextField getTxtVaga() {
        return txtVaga;
    }

    public void setTxtVaga(String txtVaga) {
        this.txtVaga.setText(txtVaga);
    }

    private void centralizar() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela = getSize();
        if (janela.height > screen.height) {
            setSize(janela.width, screen.height);
        }
        if (janela.width > screen.width) {
            setSize(screen.width, janela.height);
        }
        setLocation((screen.width - janela.width) / 2, (screen.height - janela.height) / 2);
    }

    private boolean validar() {
        if (cbEstado.getSelectedItem().equals("Selecione")
                || cbCidade.getSelectedItem().equals("Selecione")
                || txtBairro.getText().trim().equals("")
                || txtEndereco.getText().trim().equals("")
                || txtDDD.getText().trim().equals("")
                || txtTel.getText().trim().equals("")
                || txtResponsavel.getText().trim().equals("")
                || cbArea.getSelectedItem().equals("Selecione")) {

            JOptionPane.showMessageDialog(this, "Preencher todos os campos!");
            return false;
        }
        return true;
    }

    public class CorLabel extends DefaultTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            return this;

        }
    }

    public void consultarVaga() {
        vagasTabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && vagasTabela.getSelectedColumn() == 3) {
                    detalhe.setListaVaga(listaVagas.get(vagasTabela.getSelectedRow()));
                    detalhe.setEmpresa(getEmpresa());
                    detalhe.setExp(experienciasEmpresa);
                    detalhe.setUser(usuarioExperiencia);
                    detalhe.setLista(listaUsuario.get(vagasTabela.getSelectedRow()));
                    detalhe.setTitle("Projeto Interdisciplinar II");
                    if (!detalhe.isVisible()) {
                        detalhe.setVisible(true);
                    }
                    dispose();
                }
            }
        });
    }

    public void obterTableExperiencia() {
        DefaultTableModel modelo = (DefaultTableModel) tableExperiencias.getModel();
        modelo.setNumRows(0);
        CorLabel corLabel = new CorLabel();
        CorLabel cor = new CorLabel();
        CorLabel corVerde = new CorLabel();
        CorLabel corVermelho = new CorLabel();
        corLabel.setForeground(Color.BLUE);
        cor.setForeground(Color.ORANGE);
        corVerde.setForeground(new Color(0, 100, 0));
        corVermelho.setForeground(Color.RED);
        tableExperiencias.getColumnModel().getColumn(3).setCellRenderer(corLabel);

        if (experienciasEmpresa != null && !experienciasEmpresa.isEmpty()) {
            for (int i = 0; i < experienciasEmpresa.size(); i++) {
                JLabel label = new JLabel("Clique Aqui");
                label.setForeground(Color.BLUE);
                Object[] row = {String.valueOf(usuarioExperiencia.get(i).getNome()), String.valueOf(experienciasEmpresa.get(i).getDescricaoExperiencia()), String.valueOf(experienciasEmpresa.get(i).getStatus()), label.getText()};
                modelo.addRow(row);
            }
        }
    }

    public List<Experiencias> getExperienciasEmpresa() {
        return experienciasEmpresa;
    }

    public void setExperienciasEmpresa(List<Experiencias> experienciasEmpresa) {
        this.experienciasEmpresa = experienciasEmpresa;
        obterTableExperiencia();
        labelAprovacoesVazioFocusLost(null);
    }

    public List<Usuario> getUsuarioExperiencia() {
        return usuarioExperiencia;
    }

    public void setUsuarioExperiencia(List<Usuario> usuarioExperiencia) {
        this.usuarioExperiencia = usuarioExperiencia;
    }

    public void consultaStatusExp() {
        tableExperiencias.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && tableExperiencias.getSelectedColumn() == 3) {
                    status.setEmpresa(getEmpresa());
                    status.setExp(experienciasEmpresa);
                    status.setUser(usuarioExperiencia);
                    status.setUsuario(usuarioExperiencia.get(tableExperiencias.getSelectedRow()));
                    status.setExperiencia(experienciasEmpresa.get(tableExperiencias.getSelectedRow()));
                    status.setTitle("Projeto Interdisciplinar II");
                    if (!status.isVisible()) {
                        status.setVisible(true);
                    }
                    dispose();
                }
            }
        });
    }

    public void consultaUsuario() {
        candidatoTabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && candidatoTabela.getSelectedColumn() == 6) {
                    usuario.setUsuario(listaUsuarioDetalhe.get(candidatoTabela.getSelectedRow()));
                    usuario.setExperienciasUsuario(experienciasUsuario.get(candidatoTabela.getSelectedRow()));
                    usuario.setEmpresa(getEmpresa());
                    usuario.setExp(experienciasEmpresa);
                    usuario.setListaUsuario(listaUsuarioDetalhe);
                    usuario.setTitle("Projeto Interdisciplinar II");
                    if (!usuario.isVisible()) {
                        usuario.setVisible(true);
                    }
                    dispose();
                }
            }
        });
    }
}
