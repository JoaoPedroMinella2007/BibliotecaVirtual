package Model;

import dao.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO extends GenericDAO{
    
    //Método para cadastrar clientes no banco de dados
    public static boolean cadastrarCliente(String nome, String sobrenome, String cpf, String email, String endereco, String telefone, LocalDate dataNascimento, LocalDate dataCadastro){
        
        String sql = "INSERT INTO clientes (nome, sobrenome, cpf, email, endereco, telefone, dataNascimento, dataCadastro) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection conn = ConexaoBD.conectar()) {

            if (conn == null) {
                System.out.println("Conexão com o banco falhou.");
                return false;
            }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, cpf);
            stmt.setString(4, email);
            stmt.setString(5, endereco);
            stmt.setString(6, telefone);
            
            if(dataNascimento != null) {
                stmt.setDate(7, java.sql.Date.valueOf(dataNascimento));
            }else{
                stmt.setNull(7, java.sql.Types.DATE);
            }
            
            if(dataCadastro != null) {
                stmt.setDate(8, java.sql.Date.valueOf(dataCadastro));
            }else{
                stmt.setNull(8, java.sql.Types.DATE);
            }
         
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
            return linhasAfetadas > 0;
        }

        }catch(SQLException e) {
            System.out.println("Erro ao executar a query: ");
            e.printStackTrace();
        return false;
        }
        
    }
    
    //Método para deletar o cliente no banco de dados 
    public static boolean deletarCliente(int id){
        
        String sql = "DELETE FROM clientes WHERE id=?";
        
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);  // Atribui o ID que queremos deletar
            int linhasAfetadas = stmt.executeUpdate();  // Executa o DELETE

            return linhasAfetadas > 0;  // Se o valor for maior que 0, quer dizer que algo foi deletado
        } catch (SQLException e) {
            e.printStackTrace();  // Se houver erro, exibe no console
            return false;  // Retorna false caso aconteça algum erro
        }       
    }
    
    public static List<Clientes> listarTodos() throws SQLException{
        
        List<Clientes> listagemClientes = new ArrayList<>();
        
        String sql = "SELECT * FROM clientes";
        
        try(Connection conn = ConexaoBD.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
        while(rs.next()){
            Clientes cliente = new Clientes(      
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("sobrenome"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("endereco"),
                rs.getString("telefone"),
                rs.getDate("dataAniversario").toLocalDate(),
                rs.getDate("dataCadastro").toLocalDate()      
          ); 
            
        listagemClientes.add(cliente);     
        }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listagemClientes;     
    }
        
    public static void atualizarClientes(Clientes cliente) throws SQLException{
        
        String sql = "UPDATE clientes SET nome=?, sobrenome=?, cpf=?, email=?, endereco=?, telefone=?, dataNascimento=?, dataCadastro=? WHERE id=?";
        
        try(Connection conn = ConexaoBD.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(1, cliente.getSobrenome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());
            stmt.setDate(6, Date.valueOf(cliente.getDataNascimento()));
            stmt.setDate(7, Date.valueOf(cliente.getDataCadastro()));
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
            
            throw new RuntimeException("Erro ao atualizar cliente.", e);
        }
    }
    
    public boolean bancoOnline() {
        
        Connection conn = conectarDAO();
        if(conn != null){
            try{
                conectarDAO().close();
            }catch(SQLException e){
                
            }
            return true;
        }else{
            return false;
        }
    }

    
    
}
