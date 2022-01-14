package mini_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mini_crud.conexaoPostgresql.Conexao;
import mini_crud.model.Cliente;

/**
 * @author gustavo
 */
public class PessoaDAO {
    private Connection connection;
	
    public PessoaDAO() {
            connection = Conexao.getConnection();
    }

    public void criar(Cliente cliente) throws SQLException{
        
        String sql = "insert into pessoa(nome, idade, cpf, email) values (?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setInt(2, cliente.getIdade());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getEmail());

        statement.execute();
        connection.commit();
    }

    public void deletar(String cpf) {
        try {

            String sqlDeletarPessoa = "delete from pessoa where cpf = '" + cpf + "'";
            PreparedStatement statement = connection.prepareStatement(sqlDeletarPessoa);
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

    protected void atualizar(Cliente cliente) {
        try {

            String sql = "update pessoa set nome = '" + cliente.getNome() + "', idade = " + cliente.getIdade()+ ", email = '" + cliente.getEmail() + "' where cpf = '" + cliente.getCpf() + "'";
            Statement statement = connection.createStatement();
      
            statement.executeUpdate(sql);
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                    connection.rollback();
            } catch (SQLException e1) {
                    e1.printStackTrace();
            }
        }
    }
    
    protected String acharCpf(Long id) {
        try {
            String acharCpf = "select cpf_pessoa from cliente where id_cliente = " + id;

            PreparedStatement statement = connection.prepareStatement(acharCpf);
            ResultSet resultSet = statement.executeQuery();
            String cpf = "";

            while(resultSet.next()) {
                    cpf = resultSet.getString("cpf_pessoa");
            }

            return cpf;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                    connection.rollback();
            } catch (SQLException e1) {
                    e1.printStackTrace();
            }
        }
        return null;
    }
    
    protected boolean clienteExistente (Cliente cliente){
        
        try {
            String sql = "SELECT cliente.id_cliente, pessoa.nome, pessoa.idade, pessoa.cpf, pessoa.email, ";
            sql += "telefone.numero, telefone.descricao ";
            sql += "FROM cliente, pessoa, telefone ";
            sql += "where pessoa.cpf = '" + cliente.getCpf() + "' AND cliente.id_cliente = telefone.id_cliente AND pessoa.cpf = cliente.cpf_pessoa ORDER By cliente.id_cliente, telefone.id_telefone";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                if(resultSet.getString("cpf").equals(cliente.getCpf())){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
