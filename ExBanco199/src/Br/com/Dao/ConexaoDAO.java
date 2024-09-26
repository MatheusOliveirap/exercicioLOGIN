package Br.com.Dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDao {
    public static Connection Conector(){
        
       java.sql.Connection conexao = null;      
       String driver = "com.mysql.jdbc.Driver";     
       String url = "jdbc:mysql://localhost:3306/projetologin";       
       String user = "root";      
       String password = "root";
       
       try{
           
           Class.forName(driver);
           conexao = DriverManager.getConnection(url,user, password);
           return conexao;
           
       }catch (Exception e){
           
           JOptionPane.showMessageDialog(null,"Conexao" + e);
           return null;      
       }  
    }
}
