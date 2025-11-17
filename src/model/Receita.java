package model;

public class Receita {
    private int id;
    private String nome;
    private Categoria categoria;
    private SubCategoria subCategoria;
    private String ingredientes;
    private String modoPreparo;

    public Receita(int id, String nome, Categoria categoria, SubCategoria subCategoria,
                   String ingredientes, String modoPreparo) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
    }

    public Receita(String nome, Categoria categoria, SubCategoria subCategoria,
                   String ingredientes, String modoPreparo) {
        this.nome = nome;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public SubCategoria getSubCategoria() { return subCategoria; }
    public void setSubCategoria(SubCategoria subCategoria) { this.subCategoria = subCategoria; }

    public String getIngredientes() { return ingredientes; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }

    public String getModoPreparo() { return modoPreparo; }
    public void setModoPreparo(String modoPreparo) { this.modoPreparo = modoPreparo; }

    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                ", subCategoria=" + subCategoria +
                ", ingredientes='" + ingredientes + '\'' +
                ", modoPreparo='" + modoPreparo + '\'' +
                '}';
    }
}
