/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bean.Empresa;
import interfaces.REmpresa;
import interfaces.REmpresaRemote;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author 31049184
 */
public class Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        initComponents();
        centralizar();
        try {
            MaskFormatter maskCNPJ = new MaskFormatter("##.###.###/####-##");
            maskCNPJ.install(txtCNPJ);
            MaskFormatter maskDDD = new MaskFormatter("##");
            maskDDD.install(txtDDD);
            MaskFormatter maskTel = new MaskFormatter("####-####");
            maskTel.install(txtTel);
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Cadastro().setVisible(true);
            }
        });
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtResponsavel = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox();
        cbArea = new javax.swing.JComboBox();
        cbCidade = new javax.swing.JComboBox();
        txtCNPJ = new javax.swing.JFormattedTextField();
        txtDDD = new javax.swing.JFormattedTextField();
        txtTel = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastro");

        jLabel2.setText("Nome da Empresa:");

        jLabel3.setText("CNPJ:");

        jLabel4.setText("Estado:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("Bairro:");

        jLabel7.setText("Telefone:");

        jLabel8.setText("Responsável RH:");

        jLabel9.setText("Endereço:");

        jLabel10.setText("Área de Atuação:");

        txtEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaActionPerformed(evt);
            }
        });

        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel11.setText("Senha");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "SP" }));

        cbArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Tecnologia da Informação", "Bancos", "Indústrias", "Finanças", "Outros" }));
        cbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAreaActionPerformed(evt);
            }
        });

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "São Paulo", "Santo André", "São Bernardo do Campo", "São Caetano do Sul" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnFinalizar))
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(txtEmpresa)
                                    .addComponent(txtBairro)
                                    .addComponent(txtEndereco)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCNPJ)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTel)))))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        Empresa company = new Empresa();
        InitialContext ctx;

        if (validar()) {

            try {
                ctx = new InitialContext();
                REmpresaRemote empresa = (REmpresaRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/REmpresa");
                
                company.setNome(txtEmpresa.getText());
                company.setSenha(txtSenha.getText());
                company.setBairro(txtBairro.getText());
                company.setCidade(String.valueOf(cbCidade.getSelectedItem()));
                company.setTelefone(txtTel.getText());
                company.setCnpj(txtCNPJ.getText());
                company.setResponsavelRH(txtResponsavel.getText());
                company.setEndereco(txtEndereco.getText());
                company.setDDD(txtDDD.getText());
                company.setEstado(String.valueOf(cbEstado.getSelectedItem()));
                company.setAreaatuacao(String.valueOf(cbArea.getSelectedItem()));

                if (empresa.consultar(company) == null) {
                    empresa.incluir(company);
                    JOptionPane.showMessageDialog(this, "Empresa Cadastrada com Sucesso");
                    Login login = new Login();
                    login.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Empresa já existe");
                }
            } catch (NamingException ex) {
                System.out.println("Erro de Transação");
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAreaActionPerformed

    private static boolean ValidarCNPJ(String cnpj) {
        boolean ret = false;
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("/", "");
        cnpj = cnpj.replace("-", "");
        String base = "00000000000000";
        if (cnpj.length() <= 14) {
            if (cnpj.length() < 14) {
                cnpj = base.substring(0, 14 - cnpj.length()) + cnpj;
            }

            int soma = 0;
            int dig = 0;
            String cnpj_calc = cnpj.substring(0, 12);
            char[] chr_cnpj = cnpj.toCharArray();
            // Primeira parte  
            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
            // Segunda parte  
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
            ret = cnpj.equals(cnpj_calc);

        }
        return ret;
    }

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void txtCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCNPJFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCNPJFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnFinalizar;
    private javax.swing.JComboBox cbArea;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtDDD;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTel;
    // End of variables declaration//GEN-END:variables

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

        if (ValidarCNPJ(txtCNPJ.getText())) {

            if (txtEmpresa.getText().trim().equals("")
                    || txtCNPJ.getText().trim().equals("")
                    || cbEstado.getSelectedItem().equals("Selecione")
                    || cbArea.getSelectedItem().equals("Selecione")
                    || txtBairro.getText().trim().equals("")
                    || txtEndereco.getText().trim().equals("")
                    || txtDDD.getText().trim().equals("")
                    || txtTel.getText().trim().equals("")
                    || txtResponsavel.getText().trim().equals("")
                    || cbCidade.getSelectedItem().equals("Selecione")
                    || txtSenha.getText().trim().equals("")) {

                JOptionPane.showMessageDialog(this, "Preencher todos os campos!");
                return false;

            }
        } else {
            JOptionPane.showMessageDialog(this, "CNPJ inválido!");
            return false;
        }
        return true;

    }
}