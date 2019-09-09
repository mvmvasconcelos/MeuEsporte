/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import controle.Controle;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author marcus.vasconcelos
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    Controle c = new Controle();
    int idSelecionado;
    int idTimeAntigo;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        JOptionPane.showMessageDialog(this, "Obs: por falta de tempo hábil, não implementei \n"
                                          + "a validação de dados. Porém como já havia feito\n"
                                          + "nas atividades anteriores, não creio que seja um problema!");
    }
    
    private void limpaTimes(){
        //Procura por todos os JTextFields dentro do referido jPanel e define o texto deles como vazio
        for (Component component : painelTimes.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
    }
    
    private void limpaJogadores(){
        for (Component component : painelJogadores.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
    }
    
    private void voltarPrincipalJogador(){
        painelJogadores.setVisible(false);
        painelPrincipal.setVisible(true);
        limpaJogadores();
        c.listarJogadores(tabelaPrincipal);
    }
    
    private void voltarPrincipalTime(){
        painelTimes.setVisible(false);
        painelPrincipal.setVisible(true);
        limpaTimes();
        c.listarTimes(tabelaPrincipal);
    }
    
    public void formJogador(){
        painelPrincipal.setVisible(false);
        painelJogadores = new javax.swing.JPanel();
        lblNJogador = new javax.swing.JLabel();
        txtJogador = new javax.swing.JTextField();
        lblPosJogador = new javax.swing.JLabel();
        txtPosicao = new javax.swing.JTextField();
        comboTime = new javax.swing.JComboBox<>();
        lblTimeJogador = new javax.swing.JLabel();
        btnCadastraJogador = new javax.swing.JButton();
        btnVoltarJogador = new javax.swing.JButton();
        
        painelJogadores.setPreferredSize(new java.awt.Dimension(426, 142));

        lblNJogador.setText("Nome do Jogador");
        lblPosJogador.setText("Posição");
        lblTimeJogador.setText("Time");
        btnCadastraJogador.setText("Cadastrar");
        btnVoltarJogador.setText("Voltar");
        
        javax.swing.GroupLayout painelJogadoresLayout = new javax.swing.GroupLayout(painelJogadores);
        painelJogadores.setLayout(painelJogadoresLayout);
        painelJogadoresLayout.setHorizontalGroup(
            painelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelJogadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNJogador)
                    .addComponent(txtJogador)
                    .addComponent(lblPosJogador)
                    .addComponent(txtPosicao, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(painelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboTime, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimeJogador)
                    .addGroup(painelJogadoresLayout.createSequentialGroup()
                        .addComponent(btnCadastraJogador)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltarJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        painelJogadoresLayout.setVerticalGroup(
            painelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelJogadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNJogador)
                    .addComponent(lblTimeJogador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPosJogador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPosicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastraJogador)
                    .addComponent(btnVoltarJogador))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(painelJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
        
        if (c.getListaTimes().isEmpty()) {
            comboTime.addItem("Nenhum time cadastrado");
            
        } else {
            for (int i = 0; i < Controle.listaTimes.size(); i++) {
                comboTime.addItem(Controle.listaTimes.get(i).getNomeTime());
            }
        }
        
        btnVoltarJogador.addActionListener((arg0) -> {
            voltarPrincipalJogador();
        });
        
        btnCadastraJogador.addActionListener((arg0) -> {
            if (c.getListaTimes().isEmpty() && btnCadastraJogador.getText() != "Editar jogador") {
                c.cadastrarJogador(txtJogador.getText(), txtPosicao.getText(), tabelaPrincipal);                    
                JOptionPane.showMessageDialog(this, "Jogador cadastrado!");
                
            } else if(btnCadastraJogador.getText() != "Editar jogador") {
                c.cadastrarJogador(txtJogador.getText(), txtPosicao.getText(), comboTime.getSelectedIndex(), tabelaPrincipal);
                JOptionPane.showMessageDialog(this, "Jogador cadastrado!");
            } else {
                c.editarJogador(txtJogador.getText(), txtPosicao.getText(), comboTime.getSelectedIndex(), idSelecionado, idTimeAntigo, tabelaPrincipal);
                JOptionPane.showMessageDialog(this, "Jogador alterado!");
            }
            voltarPrincipalJogador();
        });
    }
    
    public void editaJogador(int id){
        formJogador();        
        txtJogador.setText(Controle.listaJogadores.get(id).getNomeJogador());
        txtPosicao.setText(Controle.listaJogadores.get(id).getPosicao());
        if (c.idTime(id) > -1) {
            comboTime.setSelectedIndex(c.idTime(id));
            idTimeAntigo = c.idTime(id);
        }
        btnCadastraJogador.setText("Editar jogador");
        
    }
    
    public void exibeTime(int id){
        if (Controle.listaTimes.get(id).getJogadores().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há jogadores");
        } else {            
            formTime();
            c.listarTimeCompleto(tabelaPrincipal, id);
            txtTime.setText(Controle.listaTimes.get(id).getNomeTime());
            txtTecnico.setText(Controle.listaTimes.get(id).getTecnico());
            btnCadastraTime.setVisible(false);
        }
    }
    
    public void formTime(){
        painelPrincipal.setVisible(false);
        painelTimes = new javax.swing.JPanel();
        lblNTime = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        lblNTecnico = new javax.swing.JLabel();
        txtTecnico = new javax.swing.JTextField();
        btnCadastraTime = new javax.swing.JButton();
        btnVoltarTime = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelTimes.setPreferredSize(new java.awt.Dimension(426, 142));

        lblNTime.setText("Nome do Time");

        lblNTecnico.setText("Nome do Técnico");

        btnCadastraTime.setText("Cadastrar");

        btnVoltarTime.setText("Voltar");

        javax.swing.GroupLayout painelTimesLayout = new javax.swing.GroupLayout(painelTimes);
        painelTimes.setLayout(painelTimesLayout);
        painelTimesLayout.setHorizontalGroup(
            painelTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTimesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNTime)
                    .addComponent(txtTime)
                    .addComponent(lblNTecnico)
                    .addComponent(txtTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(btnCadastraTime)
                .addGap(18, 18, 18)
                .addComponent(btnVoltarTime, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        painelTimesLayout.setVerticalGroup(
            painelTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTimesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNTecnico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastraTime)
                    .addComponent(btnVoltarTime))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(painelTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
        
        btnVoltarTime.addActionListener((arg0) -> {
            voltarPrincipalTime();            
        });
        
        btnCadastraTime.addActionListener((arg0) -> {
           c.cadastrarTime(txtTime.getText(), txtTecnico.getText(), tabelaPrincipal);
           JOptionPane.showMessageDialog(this, "Time cadastrado com sucesso!");
           voltarPrincipalTime();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPrincipal = new javax.swing.JTable();
        painelPrincipal = new javax.swing.JPanel();
        btnListarJogadores = new javax.swing.JButton();
        btnCriarJogadores = new javax.swing.JButton();
        btncListarTimes = new javax.swing.JButton();
        btnCadastrarJogador = new javax.swing.JButton();
        btnCadastrarTime = new javax.swing.JButton();
        btnCriarTimes = new javax.swing.JButton();
        btnLimparConsulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 400));
        setResizable(false);

        tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Posição", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPrincipal.getTableHeader().setReorderingAllowed(false);
        tabelaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPrincipal);
        if (tabelaPrincipal.getColumnModel().getColumnCount() > 0) {
            tabelaPrincipal.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        btnListarJogadores.setText("Listar Jogadores");
        btnListarJogadores.setPreferredSize(new java.awt.Dimension(100, 25));
        btnListarJogadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarJogadoresActionPerformed(evt);
            }
        });

        btnCriarJogadores.setText("Criar jogadores");
        btnCriarJogadores.setPreferredSize(new java.awt.Dimension(100, 25));
        btnCriarJogadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarJogadoresActionPerformed(evt);
            }
        });

        btncListarTimes.setText("Listar Times");
        btncListarTimes.setPreferredSize(new java.awt.Dimension(100, 25));
        btncListarTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncListarTimesActionPerformed(evt);
            }
        });

        btnCadastrarJogador.setText("Cadastrar Jogador");
        btnCadastrarJogador.setPreferredSize(new java.awt.Dimension(100, 25));
        btnCadastrarJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarJogadorActionPerformed(evt);
            }
        });

        btnCadastrarTime.setText("Cadastrar Time");
        btnCadastrarTime.setPreferredSize(new java.awt.Dimension(100, 25));
        btnCadastrarTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTimeActionPerformed(evt);
            }
        });

        btnCriarTimes.setText("Criar times");
        btnCriarTimes.setPreferredSize(new java.awt.Dimension(100, 25));
        btnCriarTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarTimesActionPerformed(evt);
            }
        });

        btnLimparConsulta.setText("Limpar Consulta");
        btnLimparConsulta.setPreferredSize(new java.awt.Dimension(100, 25));
        btnLimparConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListarJogadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarJogador, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(btncListarTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCadastrarTime, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCriarTimes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btnCriarJogadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncListarTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(btnCriarJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriarTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Meu Esporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarJogadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarJogadoresActionPerformed
        c.criarJogadores(tabelaPrincipal);
    }//GEN-LAST:event_btnCriarJogadoresActionPerformed

    private void btnLimparConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparConsultaActionPerformed
        c.limparTabelaAtual(tabelaPrincipal);
    }//GEN-LAST:event_btnLimparConsultaActionPerformed

    private void btnListarJogadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarJogadoresActionPerformed
        c.listarJogadores(tabelaPrincipal);
    }//GEN-LAST:event_btnListarJogadoresActionPerformed

    private void btnCriarTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarTimesActionPerformed
        c.criarTimes(tabelaPrincipal);
    }//GEN-LAST:event_btnCriarTimesActionPerformed

    private void btncListarTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncListarTimesActionPerformed
        c.listarTimes(tabelaPrincipal);
    }//GEN-LAST:event_btncListarTimesActionPerformed

    private void tabelaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPrincipalMouseClicked
        if (evt.getClickCount() == 2) {
            idSelecionado = (int) tabelaPrincipal.getValueAt(tabelaPrincipal.getSelectedRow(), 0);
            if (Controle.exibeJogador) {
                painelPrincipal.setVisible(false);
                editaJogador(idSelecionado);
            } else {                
                exibeTime(idSelecionado);
            }
            
        }
    }//GEN-LAST:event_tabelaPrincipalMouseClicked

    private void btnCadastrarJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarJogadorActionPerformed
        painelPrincipal.setVisible(false);
        formJogador();
    }//GEN-LAST:event_btnCadastrarJogadorActionPerformed

    private void btnCadastrarTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarTimeActionPerformed
        painelPrincipal.setVisible(false);
        formTime();
    }//GEN-LAST:event_btnCadastrarTimeActionPerformed
    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    //Variáveis do cadastro de técnico
    private javax.swing.JButton btnCadastraTime;
    private javax.swing.JButton btnVoltarTime;
    private javax.swing.JLabel lblNTecnico;
    private javax.swing.JLabel lblNTime;
    private javax.swing.JPanel painelTimes;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtTime;
    
    //Variáveis do cadastro jogador
    private javax.swing.JButton btnCadastraJogador;
    private javax.swing.JButton btnVoltarJogador;
    private javax.swing.JComboBox<String> comboTime;
    private javax.swing.JLabel lblNJogador;
    private javax.swing.JLabel lblPosJogador;
    private javax.swing.JLabel lblTimeJogador;
    private javax.swing.JPanel painelJogadores;
    private javax.swing.JTextField txtJogador;
    private javax.swing.JTextField txtPosicao;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarJogador;
    private javax.swing.JButton btnCadastrarTime;
    private javax.swing.JButton btnCriarJogadores;
    private javax.swing.JButton btnCriarTimes;
    private javax.swing.JButton btnLimparConsulta;
    private javax.swing.JButton btnListarJogadores;
    private javax.swing.JButton btncListarTimes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTable tabelaPrincipal;
    // End of variables declaration//GEN-END:variables

    
}
