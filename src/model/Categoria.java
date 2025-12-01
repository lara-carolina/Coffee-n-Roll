package model;

public enum Categoria {

    DOCES("Doces"),
    SALGADOS("Salgados"),
    BEBIDAS("Bebidas");

    private final String nome;

    Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
