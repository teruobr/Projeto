/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bean.Universidade;
import interfaces.RUniversidadeRemote;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Thiago
 */
public class ManutencaoUniversidade extends javax.swing.JFrame {

    /**
     * Creates new form ManutencaoUniversidade
     */
    private AtualizaUniversidade atualiza = new AtualizaUniversidade();
    
    private List<Universidade> lista;
    
    private DefaultTableModel modelo;
    
    public ManutencaoUniversidade() {
        initComponents();
        centralizar();
        setResizable(false);
        atualizarUniversidade();
        removerUniversidade();
        setTitle("Projeto Interdisciplinar II");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtUniversidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        universidadeTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Universidade");

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtUniversidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniversidadeActionPerformed(evt);
            }
        });

        universidadeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(universidadeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(txtUniversidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel1)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        InitialContext ctx = null;
        modelo = (DefaultTableModel) universidadeTable.getModel();
        modelo.setNumRows(0);

        try {
            ctx = new InitialContext();
            RUniversidadeRemote areas = (RUniversidadeRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RUniversidade");
            ManutencaoUniversidade.CorLabel corLabel = new ManutencaoUniversidade.CorLabel();
            corLabel.setForeground(Color.BLUE);
            universidadeTable.getColumnModel().getColumn(1).setCellRenderer(corLabel);
            universidadeTable.getColumnModel().getColumn(2).setCellRenderer(corLabel);

            lista = areas.consultar();

            if (lista != null && !lista.isEmpty()) {
                for (int i = 0; i < lista.size(); i++) {
                    JLabel labelAlt = new JLabel("Alterar");
                    JLabel label = new JLabel("Remover");
                    labelAlt.setForeground(Color.BLUE);
                    label.setForeground(Color.BLUE);
                    Object[] row = {String.valueOf(lista.get(i).getNome()), labelAlt.getText(), label.getText()};
                    modelo.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Não existem universidades cadastradas pelo Administrador!");
            }
        } catch (NamingException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AppAdm app = new AppAdm();
        app.setVisible(true);
        app.getLogado();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (validarTxtUnversidade()) {
            InitialContext ctx;
            try {
                ctx = new InitialContext();
                RUniversidadeRemote universidade = (RUniversidadeRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RUniversidade");
                Universidade uni = new Universidade();
                uni.setNome(txtUniversidade.getText());
                
                //Aqui verificar se universidade já existe
                
                //if (areas.consultar(company) == null) {
                universidade.incluir(uni);
                JOptionPane.showMessageDialog(this, "Universidade Cadastrada com sucesso!");
                txtUniversidade.setText("");      
                jButton3ActionPerformed(null);
            } catch (NamingException ex) {
                System.out.println("Erro de Transação");
                Logger.getLogger(ManutencaoUniversidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUniversidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniversidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniversidadeActionPerformed

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
            java.util.logging.Logger.getLogger(ManutencaoUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManutencaoUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManutencaoUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManutencaoUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ManutencaoUniversidade().setVisible(true);
            }
        });
    }
    public boolean validarTxtUnversidade() {
        if (txtUniversidade.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor, preencher a universidade!");
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
    
    public void removerUniversidade() {
        universidadeTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && universidadeTable.getSelectedColumn() == 2) {
                    chamaPerguntaRemocaoUniversidade();
                }
            }
        });
    }
    
    public void chamaPerguntaRemocaoUniversidade() {
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que remover esta universidade?", "Mensagem do Sistema", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            InitialContext ctx = null;
            try {
                ctx = new InitialContext();
                RUniversidadeRemote uni = (RUniversidadeRemote) ctx.lookup("java:global/ProjetoInterdisciplinarII/ProjetoInterdisciplinarII-ejb/RUniversidade");
                uni.excluir(lista.get(universidadeTable.getSelectedRow()));
                JOptionPane.showMessageDialog(this, "Universidade removida com sucesso!");
                jButton3ActionPerformed(null);                
            } catch (NamingException ex) {
                Logger.getLogger(ManutencaoAtuacao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public void atualizarUniversidade() {
        universidadeTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && universidadeTable.getSelectedColumn() == 1) {
                    atualiza.setUniversidade(lista.get(universidadeTable.getSelectedRow()));                    
                    if (!atualiza.isVisible()) {
                        atualiza.setVisible(true);
                    }
                    dispose();
                }
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtUniversidade;
    private javax.swing.JTable universidadeTable;
    // End of variables declaration//GEN-END:variables
}
