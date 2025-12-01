package dao;

import model.Categoria;
import model.SubCategoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubCategoriaDAO {

    // Inserir nova subcategoria
    public void inserirSubCategoria(SubCategoria subcategoria) {
        String sql = "INSERT INTO subcategorias (nome, categoria_id) " +
                "VALUES (?, (SELECT id FROM categorias WHERE nome = ?))";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, subcategoria.name());
            stmt.setString(2, subcategoria.getCategoria().name());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir subcategoria: " + e.getMessage());
        }
    }

    // Atualizar subcategoria
    public void atualizarSubCategoria(int id, SubCategoria subcategoria) {
        String sql = "UPDATE subcategorias SET nome = ?, categoria_id = " +
                "(SELECT id FROM categorias WHERE nome = ?) WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, subcategoria.name());
            stmt.setString(2, subcategoria.getCategoria().name());
            stmt.setInt(3, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar subcategoria: " + e.getMessage());
        }
    }

    // Excluir subcategoria
    public void excluirSubCategoria(int id) {
        String sql = "DELETE FROM subcategorias WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir subcategoria: " + e.getMessage());
        }
    }

    // Buscar subcategorias por categoria
    public List<SubCategoria> buscarPorCategoria(Categoria categoria) {
        List<SubCategoria> lista = new ArrayList<>();

        String sql = "SELECT nome FROM subcategorias WHERE categoria_id = " +
                "(SELECT id FROM categorias WHERE nome = ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.name());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                SubCategoria sub = SubCategoria.valueOf(nome);
                lista.add(sub);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar subcategorias: " + e.getMessage());
        }

        return lista;
    }
}
