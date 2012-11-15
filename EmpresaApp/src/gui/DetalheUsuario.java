/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bean.Empresa;
import bean.Experiencias;
import bean.Usuario;
import bean.Vagas;
import interfaces.RExperienciasRemote;
import interfaces.RUsuarioRemote;
import interfaces.RVagasRemote;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Thiago
 */
public class DetalheUsuario extends javax.swing.JFrame {

    /**
     * Creates new form DetalheUsuario
     */
    
    private Usuario usuario;
    
    private Empresa empresa;
    
    private DetalheExperiencia detalheExperiencia = new DetalheExperiencia();
    
    private List<Usuario> listaUsuario = new ArrayList<Usuario>();
            
    private List<Experiencias> exp;
    
    private List<Experiencias> experienciasUsuario;
    
    private List<Experiencias> experienciasAprovadas;
    
    private List<Vagas> vagasEmpresa;

    public List<Experiencias> getExperienciasUsuario() {
        return experienciasUsuario;
    }

    public void setExperienciasUsuario(List<Experiencias> experienciasUsuario) {
        this.experienciasUsuario = experienciasUsuario;
        obterDadosTableExp();    
        labelExperienciaCandidatoVazioFocusLost(null);
    }
       
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Experiencias> getExp() {
        return exp;
    }

    public void setExp(List<Experiencias> exp) {
        this.exp = exp;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        obterDadosTela();
    }
    
    public DetalheUsuario() {
        initComponents();
        centralizar();
        setResizable(false);
        experienciasAprovadas = new ArrayList<Experiencias>();
        vagasEmpresa = new ArrayList<Vagas>();
        consultaExperiencia();
    }
    
    public DetalheUsuario(Empresa empresa, List<Experiencias> experiencias, List<Usuario> usuarios, Usuario usuario, List<Experiencias> experienciasUsuario) {
        initComponents();
        centralizar();
        setResizable(false);
        experienciasAprovadas = new ArrayList<Experiencias>();
        vagasEmpresa = new ArrayList<Vagas>();
        consultaExperiencia();
        setEmpresa(empresa);
        setExperienciasUsuario(experienciasUsuario);
        setExp(experiencias);
        setUsuario(usuario);
        setListaUsuario(usuarios);
    }

    public void obterDadosTela() {
        setTxtNome(getUsuario().getNome());
        setTxtEmail(getUsuario().getEmail());
        setTxtAreaAtuacao(getUsuario().getArea());
        setTxtNivelAtuacao(getUsuario().getNivel());
        setTxtEscolaridade(getUsuario().getEscolaridade());
        setTxtCurso(getUsuario().getCurso());
        setTxtFaculdade(getUsuario().getFaculdade());
        setTxtDDDCelular(getUsuario().getDddcelular());
        setTxtCelular(getUsuario().getCelular());
        setTxtTelefone(getUsuario().getTelefone());
        setTxtDDDTelefone(getUsuario().getDddtelefone());
        setTxtCidade(getUsuario().getCidade());
        setTxtEstado(getUsuario().getEstado());
        setTxtEndereco(getUsuario().getEndereco());
    }
    
