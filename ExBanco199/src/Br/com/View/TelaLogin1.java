
package Br.com.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Br.com.Dao.ConexaoDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class TelaLogin1 extends javax.swing.JFrame {
    
        
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        public void logar (){
              String sql = "select * from tb_usuarios where login = ? and senha = ? ";

        try {
            //preparar a consulta no banco, em funcao do que foi inserido
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtusuario.getText());
            pst.setString(2, txtsenha.getText());
            //executar a query
            rs = pst.executeQuery();
            
            if (rs.next()) {
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);  
            }else{
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalidos");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Tela de login" + e);
        }
    }

        
        
    public TelaLogin1() {
        
        initComponents();
        conexao = ConexaoDAO.Conector();
        if(conexao != null){
           lblstatus.setText("Conectado");
           ImageIcon conectado = new ImageIcon("src/Icones/check_56109444444444.png");
           lblstatus.setIcon(conectado);
        }else{
            lblstatus.setText("Desconectado");
            ImageIcon desconectado = new ImageIcon("src/Icones/square_1403431999999999.png");
            lblstatus.setIcon(desconectado);
        }
        System.out.println(conexao);
    }

    //matheus
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtsenha = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        lblstatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 63, -1));

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 243, 29));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel2.setText("Senha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        txtsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 242, 29));

        btnlogin.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btnlogin.setText("Entrar");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        lblstatus.setText("status");
        getContentPane().add(lblstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
      
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsenhaActionPerformed
        
    }//GEN-LAST:event_txtsenhaActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
         logar();
    }//GEN-LAST:event_btnloginActionPerformed

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JTextField txtsenha;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
