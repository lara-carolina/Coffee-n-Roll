import dao.Conexao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConnection()) {
            System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}