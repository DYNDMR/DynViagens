package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
  Connection conn = null;
  PreparedStatement pstm = null;

  public void saveCliente(Cliente cliente) {

    // Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar no banco
    // de dados

	  String sql = "INSERT INTO cliente(nome,cpf,email,senha,sexo)" +  "VALUES(?,?,?,?,?)";

    try {
      // Cria uma conexão com o banco
      conn = Conexao.createConnectionToMySQL();
      // Cria um PreparedStatment, classe usada para executar a query
      pstm = conn.prepareStatement(sql);

      pstm.setString(1, cliente.getNome());
      pstm.setString(2, cliente.getCPF());
      pstm.setString(3, cliente.getEmail());
      // Adicionar o valor do segundo parâmetro da sql
      pstm.setString(4, cliente.getSenha());
      pstm.setString(5, cliente.getSexo());
      System.out.println(pstm);

      // Executa a sql para inserção dos dados
      pstm.execute();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Fecha as conexões
      try {
        if (pstm != null) {

          pstm.close();
        }

        if (conn != null) {
          conn.close();
        }

      } catch (Exception e) {

        e.printStackTrace();
      }
    }
  }

  public void removeByid(int id) {

    String sql = "DELETE FROM cliente where id = ?";

    try {
      conn = Conexao.createConnectionToMySQL();
      // cria conexao

      pstm = conn.prepareStatement(sql);
      // passa o comando sql para o objeto pstm
      pstm.setInt(1, id);
      // seta o id no comando sql
      pstm.execute();
      // executa o comando sql que está no objeto pstm
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Fecha as conexões
      try {
        if (pstm != null) {

          pstm.close();
        }

        if (conn != null) {
          conn.close();
        }

      } catch (Exception e) {

        e.printStackTrace();
      }
    }
  }

  public void update(Cliente cliente) {

    // Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar no banco
    // de dados

    String sql = "UPDATE cliente SET id= ?,nome = ?,email = ?,CPF = ?"
        + "WHERE id=?";

    try {
      // Cria uma conexão com o banco
      conn = Conexao.createConnectionToMySQL();
      // Cria um PreparedStatment, classe usada para executar a query
      pstm = conn.prepareStatement(sql);

      // Adiciona o valor do primeiro parâmetro da sql
      // Adiciona o valor do segundo parâmetro
      pstm.setDouble(1, cliente.getId());
      //
      pstm.setString(2, cliente.getNome());
      //
      pstm.setString(3, cliente.getEmail());
      //
      pstm.setString(4, cliente.getCPF());
      //
      pstm.setInt(5, cliente.getId());

      // Executa a sql para inserção dos dados
      pstm.execute();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Fecha as conexões
      try {
        if (pstm != null) {

          pstm.close();
        }

        if (conn != null) {
          conn.close();
        }

      } catch (Exception e) {

        e.printStackTrace();
      }
    }
  }

  public List<Cliente> getClientes(String emailDig) {

      String sql = "SELECT email,senha FROM Cliente WHERE email = ?";

      List<Cliente> cli = new ArrayList<>();

      // Classe que vai recuperar os dados do banco de dados
      ResultSet rset = null;

      try {
        conn = Conexao.createConnectionToMySQL();

        pstm = conn.prepareStatement(sql);
        pstm.setString(1, emailDig);
        rset = pstm.executeQuery();

        // Enquanto existir dados no banco de dados, faça
        while (rset.next()) {

          Cliente cliente = new Cliente();
          

          cliente.setEmail(rset.getString("email"));
          cliente.setSenha(rset.getString("senha"));

          
          cli.add(cliente);
        }
      } catch (Exception e) {

        e.printStackTrace();
      } finally {

        try {

          if (rset != null) {

            rset.close();
          }

          if (pstm != null) {

            pstm.close();
          }

          if (conn != null) {
            conn.close();
          }

        } catch (Exception e) {

          e.printStackTrace();
        }
      }

      return cli;
    }

}
