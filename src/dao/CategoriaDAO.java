package dao;

import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void inserirCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nome) VALUES (?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }

    public void atualizarCategoria(int id, Categoria categoria) {
        String sql = "UPDATE categorias SET nome = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar categoria: " + e.getMessage());
        }
    }

    public void excluirCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir categoria: " + e.getMessage());
        }
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT nome FROM categorias";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome").toUpperCase();

                Categoria categoria = Categoria.valueOf(nome);
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
        }

        return categorias;
    }
}