    public void obterDadosTableExp() {
        DefaultTableModel modelo = (DefaultTableModel) tableUsuarioExp.getModel();
        modelo.setNumRows(0);
        DetalheUsuario.CorLabel corLabel = new DetalheUsuario.CorLabel();
        corLabel.setForeground(Color.BLUE);
        tableUsuarioExp.getColumnModel().getColumn(2).setCellRenderer(corLabel);
        for (int i = 0; i < experienciasUsuario.size(); i++) {            
            if (experienciasUsuario.get(i).getStatus().equals("APROVADO")) {
                JLabel label = new JLabel("Clique Aqui");
                experienciasAprovadas.add(experienciasUsuario.get(i));
                Object[] row = {String.valueOf(experienciasUsuario.get(i).getDescricaoExperiencia()), String.valueOf(experienciasUsuario.get(i).getStatus()), label.getText()};
                modelo.addRow(row);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAreaAtuacao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNivelAtuacao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEscolaridade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFaculdade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtDDDCelular = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDDDTelefone = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarioExp = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelExperienciaCandidatoVazio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Currículo Completo do Candidato");

        txtEmail.setEnabled(false);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jLabel3.setText("E-Mail:");

        jLabel2.setText("Nome:");

        txtNome.setEnabled(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel4.setText("Área de Atuação:");

        txtAreaAtuacao.setEnabled(false);
        txtAreaAtuacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaAtuacaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nível de Atuação:");

        txtNivelAtuacao.setEnabled(false);

        jLabel6.setText("Escolaridade:");

        txtEscolaridade.setEnabled(false);
        txtEscolaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEscolaridadeActionPerformed(evt);
            }
        });

        jLabel7.setText("Curso:");

        txtCurso.setEnabled(false);
        txtCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCursoActionPerformed(evt);
            }
        });

        jLabel8.setText("Faculdade:");

        txtFaculdade.setEnabled(false);
        txtFaculdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFaculdadeActionPerformed(evt);
            }
        });

        jLabel9.setText("Celular:");

        txtCelular.setEnabled(false);
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        txtDDDCelular.setEnabled(false);

        jLabel10.setText("Telefone:");

        txtDDDTelefone.setEnabled(false);
        txtDDDTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDDDTelefoneActionPerformed(evt);
            }
        });

        txtTelefone.setEnabled(false);
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        jLabel11.setText("Cidade:");

        txtCidade.setEnabled(false);

        jLabel12.setText("Estado:");

        txtEstado.setEnabled(false);
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        jLabel13.setText("Endereço:");

        txtEndereco.setEnabled(false);
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        jLabel14.setText("Experiências Profisisonais");

        tableUsuarioExp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Exp. Profissional", "Status", "Ver Detalhe"
            }
        ));
        jScrollPane1.setViewportView(tableUsuarioExp);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Candidatar a Vaga Desejada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelExperienciaCandidatoVazio.setForeground(new java.awt.Color(255, 0, 0));
        labelExperienciaCandidatoVazio.setText("Este candidato não possui experiências profissionais aprovadas!");
        labelExperienciaCandidatoVazio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                labelExperienciaCandidatoVazioFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail)
                                .addComponent(txtAreaAtuacao)
                                .addComponent(txtNivelAtuacao)
                                .addComponent(txtEscolaridade)
                                .addComponent(txtCurso)
                                .addComponent(txtFaculdade)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDDDTelefone)
                                        .addComponent(txtDDDCelular))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtEstado)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelExperienciaCandidatoVazio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel14)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAreaAtuacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNivelAtuacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtFaculdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDDDCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDDDTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(7, 7, 7)
                .addComponent(labelExperienciaCandidatoVazio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtAreaAtuacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaAtuacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaAtuacaoActionPerformed

    private void txtEscolaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEscolaridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEscolaridadeActionPerformed

    private void txtCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCursoActionPerformed

    private void txtFaculdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFaculdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFaculdadeActionPerformed

    private void txtDDDTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDDDTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDDDTelefoneActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            InitialContext ctx = new InitialContext();
            Experiencias experience = new Experiencias();
            experience.setCNPJ(getEmpresa().getCnpj());
            RExperienciasRemote experiencias = (RExperienciasRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RExperiencias");
            RUsuarioRemote usuarioExperiencia = (RUsuarioRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RUsuario");
            exp = experiencias.consultarCnpjEmpresa(experience);
            listaUsuario = new ArrayList<Usuario>();
            for (int i = 0; i < exp.size(); i++) {
                        Usuario usuario = usuarioExperiencia.consultaUsuario(exp.get(i).getIdUsuario());
                        listaUsuario.add(usuario);
                    }
        }catch (NamingException ex) {
                    Logger.getLogger(AlterarStatusExperiencia.class.getName()).log(Level.SEVERE, null, ex);
        }                    
        Aplicacao app = new Aplicacao(getEmpresa(), exp, listaUsuario);
        app.setVisible(true);
        app.setTitle("Projeto Interdisciplinar II");
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            RVagasRemote vagaEmpresa = (RVagasRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RVagas");                
            vagasEmpresa = vagaEmpresa.consultarVagasEmpresa(empresa.getId());
            CandidatarUsuario userCompany = new CandidatarUsuario();
            userCompany.setUsuario(usuario);
            userCompany.setEmpresa(empresa);
            userCompany.setExperienciasAprovadas(experienciasAprovadas);
            userCompany.setExperienciasUsuario(experienciasUsuario);
            userCompany.setListaUsuario(listaUsuario);
            userCompany.setExp(exp);
            userCompany.setListaVagasEmpresa(vagasEmpresa);
            userCompany.setTitle("Projeto Interdisciplinar II");
            userCompany.setVisible(true);        
            dispose();
        } catch (NamingException ex) {
            Logger.getLogger(DetalheUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void labelExperienciaCandidatoVazioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelExperienciaCandidatoVazioFocusLost
        labelExperienciaCandidatoVazio.setVisible(experienciasAprovadas.isEmpty());
    }//GEN-LAST:event_labelExperienciaCandidatoVazioFocusLost

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
            java.util.logging.Logger.getLogger(DetalheUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalheUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalheUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalheUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DetalheUsuario().setVisible(true);
            }
        });
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

    public JTextField getTxtAreaAtuacao() {
        return txtAreaAtuacao;
    }

    public void setTxtAreaAtuacao(String txtAreaAtuacao) {
        this.txtAreaAtuacao.setText(txtAreaAtuacao);
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(String txtCelular) {
        this.txtCelular.setText(txtCelular);
    }

    public JTextField getTxtCidade() {
        return txtCidade;
    }

    public void setTxtCidade(String txtCidade) {
        this.txtCidade.setText(txtCidade);
    }

    public JTextField getTxtCurso() {
        return txtCurso;
    }

    public void setTxtCurso(String txtCurso) {
        this.txtCurso.setText(txtCurso);
    }

    public JTextField getTxtDDDCelular() {
        return txtDDDCelular;
    }

    public void setTxtDDDCelular(String txtDDDCelular) {
        this.txtDDDCelular.setText(txtDDDCelular);
    }

    public JTextField getTxtDDDTelefone() {
        return txtDDDTelefone;
    }

    public void setTxtDDDTelefone(String txtDDDTelefone) {
        this.txtDDDTelefone.setText(txtDDDTelefone);
    }

    public JFormattedTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    public JTextField getTxtEndereco() {
        return txtEndereco;
    }

    public void setTxtEndereco(String txtEndereco) {
        this.txtEndereco.setText(txtEndereco);
    }

    public JTextField getTxtEscolaridade() {
        return txtEscolaridade;
    }

    public void setTxtEscolaridade(String txtEscolaridade) {
        this.txtEscolaridade.setText(txtEscolaridade);
    }

    public JTextField getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(String txtEstado) {
        this.txtEstado.setText(txtEstado);
    }

    public JTextField getTxtFaculdade() {
        return txtFaculdade;
    }

    public void setTxtFaculdade(String txtFaculdade) {
        this.txtFaculdade.setText(txtFaculdade);
    }

    public JTextField getTxtNivelAtuacao() {
        return txtNivelAtuacao;
    }

    public void setTxtNivelAtuacao(String txtNivelAtuacao) {
        this.txtNivelAtuacao.setText(txtNivelAtuacao);
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome.setText(txtNome);
    }

    public JTextField getTxtTelefone() {
        return txtTelefone;
    }

    public void setTxtTelefone(String txtTelefone) {
        this.txtTelefone.setText(txtTelefone);
    }
    
    public class CorLabel extends DefaultTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            return this;

        }
    }
    
    public void consultaExperiencia() {
        tableUsuarioExp.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if (e.getClickCount() == 1 && tableUsuarioExp.getSelectedColumn() == 2) {
                 detalheExperiencia.setUsuario(usuario);
                 detalheExperiencia.setEmpresa(getEmpresa());
                 detalheExperiencia.setListaUsuario(listaUsuario);
                 detalheExperiencia.setExp(exp);
                 detalheExperiencia.setExperienciasUsuario(experienciasUsuario);                 
                 detalheExperiencia.setExperiencia(experienciasAprovadas.get(tableUsuarioExp.getSelectedRow()));                 
                 if (!detalheExperiencia.isVisible()) {
                        detalheExperiencia.setVisible(true);
                    }
                dispose();
             }
             }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelExperienciaCandidatoVazio;
    private javax.swing.JTable tableUsuarioExp;
    private javax.swing.JTextField txtAreaAtuacao;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtDDDCelular;
    private javax.swing.JTextField txtDDDTelefone;
    private javax.swing.JFormattedTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEscolaridade;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFaculdade;
    private javax.swing.JTextField txtNivelAtuacao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
