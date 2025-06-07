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

public class UsuarioDAO extends GenericDAO{
    
    
    // Método para cadastrar usuarios 
    public static boolean cadastrarUsuario(String login, String senha, String perfil, String nome, String sobrenome, LocalDate dataNascimento){
        
           String sql = "INSERT INTO usuarios (login, senha, perfil, nome, sobrenome, dataNascimento) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoBD.conectar()) {

        if (conn == null) {
            System.out.println("Conexão com o banco falhou.");
            return false;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setString(3, perfil);
            stmt.setString(4, nome);
            stmt.setString(5, sobrenome);
 
            if (dataNascimento != null) {
                stmt.setDate(6, java.sql.Date.valueOf(dataNascimento));
            } else {
                stmt.setNull(6, java.sql.Types.DATE);
            }

            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
            return linhasAfetadas > 0;

        }

    } catch (SQLException e) {
        System.out.println("Erro ao executar a query:");
        e.printStackTrace();
        return false;
    }
    
}
    
    // Método para deletar usuarios
    public static boolean deletarUsuarios(int id) {
          String sql = "DELETE FROM usuarios WHERE id = ?";

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
    
    // Novo método para listar os usuarios
     public static List<Usuario> listarTodos() {
        List<Usuario> listagemUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario user = new Usuario(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("perfil"),
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getDate("dataNascimento").toLocalDate()
                );
                listagemUsuarios.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listagemUsuarios;
    }
     
      public static void atualizarUsuario(Usuario usuario) throws SQLException {
        
        String sql = "UPDATE usuarios SET login=?, senha=?, perfil=?, nome=?, sobrenome=?, dataNascimento=? WHERE id=?"; 
                
        try(Connection conn = ConexaoBD.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getPerfil());
            stmt.setString(4, usuario.getPerfil());
            stmt.setString(5, usuario.getNome());
            stmt.setString(5, usuario.getSobrenome());
            stmt.setDate(5, Date.valueOf(usuario.getDataNascimento()));    
            stmt.setInt(7, usuario.getId());
       
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
            
            throw new RuntimeException("Erro ao atualizar usuario.", e);
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

    public Usuario autenticar(String login, String senha) {
       String sql = "SELECT * FROM usuarios WHERE login=? AND senha=?";
       Usuario usuario = null;

    try (Connection con = conectarDAO();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, login);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Crie o objeto com todos os dados necessários, se desejar
            usuario = new Usuario(
                    
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("senha"),
                rs.getString("perfil"),
                rs.getString("nome"),
                rs.getString("sobrenome"),
                rs.getDate("dataNascimento").toLocalDate()
            );
        }

        rs.close();
    } catch (SQLException e) {
        e.printStackTrace(); // Isso ajuda a entender o que deu errado
    }

    return usuario; // Vai retornar null se não encontrar
}
    
}
