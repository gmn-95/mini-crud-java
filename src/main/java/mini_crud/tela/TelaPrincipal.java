package mini_crud.tela;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;

import mini_crud.dao.ClienteDAO;
import mini_crud.dao.TelefoneDAO;
import mini_crud.model.Cliente;
import mini_crud.model.Telefone;

/**
 * @author gustavo
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoIdade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        campoCpf = new javax.swing.JFormattedTextField();
        btLimpar = new javax.swing.JButton();
        campoDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btExluirTelefone = new javax.swing.JButton();
        campoTelefone = new javax.swing.JFormattedTextField();
        btAddTelefone = new javax.swing.JButton();
        jId = new javax.swing.JLabel();
        campoID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tiposPesquisa = new javax.swing.JComboBox<>();
        campoPesquisa = new javax.swing.JFormattedTextField();
        btPesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("mini_crud");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome");

        jLabel3.setText("E-mail");

        jLabel4.setText("Idade");

        campoIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdadeActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefone");

        jLabel6.setText("Cpf");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        try {
            campoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCpfActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel7.setText("Descrição");

        btExluirTelefone.setText("Excluir Telefone");
        btExluirTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExluirTelefoneActionPerformed(evt);
            }
        });

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefoneActionPerformed(evt);
            }
        });

        btAddTelefone.setText("Add telefone");
        btAddTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddTelefoneActionPerformed(evt);
            }
        });

        jId.setText("ID");

        campoID.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(campoDescricao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jId))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNome)
                                    .addComponent(campoTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(campoEmail)
                                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExluirTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btEditar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAddTelefone)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jId, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btLimpar)
                    .addComponent(btAddTelefone))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btExluirTelefone)
                    .addComponent(btEditar))
                .addGap(16, 16, 16))
        );

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Idade", "Cpf", "Telefone", "Descrição", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);
        if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
            tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tiposPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome", "CPF", "Email", "Telefone", "Descrição" }));
        tiposPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposPesquisaActionPerformed(evt);
            }
        });

        campoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisaActionPerformed(evt);
            }
        });

        btPesquisa.setIcon(new javax.swing.ImageIcon("/home/gustavo/NetBeansProjects/mini_crud/img/motor-de-pesquisa.png")); // NOI18N
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tiposPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPesquisa)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tiposPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tiposPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposPesquisaActionPerformed

        formatarCampoPesquisa();
          
    }//GEN-LAST:event_tiposPesquisaActionPerformed

    public void formatarCampoPesquisa(){
        if(tiposPesquisa.getSelectedIndex() == 0){
            campoPesquisa.setEditable(false);
        }
        else{
            campoPesquisa.setEditable(true);
        }
           
        switch (tiposPesquisa.getSelectedIndex()) {
            case 3:
                try {
                    
                    MaskFormatter mask = new MaskFormatter("###.###.###-##");
                    campoPesquisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mask));
                    campoPesquisa.commitEdit();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                break;
            
            case 5:
                try {
                    MaskFormatter mask = new MaskFormatter("(##)#####-####");
                    campoPesquisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mask));
                    campoPesquisa.commitEdit();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                break;
         
            default:
                
                JFormattedTextField.AbstractFormatter abs = new DefaultFormatter();
                campoPesquisa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(abs));
                campoPesquisa.setText("");
                
                try {
                    campoPesquisa.commitEdit();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }
            
    private void pesquisarTodos() {
        ClienteDAO dao = new ClienteDAO();
        TelefoneDAO dao2 =  new TelefoneDAO();
        
        tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(1);
        tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(90);
        tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(7);

        List<Cliente> clientes = dao.listaCliente();
        List<Telefone> telefones = dao2.listaTelefone();
       
        montarTabela(clientes, telefones);
    }
    
    private void pesquisaPorId(Long id){
        ClienteDAO dao = new ClienteDAO();
        TelefoneDAO dao2 =  new TelefoneDAO();

        List<Cliente> clientes = dao.buscaPorId(id);
        List<Telefone> telefones = dao2.buscaPorID(id);
        
        montarTabela(clientes, telefones);
    }
    
    private void pesquisaPorNome(String nome){
        ClienteDAO dao = new ClienteDAO();
        TelefoneDAO dao2 =  new TelefoneDAO();

        List<Cliente> clientes = dao.buscaPorNome(nome);
        List<Telefone> telefones = dao2.buscaPorNome(nome);
        
        montarTabela(clientes, telefones);
    }
    
    private void pesquisaPorEmail(String email){
        ClienteDAO dao = new ClienteDAO();
        TelefoneDAO dao2 =  new TelefoneDAO();

        List<Cliente> clientes = dao.buscaPorEmail(email);
        List<Telefone> telefones = dao2.buscaPorEmail(email);
        
        montarTabela(clientes, telefones);
    }
    
    private void pesquisaPorCpf(String cpf){
        ClienteDAO dao = new ClienteDAO();
        TelefoneDAO dao2 =  new TelefoneDAO();

        List<Cliente> clientes = dao.buscaPorCpf(cpf);
        List<Telefone> telefones = dao2.buscaPorCpf(cpf);
        
        montarTabela(clientes, telefones);
    } 
    
    private void pesquisarPorDescricao(String descricao){
        ClienteDAO dao = new ClienteDAO();
        TelefoneDAO dao2 =  new TelefoneDAO();

        List<Cliente> clientes = dao.buscaPorDescricao(descricao);
        List<Telefone> telefones = dao2.buscaPorDescricao(descricao);
        
        montarTabela(clientes, telefones);
    }
    
    private void pesquisarPorTelefone(String telefone){
        ClienteDAO dao = new ClienteDAO();
        TelefoneDAO dao2 =  new TelefoneDAO();

        List<Cliente> clientes = dao.buscaPorTelefone(telefone);
        List<Telefone> telefones = dao2.buscaPorTelefone(telefone);
        
        montarTabela(clientes, telefones);
    }
    
    private void montarTabela(List<Cliente> clientes, List<Telefone> telefones){
        
        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        model.setNumRows(0);
        
        if(!clientes.isEmpty()){
            for(int i = 0; i < clientes.size(); i++){
                model.addRow(new Object[]{
                    clientes.get(i).getId(),
                    clientes.get(i).getNome(),
                    clientes.get(i).getIdade(),
                    clientes.get(i).getCpf(),
                    telefones.get(i).getNumero(),
                    telefones.get(i).getDescricao(),
                    clientes.get(i).getEmail()
                });
            }
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        campoPesquisa.setEditable(false);
        campoPesquisa.setText("");   
        pesquisarTodos();    
    }//GEN-LAST:event_formWindowOpened

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
       
        try {
            switch (tiposPesquisa.getSelectedIndex()) {
            case 0: // Todos
                pesquisarTodos();      
                break;
                
            case 1: // ID
                Long id = Long.valueOf(campoPesquisa.getText());
                pesquisaPorId(id);
                break;
            
            case 2: // Nome
                String nome = campoPesquisa.getText().toLowerCase();
                pesquisaPorNome(nome);
                break;
            
            case 3: // cpf
                String cpf = campoPesquisa.getText();
                pesquisaPorCpf(cpf);
                break;
                
            case 4: //email
                String email = campoPesquisa.getText();
                pesquisaPorEmail(email);
                break;
            
            case 5: // telefone
                String telefone = campoPesquisa.getText();
                pesquisarPorTelefone(telefone);
                break;
            
            case 6: // descrição
                String descricao = campoPesquisa.getText().toLowerCase();
                pesquisarPorDescricao(descricao);
                break;
                
        }
       
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void campoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaActionPerformed
        
    }//GEN-LAST:event_campoPesquisaActionPerformed

    private void btAddTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddTelefoneActionPerformed
        
        int row = tabelaClientes.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        
        if(row < 0){
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado",
                "Selecione um cliente", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(btAddTelefone.getText().equals("Add telefone")){
                btSalvar.setEnabled(false);
                campoNome.setText(String.valueOf(model.getValueAt(row, 1)));
                campoNome.setEditable(false);

                campoIdade.setText(String.valueOf(model.getValueAt(row, 2)));
                campoIdade.setEditable(false);

                campoCpf.setText(String.valueOf(model.getValueAt(row, 3)));
                campoCpf.setEditable(false);

                campoEmail.setText(String.valueOf(model.getValueAt(row, 6)));
                campoEmail.setEditable(false);

                campoID.setText(String.valueOf(model.getValueAt(row, 0)));
                campoID.setEditable(false);

                campoTelefone.setText("");
                campoDescricao.setText("");
                
                btAddTelefone.setText("Salvar Telefone");
            }
            else{
                if(campoTelefone.getText().equals("(  )     -    ")){
                    JOptionPane.showMessageDialog(this, "Campo Vazio",
                    "Informe um telefone", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Long id = Long.valueOf(campoID.getText());

                    Telefone telefone = new Telefone(campoTelefone.getText(), campoDescricao.getText(), id);
                    TelefoneDAO dao = new TelefoneDAO();
                    dao.criar(telefone);
                    
                    pesquisarTodos();

                    btLimparActionPerformed(evt);
                }
            }   
        }
    }//GEN-LAST:event_btAddTelefoneActionPerformed
 
    private void campoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefoneActionPerformed
        
    }//GEN-LAST:event_campoTelefoneActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        campoNome.setText("");
        campoNome.setEditable(true);
        
        campoIdade.setText("");
        campoIdade.setEditable(true);
        
        campoCpf.setText("");
        campoCpf.setEditable(true);
        
        campoEmail.setText("");
        campoEmail.setEditable(true);
        
        campoTelefone.setText("");
        campoTelefone.setEditable(true);
        
        campoDescricao.setText("");
        campoDescricao.setEditable(true);
        
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(true);
        campoID.setText("");
        btAddTelefone.setText("Add telefone");
    }//GEN-LAST:event_btLimparActionPerformed
  
    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int row = tabelaClientes.getSelectedRow();

        if(row < 0){
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado",
                "Selecione um cliente", JOptionPane.ERROR_MESSAGE);
        }
        else{
            DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();

            campoNome.setText(String.valueOf(model.getValueAt(row, 1)));
            campoIdade.setText(String.valueOf(model.getValueAt(row, 2)));
            campoCpf.setText(String.valueOf(model.getValueAt(row, 3)));
            campoCpf.setEditable(false);
            campoDescricao.setText(String.valueOf(model.getValueAt(row, 5)));
            campoEmail.setText(String.valueOf(model.getValueAt(row, 6)));
            campoTelefone.setText(String.valueOf(model.getValueAt(row, 4)));
            campoID.setText(String.valueOf(model.getValueAt(row, 0)));

            btSalvar.setText("Atualizar");
            
            antigoTelefone = campoTelefone.getText();
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int row = tabelaClientes.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();

        if(row < 0){
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado",
                "Selecione um cliente", JOptionPane.ERROR_MESSAGE);
        }
        else{
            
            int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
            if(confirmar == 0){
                String idSemEspaco = model.getValueAt(row, 0).toString().replaceAll("\\s+", "");
                Long id = Long.parseLong(idSemEspaco);
                new ClienteDAO().deletar(id);
                 pesquisarTodos();
            }
           
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        String campoVazio = String.valueOf(campoTelefone.getText().charAt(1));

        if("".equals(campoNome.getText()) || "".equals(campoCpf.getText()) ||
            "".equals(campoEmail.getText()) || "".equals(campoIdade.getText()) || campoVazio.equals(" ")){

            JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if("Salvar".equals(btSalvar.getText())){

                try {
                    ClienteDAO dao = new ClienteDAO();
                    TelefoneDAO dao2 = new TelefoneDAO();

                    Cliente cliente = new Cliente(campoNome.getText(), Integer.valueOf(campoIdade.getText()), campoCpf.getText(), campoEmail.getText());
                    Telefone telefone = new Telefone(campoTelefone.getText(), campoDescricao.getText());

                    try {
                        dao.criar(cliente);
                        dao2.criar(telefone, cliente);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "cliente já existe");
                    }

                    campoNome.setText("");
                    campoIdade.setText("");
                    campoCpf.setText("");
                    campoEmail.setText("");
                    campoTelefone.setText("");
                    campoDescricao.setText("");

                    pesquisarTodos();
                } catch (HeadlessException | NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            else{
                
                Cliente cliente = new Cliente(campoNome.getText(), Integer.valueOf(campoIdade.getText()), campoCpf.getText(), campoEmail.getText());
                Telefone telefone = new Telefone(campoTelefone.getText(), campoDescricao.getText(), Long.valueOf(campoID.getText()));
                
                ClienteDAO dao = new ClienteDAO();
                
                dao.atualizar(cliente, telefone, antigoTelefone);
                
                btLimparActionPerformed(evt);
                pesquisarTodos();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void campoIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdadeActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
 
    }//GEN-LAST:event_formWindowActivated

    private void btExluirTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExluirTelefoneActionPerformed
        TelefoneDAO dao = new TelefoneDAO();
        
        int row = tabelaClientes.getSelectedRow();
        Long id = Long.valueOf(tabelaClientes.getValueAt(row, 0).toString());
        
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
        
        if(confirmar == 0){
             String mesage = dao.deletar(id, tabelaClientes.getValueAt(row, 4).toString());
            if(mesage == null){
                JOptionPane.showMessageDialog(null, "Número apagado com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(null, mesage);
            }
            pesquisarTodos();
        }
       
    }//GEN-LAST:event_btExluirTelefoneActionPerformed

    private void campoCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCpfActionPerformed
        campoCpf.setText("");
        try {
            campoCpf.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_campoCpfActionPerformed

    private String antigoTelefone = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddTelefone;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btExluirTelefone;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoIdade;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoPesquisa;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JLabel jId;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JComboBox<String> tiposPesquisa;
    // End of variables declaration//GEN-END:variables
}
