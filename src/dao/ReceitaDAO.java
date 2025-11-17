package dao;

import model.Receita;
import model.Categoria;
import model.SubCategoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    // Inserir nova receita
    public void inserirReceita(Receita receita) {
        String sql = "INSERT INTO receitas (nome, categoria_id, subcategoria_id, ingredientes, modo_preparo) " +
                "VALUES (?, (SELECT id FROM categorias WHERE nome = ?), (SELECT id FROM subcategorias WHERE nome = ?), ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, receita.getNome());
            stmt.setString(2, receita.getCategoria().name());
            stmt.setString(3, receita.getSubCategoria().name());
            stmt.setString(4, receita.getIngredientes());
            stmt.setString(5, receita.getModoPreparo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir receita: " + e.getMessage());
        }
    }

    // Atualizar receita
    public void atualizarReceita(Receita receita) {
        String sql = "UPDATE receitas SET nome = ?, categoria_id = (SELECT id FROM categorias WHERE nome = ?), " +
                "subcategoria_id = (SELECT id FROM subcategorias WHERE nome = ?), ingredientes = ?, modo_preparo = ? " +
                "WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, receita.getNome());
            stmt.setString(2, receita.getCategoria().name());
            stmt.setString(3, receita.getSubCategoria().name());
            stmt.setString(4, receita.getIngredientes());
            stmt.setString(5, receita.getModoPreparo());
            stmt.setInt(6, receita.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar receita: " + e.getMessage());
        }
    }

    // Excluir receita
    public void excluirReceita(int id) {
        String sql = "DELETE FROM receitas WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir receita: " + e.getMessage());
        }
    }

    // Filtra as receitas
    public List<Receita> buscarPorFiltro(Categoria categoria, SubCategoria subcategoria) {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT r.id, r.nome, r.ingredientes, r.modo_preparo " +
                "FROM receitas r " +
                "JOIN categorias c ON r.categoria_id = c.id " +
                "JOIN subcategorias s ON r.subcategoria_id = s.id " +
                "WHERE c.nome = ? AND s.nome = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.name());
            stmt.setString(2, subcategoria.name());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String ingredientes = rs.getString("ingredientes");
                String modoPreparo = rs.getString("modo_preparo");

                Receita receita = new Receita(id, nome, categoria, subcategoria, ingredientes, modoPreparo);
                receitas.add(receita);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar receitas: " + e.getMessage());
        }

        return receitas;
    }
}
