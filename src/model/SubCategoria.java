package model;

public enum SubCategoria {

    COM_FRUTAS(Categoria.DOCES),
    COM_CHOCOLATE(Categoria.DOCES),
    FRITOS(Categoria.SALGADOS),
    ASSADOS(Categoria.SALGADOS),
    CAFES(Categoria.BEBIDAS),
    CREMES(Categoria.BEBIDAS);

    private final Categoria categoria;

    SubCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
