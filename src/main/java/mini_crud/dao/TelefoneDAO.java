package mini_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mini_crud.conexaoPostgresql.Conexao;
import mini_crud.model.Cliente;
import mini_crud.model.Telefone;

/**
 * @author gustavo
 */
public class TelefoneDAO {
    private final Connection connection;
	
    public TelefoneDAO() {
            connection = Conexao.getConnection();
    }

    public void criar(Telefone telefone, Cliente cliente) {
           
        Long id = null;
        try {

            String sql = "SELECT cliente.id_cliente from cliente, pessoa where pessoa.cpf = '" + cliente.getCpf() + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                id = resultSet.getLong("id_cliente");
                telefone.setId(id);
            }

            String sql2 = "insert into telefone(numero, descricao, id_cliente) values (?,?,?)";
            statement = connection.prepareStatement(sql2);

            statement.setString(1, telefone.getNumero());
            statement.setString(2, telefone.getDescricao());
            statement.setLong(3, id);

            statement.execute();
            connection.commit();

        } catch (Exception e) {
                e.printStackTrace();
                try {
                        connection.rollback();
                } catch (SQLException e1) {
                        e1.printStackTrace();
                }
        }
    }
    
    public void criar(Telefone telefone){
        try {
            String sql = "insert into telefone(numero, descricao, id_cliente) values (?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, telefone.getNumero());
            statement.setString(2, telefone.getDescricao());
            statement.setLong(3, telefone.getId_usuario());
            
            statement.execute();
            connection.commit();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public String deletar(Long id, String numero) {
        try {
            String acharTelefone = "select id_cliente from telefone where id_cliente = " + id;
            PreparedStatement statement = connection.prepareStatement(acharTelefone);
            ResultSet resultSet = statement.executeQuery();
            
            int cont = 0;
            while(resultSet.next()){
                cont++;
            }
            
            if(cont > 1){
                
                String sqlDeletarTelefone = "delete from telefone where id_cliente = " + id + " AND telefone.numero = '" + numero + "'";

                statement = connection.prepareStatement(sqlDeletarTelefone);
                statement.execute();
                connection.commit();
               
            }
            else{
                return "O cliente deve conter ao menos 1 telefone para contato!";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                    connection.rollback();
            } catch (SQLException e1) {
                    e1.printStackTrace();
            }
    }
        return null;
    }
     
    public void deletar(Long id) {
        try {
            String acharTelefone = "select id_cliente from telefone where id_cliente = " + id;
            PreparedStatement statement = connection.prepareStatement(acharTelefone);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                if(resultSet != null) {
                    String sqlDeletarTelefone = "delete from telefone where id_cliente = " + id;

                    statement = connection.prepareStatement(sqlDeletarTelefone);
                    statement.execute();
                    connection.commit();

                }
        }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                    connection.rollback();
            } catch (SQLException e1) {
                    e1.printStackTrace();
            }
    }

    }

    protected void atualizar(Telefone telefone, String antigoTelefone) {
            try {
                    String sql = "update telefone set numero = '" + telefone.getNumero() + "', descricao = '" 
                    + telefone.getDescricao() + "' where id_cliente = " + telefone.getId_usuario() 
                    + " AND telefone.numero = '" + antigoTelefone + "'";
                 
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sql);
                    
                    connection.commit();
            } catch (Exception e) {
                    e.printStackTrace();
                    try {
                            connection.rollback();
                    } catch (SQLException e1) {
                            e1.printStackTrace();
                    }
            }
    }
    
    public List<Telefone> buscaPorID(Long id){
        List<Telefone> telefones = new ArrayList<Telefone>();
        try {
            String sql = "SELECT telefone.numero, telefone.descricao ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where cliente.id_cliente = " + id + " AND cliente.id_cliente = telefone.id_cliente AND pessoa.cpf = cliente.cpf_pessoa ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Telefone telefone = new Telefone(resultSet.getString("numero"), resultSet.getString("descricao"));
                telefones.add(telefone);
            }
            
            return telefones;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        
        return telefones;
    }
    
    public List<Telefone> buscaPorNome(String nome){
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        try {
            String sql = "SELECT telefone.numero, telefone.descricao ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where LOWER(pessoa.nome) Like LOWER('%" + nome + "%') AND cliente.id_cliente = telefone.id_cliente AND pessoa.cpf = cliente.cpf_pessoa ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Telefone telefone = new Telefone(resultSet.getString("numero"), resultSet.getString("descricao"));
                telefones.add(telefone);
            }
            
            return telefones;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        
        return telefones;
    }
    
    public List<Telefone> buscaPorEmail(String email){
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        try {
            String sql = "SELECT telefone.numero, telefone.descricao ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where pessoa.email = '" + email + "' AND cliente.id_cliente = telefone.id_cliente AND pessoa.cpf = cliente.cpf_pessoa ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Telefone telefone = new Telefone(resultSet.getString("numero"), resultSet.getString("descricao"));
                telefones.add(telefone);
            }
            
            return telefones;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        
        return telefones;
    }
    
    public List<Telefone> buscaPorCpf(String cpf){
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        try {
            String sql = "SELECT telefone.numero, telefone.descricao ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where pessoa.cpf = '" + cpf + "' AND cliente.id_cliente = telefone.id_cliente AND pessoa.cpf = cliente.cpf_pessoa ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Telefone telefone = new Telefone(resultSet.getString("numero"), resultSet.getString("descricao"));
                telefones.add(telefone);
            }
            
            return telefones;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        
        return telefones;
    }
    
    public List<Telefone> buscaPorDescricao(String descricao){
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        try {
            String sql = "SELECT telefone.numero, telefone.descricao ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where LOWER(telefone.descricao) Like LOWER('%" + descricao + "%') AND cliente.id_cliente = telefone.id_cliente AND pessoa.cpf = cliente.cpf_pessoa ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Telefone telefone = new Telefone(resultSet.getString("numero"), resultSet.getString("descricao"));
                telefones.add(telefone);
            }
            
            return telefones;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        
        return telefones;
    }
    
    public List<Telefone> buscaPorTelefone (String numeroTelefone){
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        try {
            String sql = "SELECT telefone.numero, telefone.descricao ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where telefone.numero = '" + numeroTelefone + "' AND cliente.id_cliente = telefone.id_cliente AND pessoa.cpf = cliente.cpf_pessoa ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Telefone telefone = new Telefone(resultSet.getString("numero"), resultSet.getString("descricao"));
                telefones.add(telefone);
            }
            
            return telefones;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        
        return telefones;
    }
    
    public List<Telefone> listaTelefone(){
            List<Telefone> telefones = new ArrayList<Telefone>();

            try {
                String sql = "SELECT cliente.id_cliente, telefone.numero, telefone.descricao ";
                sql += "FROM cliente, pessoa, telefone ";
                sql += "where cliente.cpf_pessoa = pessoa.cpf AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";

                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {

                    Telefone telefone = new Telefone(resultSet.getString("numero"), resultSet.getString("descricao"), resultSet.getLong("id_cliente"));
                    telefones.add(telefone);
                }

                return telefones;

            } catch (Exception e) {
                e.printStackTrace();
                try {
                        connection.rollback();
                } catch (SQLException e1) {
                        e1.printStackTrace();
                }
            }

            return telefones;

    }
}
