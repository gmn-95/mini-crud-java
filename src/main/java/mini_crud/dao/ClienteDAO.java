package mini_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mini_crud.conexaoPostgresql.Conexao;
import mini_crud.model.Cliente;
import mini_crud.model.Telefone;

/**
 *
 * @author gustavo
 */
public class ClienteDAO {
    private final Connection connection;
	
    public ClienteDAO() {
            connection = Conexao.getConnection();
    }

    public void criar(Cliente cliente) throws SQLException {
        String sql2 = "insert into cliente (cpf_pessoa) values (?)";

        try {
            if(new PessoaDAO().clienteExistente(cliente)){
                throw new SQLException();
                
            }
            else{
                new PessoaDAO().criar(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            throw new SQLException("Cliente já existe");
            
        }
            
        try {
            PreparedStatement statement = connection.prepareStatement(sql2);
            statement.setString(1, cliente.getCpf());

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

    public void deletar(Long id) {

        try {

            new TelefoneDAO().deletar(id); 
            String cpf = new PessoaDAO().acharCpf(id);

            String sqlDeletarCliente = "delete from cliente where id_cliente = " + id;

            PreparedStatement statement = connection.prepareStatement(sqlDeletarCliente);
            
            
            statement.execute();
            connection.commit();
            
            new PessoaDAO().deletar(cpf);

            

        } catch (Exception e) {
            e.printStackTrace();
            try {
                    connection.rollback();
            } catch (SQLException e1) {
                    e1.printStackTrace();
            }
        }


    }

    public void atualizar(Cliente cliente, Telefone telefone, String antigoTelefone) {
            try {
                    
                    new TelefoneDAO().atualizar(telefone, antigoTelefone);

                    new PessoaDAO().atualizar(cliente);

            } catch (Exception e) {
                    e.printStackTrace();
                    try {
                            connection.rollback();
                    } catch (SQLException e1) {
                            e1.printStackTrace();
                    }
            }

    }
    
    public List<Cliente> buscaPorId(Long id) {
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where cliente.id_cliente = " + id + " AND pessoa.cpf = cliente.cpf_pessoa AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cpf"), resultSet.getString("email"));
                cliente.setId(resultSet.getLong("id_cliente"));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
        
        return clientes;
    }
    
    public List<Cliente> buscaPorNome(String nome){
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            
            String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where LOWER(pessoa.nome) Like LOWER('%" + nome + "%') AND pessoa.cpf = cliente.cpf_pessoa AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cpf"), resultSet.getString("email"));
                cliente.setId(resultSet.getLong("id_cliente"));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return clientes;
    }
    
    public List<Cliente> buscaPorEmail(String email){
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            
            String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where  pessoa.email = '" + email + "' AND pessoa.cpf = cliente.cpf_pessoa AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cpf"), resultSet.getString("email"));
                cliente.setId(resultSet.getLong("id_cliente"));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return clientes;
    }
    
    public List<Cliente> buscaPorCpf(String cpf){
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            
            String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where  pessoa.cpf = '" + cpf + "' AND pessoa.cpf = cliente.cpf_pessoa AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cpf"), resultSet.getString("email"));
                cliente.setId(resultSet.getLong("id_cliente"));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return clientes;
    }
    
    public List<Cliente> buscaPorDescricao(String descricao){
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            
            String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where LOWER(telefone.descricao) Like LOWER('%" + descricao + "%') AND pessoa.cpf = cliente.cpf_pessoa AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cpf"), resultSet.getString("email"));
                cliente.setId(resultSet.getLong("id_cliente"));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return clientes;
    }
    
    public List<Cliente> buscaPorTelefone(String telefone){
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            
            String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where telefone.numero = '" + telefone + "' AND pessoa.cpf = cliente.cpf_pessoa AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cpf"), resultSet.getString("email"));
                cliente.setId(resultSet.getLong("id_cliente"));
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return clientes;
    }
    
    public List<Cliente> listaCliente(){
            List<Cliente> clientes = new ArrayList<Cliente>();

            try {
                String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email, ";
                sql += "telefone.numero, telefone.descricao ";
                sql += "FROM cliente, pessoa, telefone ";
                sql += "where cliente.cpf_pessoa = pessoa.cpf AND cliente.id_cliente = telefone.id_cliente ORDER By cliente.id_cliente, telefone.id_telefone";

                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {

                        Cliente cliente = new Cliente(resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cpf"), resultSet.getString("email"));
                        cliente.setId(resultSet.getLong("id_cliente"));
                        clientes.add(cliente);
                }

                return clientes;

            } catch (Exception e) {
                    e.printStackTrace();
                    try {
                            connection.rollback();
                    } catch (SQLException e1) {
                            e1.printStackTrace();
                    }
            }

            return clientes;

    }

}
