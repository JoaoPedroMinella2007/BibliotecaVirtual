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

public class LivroDAO extends GenericDAO{
    
   
    // Cadastrar livro
    public static boolean cadastrarLivro(String titulo, String autor, String editora, String isbn,
                                         String categoria, String descricao, LocalDate anoPublicacao,
                                         LocalDate dataCadastro) {

        String sql = "INSERT INTO livros (titulo, autor, editora, isbn, categoria, descricao, anoPublicacao, dataCadastro) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setString(3, editora);
            stmt.setString(4, isbn);
            stmt.setString(5, categoria);
            stmt.setString(6, descricao);

            if (anoPublicacao != null) {
                stmt.setDate(7, Date.valueOf(anoPublicacao));
            } else {
                stmt.setNull(7, java.sql.Types.DATE);
            }

            if (dataCadastro != null) {
                stmt.setDate(8, Date.valueOf(dataCadastro));
            } else {
                stmt.setNull(8, java.sql.Types.DATE);
            }

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Deletar livro
    public static boolean deletarLivro(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos os livros
    public static List<Livro> listarTodos() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("editora"),
                        rs.getString("isbn"),
                        rs.getString("categoria"),
                        rs.getString("descricao"),
                        rs.getDate("anoPublicacao") != null ? rs.getDate("anoPublicacao").toLocalDate() : null,
                        rs.getDate("dataCadastro") != null ? rs.getDate("dataCadastro").toLocalDate() : null
                );
                livros.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    // Atualizar livro
    public static void atualizarLivro(Livro livro) {
        String sql = "UPDATE livros SET titulo=?, autor=?, editora=?, isbn=?, categoria=?, descricao=?, anoPublicacao=?, dataCadastro=? WHERE id=?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setString(4, livro.getIsbn());
            stmt.setString(5, livro.getCategoria());
            stmt.setString(6, livro.getDescricao());

            if (livro.getAnoPublicacao() != null) {
                stmt.setDate(7, Date.valueOf(livro.getAnoPublicacao()));
            } else {
                stmt.setNull(7, java.sql.Types.DATE);
            }

            if (livro.getDataCadastro() != null) {
                stmt.setDate(8, Date.valueOf(livro.getDataCadastro()));
            } else {
                stmt.setNull(8, java.sql.Types.DATE);
            }

            stmt.setInt(9, livro.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar livro.", e);
        }
    }

    // Verificar se o banco está online
    public boolean bancoOnline() {
        try (Connection conn = conectarDAO()) {
            return conn != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}

    

